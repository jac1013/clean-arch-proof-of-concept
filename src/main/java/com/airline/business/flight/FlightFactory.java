package com.airline.business.flight;

import com.airline.business.airplane.Airplane;
import com.airline.business.city.City;

import java.time.Instant;

public interface FlightFactory {
    Flight create(FlightType type, City from, City to, Airplane airplane, Instant departure, Instant arrival);
}
