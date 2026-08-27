package br.edu.safehome.patterns.factory;
import br.edu.safehome.model.Device;
public class DeviceFactory {
    public static Device create(String type,String id,String manufacturer,String room){
        return new Device(id,manufacturer,type,room);
    }
}
