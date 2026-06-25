package io.github.ajeyaaravind.ctis.model;

import io.github.ajeyaaravind.ctis.enums.EdgeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransitEdge {

    private String edgeId;

    private Station fromStation;

    private Station toStation;

    private EdgeType edgeType;

    private double distance;

    private int travelTime;

    private double fare;

    private String lineId;

}