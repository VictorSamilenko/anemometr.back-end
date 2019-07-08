package net.wind.anemometr.mapper;

import net.wind.anemometr.dto.StateDto;
import net.wind.anemometr.model.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StateMapper {
    StateDto toDto(State state);
    List<StateDto> toDtos(List<State> states);
    State toEntity(StateDto dto);
}
