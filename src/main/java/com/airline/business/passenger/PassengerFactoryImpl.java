package com.airline.business.passenger;

import com.airline.business.database.Database;

public class PassengerFactoryImpl implements PassengerFactory {
    private final Database<Passenger> database;

    public PassengerFactoryImpl(Database<Passenger> database) {
        this.database = database;
    }

    @Override
    public Passenger create(Passenger.PassengerBuilder builder) {
        builder.database(database);
        return builder.build();
    }
}
