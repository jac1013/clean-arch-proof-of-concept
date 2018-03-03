package com.airline.business.flight;

import com.airline.business.airplane.Airplane;
import com.airline.business.city.City;
import com.airline.business.flight.cost.DomesticFlightCostCalculator;
import com.airline.business.flight.cost.InternationalFlightCostCalculator;

import java.time.Instant;

public class FlightFactoryImpl implements FlightFactory {
    @Override
    public Flight create(FlightType type, City from, City to, Airplane airplane, Instant departure, Instant arrival) {
        switch (type) {
            case DOMESTIC:
                return new DomesticFlight(from, to, airplane, departure, arrival, new DomesticFlightCostCalculator());
            case INTERNATIONAL:
                return new InternationalFlight(from, to, airplane, departure, arrival, new DomesticFlightCostCalculator());
            default:
                throw new InvalidFlightType();

        }
    }

    public static class InvalidFlightType extends RuntimeException {

    }
}
