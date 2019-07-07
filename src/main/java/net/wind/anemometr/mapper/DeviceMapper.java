package net.wind.anemometr.mapper;

import net.wind.anemometr.dto.DeviceDto;
import net.wind.anemometr.model.Device;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {
    List<DeviceDto> toDtos(List<Device> devices);
    Device toEntity(DeviceDto dto);
}
