package com.kodilla.kodillacourse.good.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearcher {
    private FlightsFixer flightsFixer;

    public FlightSearcher(FlightsFixer flightsFixer){
        this.flightsFixer = flightsFixer;
    }

    public Set<Flights> availableFlightFrom(String departureAiport){
        return flightsFixer.getAvailableFlight().stream()
                .filter(flights -> flights.getDepartureAiport().equals(departureAiport))
                .collect(Collectors.toSet());
    }

    public Set<Flights> availableFlightTo(String destinationAiport){
        return flightsFixer.getAvailableFlight().stream()
                .filter(flights -> flights.getDestinationAiport().equals(destinationAiport))
                .collect(Collectors.toSet());
    }

    public Set<List<Flights>> allAvailableFlights(String departureAiport, String destinationAiport){
        Set<List<Flights>> setOfFlights = new HashSet<>();

        flightsFixer.getAvailableFlight().stream().filter(flights -> flights.getDepartureAiport().equals(departureAiport))
                .forEach(flights -> {
                    List<Flights> temp = flightsFixer.getAvailableFlight().stream()
                            .filter(flight ->
                                    (flights.getDestinationAiport().equals(flight.getDepartureAiport()) && flight.getDestinationAiport().equals(destinationAiport)))
                            .collect(Collectors.toList());

                    if(temp.size() > 0){
                        List<Flights> flightTour = new ArrayList<>();
                        flightTour.add(flights);
                        flightTour.addAll(temp);
                        setOfFlights.add(flightTour);
                    }
                });
        return setOfFlights;
    }
}
