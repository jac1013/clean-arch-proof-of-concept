package com.airline.database.spring;

import com.airline.business.passenger.Passenger;

public interface PassengerDatabaseTransformer {
    public DatabasePassenger transform(Passenger p);
}
