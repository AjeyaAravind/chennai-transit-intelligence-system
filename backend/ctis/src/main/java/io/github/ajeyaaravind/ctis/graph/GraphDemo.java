package io.github.ajeyaaravind.ctis.graph;

public class GraphDemo {

    public static void main(String[] args) {

        System.out.println("CTIS Graph Engine Started");

        NetworkBuilder builder = new NetworkBuilder();

        TransportNetwork network = builder.buildNetwork();

        System.out.println();

        System.out.println("Stations in Network : "
                + network.getStations().size());

    }

}