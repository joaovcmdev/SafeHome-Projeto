package br.edu.safehome.model;
public class AutomationRule {
    public String id;
    public String sensorType;
    public double threshold;
    public String targetDeviceId;
    public String command;
    public boolean active=true;
    public AutomationRule(String id,String sensorType,double threshold,String targetDeviceId,String command){
        this.id=id;this.sensorType=sensorType;this.threshold=threshold;
        this.targetDeviceId=targetDeviceId;this.command=command;
    }
}
