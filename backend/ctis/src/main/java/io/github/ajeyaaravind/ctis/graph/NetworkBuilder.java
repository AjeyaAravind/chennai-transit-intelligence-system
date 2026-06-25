package io.github.ajeyaaravind.ctis.graph;

import io.github.ajeyaaravind.ctis.model.Station;
import io.github.ajeyaaravind.ctis.repository.DataLoader;

import java.util.List;

public class NetworkBuilder {

    public TransportNetwork buildNetwork() {

        DataLoader loader = new DataLoader();

        List<Station> stations = loader.loadStations();

        TransportNetwork network = new TransportNetwork();

        for (Station station : stations) {

            network.addStation(station);

        }

        return network;

    }

}