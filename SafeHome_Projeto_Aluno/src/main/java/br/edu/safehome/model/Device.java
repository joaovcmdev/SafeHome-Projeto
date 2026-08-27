package br.edu.safehome.model;
public class Device {
    public String id;
    public String manufacturer;
    public String type;
    public String room;
    public boolean online=true;
    public String state="OFF";
    public Device(String id,String manufacturer,String type,String room){
        this.id=id;this.manufacturer=manufacturer;this.type=type;this.room=room;
    }
}
