package br.edu.safehome.service;

import br.edu.safehome.model.AutomationRule;
import br.edu.safehome.model.Device;
import br.edu.safehome.model.SensorReading;
import br.edu.safehome.repository.InMemoryRepository;
import br.edu.safehome.service.modules.Automation_service;
import br.edu.safehome.service.modules.Device_service;
import br.edu.safehome.service.modules.Security_service;
import br.edu.safehome.service.modules.sensor_service;

public class SafeHomeService {

    public final InMemoryRepository<Device> devices;
    public final InMemoryRepository<AutomationRule> rules;

    private final sensor_service sensor;
    private final Device_service device;
    private final Automation_service automation;
    private final Security_service security;


    public SafeHomeService(){

        devices=new InMemoryRepository<>();
        rules=new InMemoryRepository<>();

        sensor=new sensor_service();
        device=new Device_service(devices);
        automation=new Automation_service(devices,rules,device,sensor);
        security=new Security_service(devices);


    }


    public SensorReading readSensor(String sensorId){
        return sensor.readSensor(sensorId);
    }


    public void executeCommand(String deviceId,String command){
        device.executeCommand(deviceId,command);
    }


    public void evaluate(String sensorId){
        automation.evaluate(sensorId);
    }


    public void emergencyUnlock(){
        security.emergencyUnlock();
    }
}