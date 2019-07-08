package net.wind.anemometr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "states_id_seq")
    private Long id;
    private Long deviceId;
    private Instant stateTime;
    @Column(columnDefinition = "NUMERIC")
    private Double windSpeed;
    private Integer windDirection;
}
