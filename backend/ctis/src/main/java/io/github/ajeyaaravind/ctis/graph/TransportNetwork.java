package io.github.ajeyaaravind.ctis.graph;

import io.github.ajeyaaravind.ctis.model.Station;
import io.github.ajeyaaravind.ctis.model.TransitEdge;
import lombok.Getter;

import java.util.*;

@Getter
public class TransportNetwork {

    private final Map<String, Station> stations = new HashMap<>();

    private final Map<String, List<TransitEdge>> adjacencyList = new HashMap<>();

    public void addStation(Station station) {

        stations.put(station.getStationId(), station);

        adjacencyList.putIfAbsent(
                station.getStationId(),
                new ArrayList<>()
        );

    }

    public void addEdge(TransitEdge edge) {

        adjacencyList
                .get(edge.getFromStation().getStationId())
                .add(edge);

    }

    public Station getStation(String stationId) {

        return stations.get(stationId);

    }

}