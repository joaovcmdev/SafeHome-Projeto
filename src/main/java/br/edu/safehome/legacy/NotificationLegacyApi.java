package br.edu.safehome.legacy;
public class NotificationLegacyApi {
    public void send(String channel,String destination,String text){
        System.out.println(channel+" "+destination+" => "+text);
    }
}
