package br.edu.safehome.service;

import br.edu.safehome.service.modules.Automation_service;
import br.edu.safehome.service.modules.Device_service;
import br.edu.safehome.service.modules.Security_service;
import br.edu.safehome.service.modules.sensor_service;

public class SafeHomeService {

    private final sensor_service sensor;
    private final Device_service device;
    private final Security_service security;


    public SafeHomeService(){

        sensor=new sensor_service();
        device=new Device_service();
        security=new Security_service();
        

    }
}