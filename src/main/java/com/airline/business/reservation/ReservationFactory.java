package com.airline.business.reservation;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.seat.Seat;

import java.time.Instant;

public interface ReservationFactory {
    Reservation create(Flight flight, Seat seat, Passenger passenger, Instant dueDate, ReservationType type);
}
