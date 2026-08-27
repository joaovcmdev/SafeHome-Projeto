package br.edu.safehome.patterns.abstractfactory;
import br.edu.safehome.legacy.*;
public class HomeVendorFactory {
    public Object devices(String family){return new AcmeHomeLegacyApi();}
    public Object sensors(String family){return new SensorHubLegacyApi();}
    public Object notifications(String family){return new NotificationLegacyApi();}
}
