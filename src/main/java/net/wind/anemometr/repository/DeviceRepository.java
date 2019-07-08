package net.wind.anemometr.repository;

import net.wind.anemometr.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device getFirstByImei(String imei);
}
