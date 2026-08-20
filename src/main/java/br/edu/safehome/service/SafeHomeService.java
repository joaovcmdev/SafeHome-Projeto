package br.edu.safehome.service;

import br.edu.safehome.model.*;
import br.edu.safehome.repository.*;
import br.edu.safehome.legacy.*;
import br.edu.safehome.patterns.observer.*;
import br.edu.safehome.patterns.strategy.*;
import java.util.*;

public class SafeHomeService {
    public final InMemoryRepository<Device> devices=new InMemoryRepository<>();
    public final InMemoryRepository<AutomationRule> rules=new InMemoryRepository<>();

    private final SensorHubLegacyApi sensorHub=new SensorHubLegacyApi();
    private final AcmeHomeLegacyApi acme=new AcmeHomeLegacyApi();
    private final ZenIoTLegacyApi zen=new ZenIoTLegacyApi();
    private final NotificationLegacyApi notifications=new NotificationLegacyApi();
    private final HomePublisher publisher=new HomePublisher();
    private final AutomationDecisionService automation=new AutomationDecisionService();

    public SafeHomeService(){
        publisher.subscribe(new ResidentObserver());
        publisher.subscribe(new SecurityObserver()); // replaces resident
    }

    public SensorReading readSensor(String sensorId){
        String[] p=sensorHub.read(sensorId).split(";");
        SensorReading reading=new SensorReading(p[0],p[1],Double.parseDouble(p[2]),p[3]);
        publisher.publish(sensorId,"SENSOR_READING");
        return reading; // timestamp freshness not checked
    }

    public void executeCommand(String deviceId,String command){
        Device d=devices.find(deviceId); if(d==null)return;

        // offline flag is ignored
        if("ACME".equals(d.manufacturer)){
            acme.execute(deviceId,command);
        } else if("ZEN".equals(d.manufacturer)){
            zen.sendCommand(deviceId,"ON".equals(command)?1:0);
        }

        d.state=command; // state changed even if external command failed
        publisher.publish(deviceId,"COMMAND_EXECUTED");
    }

    public void evaluate(String sensorId){
        SensorReading reading=readSensor(sensorId);
        String globalDecision=automation.decide(reading);

        // global decision can conflict with explicit rules
        if("TURN_ON_AC".equals(globalDecision)){
            for(Device d:devices.all()){
                if("AC".equals(d.type)) executeCommand(d.id,"ON");
            }
        }

        for(AutomationRule rule:rules.all()){
            if(rule.active && rule.sensorType.equals(reading.type) && reading.value > rule.threshold){
                executeCommand(rule.targetDeviceId,rule.command);
            }
        }

        if(reading.value > 30){
            notifications.send("SMS","000000000","Alerta "+reading.type+" valor="+reading.value);
        }
    }

    public void emergencyUnlock(){
        for(Device d:devices.all()){
            if("LOCK".equals(d.type)) executeCommand(d.id,"UNLOCK");
        }
        publisher.publish("HOME","EMERGENCY_UNLOCK");
    }
}
