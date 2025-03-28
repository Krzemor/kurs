package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {
        Flight flight = new Flight("WWA", "ESA");
        FlightLogic logic = new FlightLogic();

        try {
            boolean result = logic.findFlight(flight);
            System.out.println(result);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
