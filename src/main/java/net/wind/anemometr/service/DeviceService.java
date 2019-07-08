package net.wind.anemometr.service;


import net.wind.anemometr.dto.DeviceDto;
import net.wind.anemometr.mapper.DeviceMapper;
import net.wind.anemometr.model.Device;
import net.wind.anemometr.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class DeviceService {
    private final DeviceRepository repository;
    private final DeviceMapper deviceMapper;

    public DeviceService(final DeviceRepository repository, final DeviceMapper deviceMapper) {
        this.repository = repository;
        this.deviceMapper = deviceMapper;
    }

    public List<DeviceDto> getAll() {
        List<Device> devices = repository.findAll();

        return deviceMapper.toDtos(devices);

    }

    public long registry(final String imei) {
        Device device = repository.getFirstByImei(imei);
        if (nonNull(device)) {
            return device.getId();
        }

        device = new Device();
        device.setImei(imei);

        Device newDevice = repository.save(device);

        return newDevice.getId();
    }
}
