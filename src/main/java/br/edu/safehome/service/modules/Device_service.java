package br.edu.safehome.service.modules;

import br.edu.safehome.legacy.AcmeHomeLegacyApi;
import br.edu.safehome.legacy.ZenIoTLegacyApi;
import br.edu.safehome.model.Device;
import br.edu.safehome.patterns.observer.HomePublisher;
import br.edu.safehome.repository.InMemoryRepository;

public class Device_service {
    private final AcmeHomeLegacyApi acme=new AcmeHomeLegacyApi();
    private final ZenIoTLegacyApi zen=new ZenIoTLegacyApi();
    private final HomePublisher publisher=new HomePublisher();
    public final InMemoryRepository<Device> devices;

    public Device_service(InMemoryRepository<Device> devices){
        this.devices=devices;
    }

    public void executeCommand(String deviceId,String command){
        Device d=devices.find(deviceId); if(d==null)return;

        if(!"ON".equals(command) && !"OFF".equals(command) && !"LOCK".equals(command) && !"UNLOCK".equals(command)){
            return;
        }

        boolean executed=false;

        if("ACME".equals(d.manufacturer)){
            acme.execute(deviceId,command);
            executed=true;

        } else if("ZEN".equals(d.manufacturer)){
            zen.sendCommand(deviceId,"ON".equals(command)?1:0);
            executed=true;
        }

        if(executed){
            d.state=command;
            publisher.publish(deviceId,"COMMAND_EXECUTED");
        }
    }
}