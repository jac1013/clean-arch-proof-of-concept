package com.airline.business.flight;

import com.airline.business.airplane.Airplane;
import com.airline.business.city.City;
import com.airline.business.flight.cost.FlightCostCalculator;

import java.time.Instant;


public abstract class Flight {
    Instant departure;
    Instant arrival;
    Airplane airplane;
    City from;
    City to;
    FlightCostCalculator costCalculator;

    public double getCost() {
        return this.costCalculator.calculate() * this.from.getCostFactor() * this.to.getCostFactor() * this.airplane.getCostFactor();
    }
}
