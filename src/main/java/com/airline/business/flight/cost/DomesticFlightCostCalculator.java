package com.airline.business.flight.cost;

public class DomesticFlightCostCalculator implements FlightCostCalculator {
    @Override
    public double calculate() {
        return 50;
    }
}
