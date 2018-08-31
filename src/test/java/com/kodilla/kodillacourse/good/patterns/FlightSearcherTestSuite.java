package com.kodilla.kodillacourse.good.patterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightSearcherTestSuite {
    private static FlightSearcher flightSearcher;
    private static FlightsFixer flightsFixerMock;
    private static Set<Flights> availableFlight;

    @Before
    public void beforeClass(){
        flightsFixerMock = mock(FlightsFixer.class);
        flightSearcher = new FlightSearcher(flightsFixerMock);
        availableFlight = new HashSet<>();

        availableFlight.add(new Flights("Warsaw", "Wroclaw"));
        availableFlight.add(new Flights("Krakow", "Bialystok"));
        availableFlight.add(new Flights("Warsaw", "Gdansk"));
        availableFlight.add(new Flights("Krakow", "Warsaw"));
        availableFlight.add(new Flights("Warsaw", "Bialystok"));

    }

    @Test
    public void getAvailableFlightsFromTest(){
        //given
        String departureAiport = "Warsaw";
        Set<Flights> scheduled = new HashSet<>();
        scheduled.add(new Flights("Warsaw", "Wroclaw"));
        scheduled.add(new Flights("Warsaw", "Gdansk"));
        scheduled.add(new Flights("Warsaw", "Bialystok"));
        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<Flights> result = flightSearcher.availableFlightFrom(departureAiport);
        //then
        Assert.assertEquals(scheduled,result);
    }

    @Test
    public void noAvailableFlightsFromTest(){
        //given
        String departureAiport = "Wroclaw";
        Set<Flights> scheduled = new HashSet<>();
        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<Flights> result = flightSearcher.availableFlightFrom(departureAiport);
        //then
        Assert.assertEquals(scheduled,result);
    }

    @Test
    public void AvailableFlightsToTest(){
        //given
        String destinationAiport = "Warsaw";
        Set<Flights> scheduled = new HashSet<>();
        scheduled.add(new Flights("Krakow", "Warsaw"));
        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<Flights> result = flightSearcher.availableFlightTo(destinationAiport);
        //then
        Assert.assertEquals(scheduled,result);
    }

    @Test
    public void noAvailableFlightsToTest(){
        //given
        String destinationAiport = "Krakow";
        Set<Flights> scheduled = new HashSet<>();
        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<Flights> result = flightSearcher.availableFlightTo(destinationAiport);
        //then
        Assert.assertEquals(scheduled, result);
    }

    @Test
    public void availableFlightsTest(){
        //given
        String departureAiport = "Krakow";
        String destinationAiport = "Bialystok";
        Set<List<Flights>> scheduled = new HashSet<>();

        List<Flights> krWwWwBs = new ArrayList<>();
        krWwWwBs.add(new Flights("Krakow", "Warsaw"));
        krWwWwBs.add(new Flights("Warsaw", "Bialystok"));

        scheduled.add(krWwWwBs);
        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<List<Flights>> result = flightSearcher.allAvailableFlights(departureAiport, destinationAiport);
        //then
        Assert.assertEquals(scheduled, result);
    }

    @Test
    public void noAvailableFlightsTest(){
        //given
        String departureAiport = "Krakow";
        String destinationAiport = "Szczecin";

        Set<List<Flights>> scheduled = new HashSet<>();

        //when
        when(flightsFixerMock.getAvailableFlight()).thenReturn(availableFlight);
        Set<List<Flights>> result = flightSearcher.allAvailableFlights(departureAiport, destinationAiport);
        //then
        Assert.assertEquals(scheduled, result);
    }

}
