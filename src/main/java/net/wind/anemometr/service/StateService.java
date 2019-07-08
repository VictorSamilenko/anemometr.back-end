package net.wind.anemometr.service;

import net.wind.anemometr.dto.StateDto;
import net.wind.anemometr.mapper.StateMapper;
import net.wind.anemometr.model.State;
import net.wind.anemometr.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StateService {
    private final StateRepository stateRepository;
    private final StateMapper stateMapper;

    public StateService(final StateRepository stateRepository, final StateMapper stateMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
    }

    public StateDto addCurrentState(final StateDto stateDto) {
        stateDto.setStateTime(Instant.now());
        State state = stateMapper.toEntity(stateDto);
        State savedState = stateRepository.save(state);

        return stateMapper.toDto(savedState);
    }

    public List<StateDto> getStatesByDeviceId(final long deviceId) {
        List<State> allStates = stateRepository.findAllByDeviceId(deviceId);
        return stateMapper.toDtos(allStates);
    }
}
