package net.wind.anemometr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "devices_id_seq")
    private Long id;
    private String imei;
    private String name;
    @Column(columnDefinition = "NUMERIC")
    private Double latitude;
    @Column(columnDefinition = "NUMERIC")
    private Double longitude;
}
