package net.wind.anemometr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;

import static net.wind.anemometr.util.CommonUtils.truncate;

@Data
@NoArgsConstructor
public class StateDto {
    @NotNull
    private Long deviceId;
    private Instant stateTime;
    private Double windSpeed;
    private Integer windDirection;

    public void setStateTime(final Instant stateTime) {
        this.stateTime = truncate(stateTime);
    }
}
