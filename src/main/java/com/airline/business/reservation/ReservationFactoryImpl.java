package com.airline.business.reservation;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.seat.Seat;

import java.time.Instant;

public class ReservationFactoryImpl implements ReservationFactory {
    @Override
    public Reservation create(Flight flight, Seat seat, Passenger passenger, Instant dueDate, ReservationType type) {
        switch(type) {
            case PHYSICAL:
                return new PhysicalReservation(flight, seat , passenger, dueDate);
            case ONLINE:
            default:
                throw new InvalidReservationType();
        }
    }

    public static class InvalidReservationType extends RuntimeException {

    }
}
