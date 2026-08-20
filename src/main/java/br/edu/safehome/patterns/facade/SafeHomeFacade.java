package br.edu.safehome.patterns.facade;
import br.edu.safehome.service.SafeHomeService;
import br.edu.safehome.patterns.adapter.*;
public class SafeHomeFacade {
    public final SafeHomeService service;
    public final AcmeDeviceAdapter acme;
    public final ZenDeviceAdapter zen;
    public SafeHomeFacade(SafeHomeService service,AcmeDeviceAdapter acme,ZenDeviceAdapter zen){
        this.service=service;this.acme=acme;this.zen=zen;
    }
    public void evaluate(String sensorId){service.evaluate(sensorId);}
    public SafeHomeService getService(){return service;}
}
