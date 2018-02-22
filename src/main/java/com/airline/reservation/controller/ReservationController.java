package com.airline.reservation.controller;

import com.airline.business.airplane.AirplaneFactory;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactory;
import com.airline.business.flight.FlightType;
import com.airline.business.reservation.Reservation;
import com.airline.business.reservation.ReservationFactory;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactory;
import com.airline.business.seat.SeatType;
import com.airline.use_case.AirlineReservator;

import java.time.Instant;
import java.util.Optional;

public class ReservationController {
    private final PresenterResponse response;
    private AirplaneFactory airplaneFactory;
    private FlightFactory flightFactory;
    private SeatFactory seatFactory;
    private ReservationFactory reservationFactory;
    private AirlineReservator reservator;


    public ReservationController(PresenterResponse response, AirplaneFactory airplaneFactory, FlightFactory flightFactory, SeatFactory seatFactory, ReservationFactory reservationFactory, AirlineReservator reservator) {
        this.response = response;
        this.airplaneFactory = airplaneFactory;
        this.flightFactory = flightFactory;
        this.seatFactory = seatFactory;
        this.reservator = reservator;
        this.reservationFactory = reservationFactory;
    }

    /*
    I changed my mind, this isn't necessarily smelly code is just that I'm not passing the Flight and Seat information
    Through this view (for simplicity purpose), in a real case we would receive the Flight and probably the Seat,
    The latter can be randomly assigned according to the Passenger (It's eligible for Emergency Sit? It's an elder
    and requires a wheel chair? It's first class? It's first class and also needs a wheel chair?), This decision
    should be made in the use case itself and not here in the controller.
     */
    public Optional<Reservation> bookFlight() {
        Flight flight = flightFactory.create(FlightType.INTERNATIONAL, response.getFrom(), response.getTo(), airplaneFactory.create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
        Seat seat = seatFactory.create("A1", response.isFirstClass() ? SeatType.FIRST_CLASS : SeatType.REGULAR, response.getPassenger());
        return Optional.ofNullable(reservator.bookFlight(flight, seat, response.getPassenger(), reservationFactory));
    }
}
