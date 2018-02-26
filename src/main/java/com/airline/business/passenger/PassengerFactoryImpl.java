package com.airline.business.passenger;


public class PassengerFactoryImpl implements PassengerFactory {

    @Override
    public Passenger create(Passenger.PassengerBuilder builder) {
        return builder.build();
    }
}
