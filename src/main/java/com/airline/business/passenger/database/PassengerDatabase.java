package com.airline.business.passenger.database;

import com.airline.business.database.Database;
import com.airline.business.passenger.Passenger;

import java.util.stream.Stream;

public interface PassengerDatabase extends Database<Passenger, Long> {
    Stream<Passenger> findAll();
}
