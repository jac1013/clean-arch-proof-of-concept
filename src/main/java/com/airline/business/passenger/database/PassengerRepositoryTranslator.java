package com.airline.business.passenger.database;

import com.airline.business.passenger.Passenger;

public interface PassengerRepositoryTranslator<T extends PassengerSchema> {
    T translate(Passenger p);
    Passenger translate(T t);
}
