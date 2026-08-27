package br.edu.safehome.service.modules;

import br.edu.safehome.legacy.SensorHubLegacyApi;
import br.edu.safehome.model.SensorReading;
import br.edu.safehome.patterns.observer.HomePublisher;

public class sensor_service {
    private final SensorHubLegacyApi sensorHub=new SensorHubLegacyApi();
    private final HomePublisher publisher=new HomePublisher();
    public SensorReading readSensor(String sensorId){
        
        String[] p=sensorHub.read(sensorId).split(";");
        SensorReading reading=new SensorReading(p[0],p[1],Double.parseDouble(p[2]),p[3]);
        publisher.publish(sensorId,"SENSOR_READING");
        return reading; // timestamp freshness not checked

        
    }
}
