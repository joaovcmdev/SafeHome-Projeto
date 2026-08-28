package br.edu.safehome.service.modules;

import br.edu.safehome.model.Device;
import br.edu.safehome.repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Device_servicetest {

    @Test
    void deveLigarDispositivo() {

        InMemoryRepository<Device> devices = new InMemoryRepository<>();
        Device device = new Device("lamp01", "ACME", "LIGHT", "Sala");

        devices.save(device.id, device);

        Device_service service = new Device_service(devices);

        service.executeCommand("lamp01", "ON");

        assertEquals("ON", device.state);
    }
}