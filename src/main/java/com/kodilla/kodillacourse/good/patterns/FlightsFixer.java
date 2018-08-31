package com.kodilla.kodillacourse.good.patterns;

import java.util.Set;

public class FlightsFixer {
    private Set<Flights> availableFlight;

    public FlightsFixer (Set<Flights> availableFlight){
        this.availableFlight = availableFlight;
    }

    public FlightsFixer(){

    }

    public Set<Flights> getAvailableFlight(){
        return availableFlight;
    }
}
