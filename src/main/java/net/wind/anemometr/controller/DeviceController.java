package net.wind.anemometr.controller;

import net.wind.anemometr.dto.DeviceDto;
import net.wind.anemometr.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(final DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> getAll() {
        return ResponseEntity.ok(deviceService.getAll());
    }

    @PostMapping("/{imei}/registry")
    public ResponseEntity<Long> registry(final @PathVariable("imei") String imei) {
        long deviceId = deviceService.registry(imei);
        return ResponseEntity.ok(deviceId);
    }
}
