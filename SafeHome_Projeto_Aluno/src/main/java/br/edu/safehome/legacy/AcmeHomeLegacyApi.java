package br.edu.safehome.legacy;
public class AcmeHomeLegacyApi {
    public String execute(String deviceCode,String action){
        return deviceCode+"|"+action+"|OK";
    }
}
