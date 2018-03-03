package com.airline.business.passenger.rest;

import com.airline.business.passenger.Passenger;

public interface PassengerRestTranslator<T extends PassengerRest> {
    T translate(Passenger p);
    Passenger translate(T t);
}
