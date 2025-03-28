package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightLogic {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> availableFlights = new HashMap<>();
        availableFlights.put("KRK", false);
        availableFlights.put("WWA", true);
        availableFlights.put("LON", true);

        Boolean flightAvailable = availableFlights.get(flight.getArrivalAirport());

        if (flightAvailable == null) {
            throw new RouteNotFoundException("Flight to: " + flight.getArrivalAirport() + " is not available");
        }
        return flightAvailable;
    }
}
