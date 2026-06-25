package io.github.ajeyaaravind.ctis.repository;

import io.github.ajeyaaravind.ctis.enums.EdgeType;
import io.github.ajeyaaravind.ctis.enums.StationStatus;
import io.github.ajeyaaravind.ctis.enums.TransportMode;
import io.github.ajeyaaravind.ctis.model.Station;
import io.github.ajeyaaravind.ctis.model.TransitEdge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataLoader {

    private static final String DATA_FOLDER = "data/";

    public List<Station> loadStations() {

        List<Station> stations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(DATA_FOLDER + "metro_stations.csv"))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                Station station = new Station();

                station.setStationId(values[0]);
                station.setStationName(values[1]);
                station.setTransportMode(TransportMode.valueOf(values[2]));
                station.setHubId(values[4]);
                station.setLatitude(Double.parseDouble(values[5]));
                station.setLongitude(Double.parseDouble(values[6]));
                station.setInterchange(Boolean.parseBoolean(values[7]));
                station.setStationStatus(StationStatus.valueOf(values[8]));

                stations.add(station);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return stations;
    }

    public List<TransitEdge> loadEdges(Map<String, Station> stationMap) {

        List<TransitEdge> edges = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(DATA_FOLDER + "transit_edges.csv"))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                TransitEdge edge = new TransitEdge();

                edge.setEdgeId(values[0]);
                edge.setFromStation(stationMap.get(values[1]));
                edge.setToStation(stationMap.get(values[2]));
                edge.setEdgeType(EdgeType.valueOf(values[3]));
                edge.setLineId(values[4]);
                edge.setDistance(Double.parseDouble(values[5]));
                edge.setTravelTime(Integer.parseInt(values[6]));
                edge.setFare(Double.parseDouble(values[7]));

                edges.add(edge);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return edges;

    }

}