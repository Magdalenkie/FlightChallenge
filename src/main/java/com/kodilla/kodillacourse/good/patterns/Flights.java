package com.kodilla.kodillacourse.good.patterns;

import java.util.Objects;

public class Flights {
    private String departureAiport;
    private String destinationAiport;

    public Flights(String departureAiport, String destinationAiport){
        this.departureAiport = departureAiport;
        this.destinationAiport = destinationAiport;
    }

    public String getDepartureAiport(){
        return departureAiport;
    }

    public String getDestinationAiport(){
        return destinationAiport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return Objects.equals(departureAiport, flights.departureAiport) &&
                Objects.equals(destinationAiport, flights.destinationAiport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAiport, destinationAiport);
    }
}
