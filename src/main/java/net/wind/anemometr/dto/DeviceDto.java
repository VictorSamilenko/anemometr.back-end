package net.wind.anemometr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDto {
    private Long id;
    private String imei;
    private String name;
    private Double latitude;
    private Double longitude;
}
