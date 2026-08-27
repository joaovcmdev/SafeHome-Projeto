package br.edu.safehome.service.modules;

import br.edu.safehome.legacy.NotificationLegacyApi;
import br.edu.safehome.model.AutomationRule;
import br.edu.safehome.model.Device;
import br.edu.safehome.model.SensorReading;
import br.edu.safehome.patterns.strategy.AutomationDecisionService;
import br.edu.safehome.repository.InMemoryRepository;

public class Automation_service {
    private final AutomationDecisionService automation=new AutomationDecisionService();
    private final NotificationLegacyApi notifications=new NotificationLegacyApi();
    private final sensor_service sensor=new sensor_service();
    private final Device_service device=new Device_service();
    public final InMemoryRepository<Device> devices=new InMemoryRepository<>();
    public final InMemoryRepository<AutomationRule> rules=new InMemoryRepository<>();
    
    public void evaluate(String sensorId){
        SensorReading reading=sensor.readSensor(sensorId);
        String globalDecision=automation.decide(reading);

        // global decision can conflict with explicit rules
        if("TURN_ON_AC".equals(globalDecision)){
            for(Device d:devices.all()){
                if("AC".equals(d.type)) device.executeCommand(d.id,"ON");
            }
        }

        for(AutomationRule rule:rules.all()){
            if(rule.active && rule.sensorType.equals(reading.type) && reading.value > rule.threshold){
                device.executeCommand(rule.targetDeviceId,rule.command);
            }
        }

        if(reading.value > 30){
            notifications.send("SMS","000000000","Alerta "+reading.type+" valor="+reading.value);
        }
    }
}
