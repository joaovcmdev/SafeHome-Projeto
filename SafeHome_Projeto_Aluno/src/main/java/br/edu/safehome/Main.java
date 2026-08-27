package br.edu.safehome;
import br.edu.safehome.model.*;
import br.edu.safehome.service.*;
import br.edu.safehome.patterns.facade.*;
import br.edu.safehome.patterns.adapter.*;

public class Main {
    public static void main(String[] args){
        SafeHomeService service=new SafeHomeService();

        Device ac=new Device("AC01","ACME","AC","Sala");
        Device lock=new Device("LOCK01","ZEN","LOCK","Entrada");
        lock.online=false; // offline but command still executed
        service.devices.save(ac.id,ac);
        service.devices.save(lock.id,lock);

        service.rules.save("R1",new AutomationRule("R1","TEMPERATURE",28,"AC01","OFF"));
        service.rules.save("R2",new AutomationRule("R2","TEMPERATURE",30,"AC01","ON"));

        SafeHomeFacade facade=new SafeHomeFacade(service,new AcmeDeviceAdapter(),new ZenDeviceAdapter());
        facade.evaluate("TEMP01");
        facade.getService().emergencyUnlock();

        System.out.println("AC_STATE="+facade.getService().devices.find("AC01").state);
        System.out.println("LOCK_STATE="+facade.getService().devices.find("LOCK01").state);
    }
}
