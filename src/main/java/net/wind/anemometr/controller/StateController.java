package net.wind.anemometr.controller;

import net.wind.anemometr.dto.StateDto;
import net.wind.anemometr.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices/{deviceId}/states")
public class StateController {
    private final StateService stateService;

    public StateController(final StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<StateDto>> getAllByDevice(@PathVariable("deviceId") final Long deviceId) {
        List<StateDto> states = stateService.getStatesByDeviceId(deviceId);
        return ResponseEntity.ok(states);
    }

    @PostMapping
    public ResponseEntity addCurrentState(@RequestBody final StateDto stateDto) {
        stateService.addCurrentState(stateDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
