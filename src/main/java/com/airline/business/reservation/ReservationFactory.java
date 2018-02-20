package com.airline.business.reservation;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.seat.Seat;

import java.time.Instant;

public class ReservationFactory {
    public static Reservation getReservation(Flight flight, Seat seat, Passenger passenger, Instant dueDate, ReservationType type) {
        switch(type) {
            case PHYSICAL:
            return new PhysicalReservation(flight, seat , passenger, dueDate);
            case ONLINE:
            default:
                return new OnlineReservation(flight, seat, passenger, dueDate);
        }
    }
}
