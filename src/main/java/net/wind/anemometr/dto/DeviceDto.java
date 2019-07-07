package net.wind.anemometr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDto {
    private Long id;
    private String imei;
    private Double latitude;
    private Double longitude;
}
