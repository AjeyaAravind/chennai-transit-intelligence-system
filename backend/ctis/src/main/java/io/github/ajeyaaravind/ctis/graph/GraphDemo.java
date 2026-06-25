package io.github.ajeyaaravind.ctis.graph;

import io.github.ajeyaaravind.ctis.model.TransitEdge;

import java.util.List;
import java.util.Map;

public class GraphDemo {

    public static void main(String[] args) {

        System.out.println("CTIS Graph Engine Started\n");

        NetworkBuilder builder = new NetworkBuilder();

        TransportNetwork network = builder.buildNetwork();

        System.out.println("Stations in Network : "
                + network.getStations().size());

        System.out.println();

        for (Map.Entry<String, List<TransitEdge>> entry :
                network.getAdjacencyList().entrySet()) {

            System.out.println(
                    network.getStation(entry.getKey()).getStationName());

            for (TransitEdge edge : entry.getValue()) {

                System.out.println(
                        "   -> "
                                + edge.getToStation().getStationName()
                                + " ("
                                + edge.getTravelTime()
                                + " min)"
                );

            }

            System.out.println();

        }

    }

}