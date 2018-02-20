package com.airline.business.reservation;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.seat.Seat;

import java.time.Instant;

class OnlineReservation extends Reservation {
    OnlineReservation(Flight flight, Seat seat, Passenger passenger, Instant dueDate) {
        this.flight = flight;
        this.seat = seat;
        this.passenger = passenger;
        this.creationDate = Instant.now();
        this.dueDate = dueDate;
    }
}
