package io.github.ajeyaaravind.ctis.graph;

import io.github.ajeyaaravind.ctis.model.Station;
import io.github.ajeyaaravind.ctis.model.TransitEdge;
import io.github.ajeyaaravind.ctis.repository.DataLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkBuilder {

    public TransportNetwork buildNetwork() {

        DataLoader loader = new DataLoader();

        List<Station> stations = loader.loadStations();

        TransportNetwork network = new TransportNetwork();

        Map<String, Station> stationMap = new HashMap<>();

        for (Station station : stations) {

            network.addStation(station);
            stationMap.put(station.getStationId(), station);

        }

        List<TransitEdge> edges = loader.loadEdges(stationMap);

        for (TransitEdge edge : edges) {

            network.addEdge(edge);

        }

        return network;

    }

}