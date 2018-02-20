package com.airline.business.flight;

import com.airline.business.airplane.Airplane;
import com.airline.business.city.City;
import com.airline.business.flight.cost.FlightCostCalculator;

import java.time.Instant;

class DomesticFlight extends Flight {
    DomesticFlight(City from, City to, Airplane airplane, Instant departure, Instant arrival, FlightCostCalculator costCalculator) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
        this.departure = departure;
        this.arrival = arrival;
        this.costCalculator = costCalculator;
    }
}
