package br.edu.safehome.patterns.adapter;
import br.edu.safehome.legacy.ZenIoTLegacyApi;
public class ZenDeviceAdapter {
    private final ZenIoTLegacyApi legacy=new ZenIoTLegacyApi();
    public boolean command(String id,String command){
        int code="ON".equals(command)?1:0;
        return legacy.sendCommand(id,code)==1;
    }
    public ZenIoTLegacyApi legacy(){return legacy;}
}
