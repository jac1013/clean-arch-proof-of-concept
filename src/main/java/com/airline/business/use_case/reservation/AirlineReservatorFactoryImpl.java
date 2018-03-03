package com.airline.business.use_case.reservation;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.reservation.ReservationFactoryImpl;
import com.airline.business.seat.SeatFactoryImpl;

public class AirlineReservatorFactoryImpl implements AirlineReservatorFactory {
    @Override
    public AirlineReservator create() {
        return new AirlineReservatorImpl(new FlightFactoryImpl(), new AirplaneFactoryImpl(),
                new SeatFactoryImpl(), new ReservationFactoryImpl());
    }
}
