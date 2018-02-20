package com.airline.business.reservation;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.seat.Seat;

import java.time.Instant;

public abstract class Reservation {
    Seat seat;
    Instant creationDate;
    Instant dueDate;
    Flight flight;
    Passenger passenger;

    public double getTickerPrice() {
        return this.flight.getCost() * this.seat.getCostFactor();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "seat=" + seat +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
}
