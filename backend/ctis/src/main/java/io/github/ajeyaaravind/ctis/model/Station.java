package io.github.ajeyaaravind.ctis.model;

import io.github.ajeyaaravind.ctis.enums.StationStatus;
import io.github.ajeyaaravind.ctis.enums.TransportMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    private String stationId;

    private String stationName;

    private TransportMode transportMode;

    private StationStatus stationStatus;

    private double latitude;

    private double longitude;

    private boolean interchange;

    private String hubId;

}