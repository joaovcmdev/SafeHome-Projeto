package br.edu.safehome.service.modules;

import br.edu.safehome.model.Device;
import br.edu.safehome.repository.InMemoryRepository;
import br.edu.safehome.patterns.observer.HomePublisher;


public class Security_service {

    public final InMemoryRepository<Device> devices=new InMemoryRepository<>();
    private final HomePublisher publisher=new HomePublisher();

    public void emergencyUnlock(){
        for(Device d:devices.all()){
            if("LOCK".equals(d.type)){
                d.state="UNLOCKED";
                publisher.publish(d.id,"EMERGENCY_UNLOCK");
            }
        }
    }
}
