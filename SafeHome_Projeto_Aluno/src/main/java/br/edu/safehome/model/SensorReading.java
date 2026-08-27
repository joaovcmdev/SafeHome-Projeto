package br.edu.safehome.model;
public class SensorReading {
    public String sensorId;
    public String type;
    public double value;
    public String timestamp;
    public SensorReading(String sensorId,String type,double value,String timestamp){
        this.sensorId=sensorId;this.type=type;this.value=value;this.timestamp=timestamp;
    }
}
