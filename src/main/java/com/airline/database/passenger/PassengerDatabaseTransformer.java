package com.airline.database.passenger;

import com.airline.business.passenger.Passenger;

public interface PassengerDatabaseTransformer<T extends PassengerSchema> {
    T transform(Passenger p);
}
