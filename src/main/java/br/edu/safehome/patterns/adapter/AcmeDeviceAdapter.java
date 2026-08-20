package br.edu.safehome.patterns.adapter;
import br.edu.safehome.legacy.AcmeHomeLegacyApi;
public class AcmeDeviceAdapter extends AcmeHomeLegacyApi {
    public boolean command(String id,String command){
        return execute(id,command).endsWith("|OK");
    }
    public String raw(String id,String command){return execute(id,command);}
}
