package com.airline.reservation.controller;

import com.airline.business.flight.Flight;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.use_case.AirlineReservator;


import java.util.Optional;

public class ReservationController {
    private final PresenterResponse response;
    private AirlineReservator reservator;


    public ReservationController(PresenterResponse response, AirlineReservator reservator) {
        this.response = response;
        this.reservator = reservator;
    }

    /* I could pass the PresenterResponse object here but I'm not doing it on purpose.
    Why? Well Basically because in reality we would get a Flight object here which won't need the cities
    to be passed like this but through the flight, we would use the response for the Flight, Seat and Passenger.

    That's the reason bookFlight in the reservator has that long signature, it is just because of the simplicity of the
    proof of concept.
     */
    public Optional<Reservation> bookFlight(Flight flight, Seat seat) {
        return Optional.ofNullable(reservator.bookFlight(flight, seat, response.getPassenger(), response.getFrom(), response.getTo()));
    }
}
