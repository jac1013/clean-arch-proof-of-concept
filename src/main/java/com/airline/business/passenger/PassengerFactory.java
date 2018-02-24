package com.airline.business.passenger;

public interface PassengerFactory {
    Passenger create(Passenger.PassengerBuilder builder);
}
