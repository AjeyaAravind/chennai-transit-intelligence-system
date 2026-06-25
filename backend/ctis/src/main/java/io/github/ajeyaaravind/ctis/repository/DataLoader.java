package io.github.ajeyaaravind.ctis.repository;

import io.github.ajeyaaravind.ctis.enums.StationStatus;
import io.github.ajeyaaravind.ctis.enums.TransportMode;
import io.github.ajeyaaravind.ctis.model.Station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    private static final String DATA_FOLDER = "data/";

    public List<Station> loadStations() {

        List<Station> stations = new ArrayList<>();

        String filePath = DATA_FOLDER + "metro_stations.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            reader.readLine();

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

}