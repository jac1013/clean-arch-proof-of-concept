package com.airline.use_case;

import com.airline.business.airplane.AirplaneFactory;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.City;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactory;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.Passenger;
import com.airline.business.reservation.Reservation;
import com.airline.business.reservation.ReservationFactory;
import com.airline.business.reservation.ReservationType;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactory;
import com.airline.business.seat.SeatType;
import com.airline.business.util.TimeHelper;

import java.time.Duration;
import java.time.Instant;

public class AirlineReservatorImpl implements AirlineReservator {
    private FlightFactory flightFactory;
    private AirplaneFactory airplaneFactory;
    private SeatFactory seatFactory;
    private ReservationFactory reservationFactory;

    public AirlineReservatorImpl(FlightFactory flightFactory, AirplaneFactory airplaneFactory, SeatFactory seatFactory, ReservationFactory reservationFactory) {
        this.flightFactory = flightFactory;
        this.airplaneFactory = airplaneFactory;
        this.seatFactory = seatFactory;
        this.reservationFactory = reservationFactory;
    }

    @Override
    public Reservation bookFlight(Flight flight, Seat seat, Passenger passenger, City from, City to) {
        // This is because for now flight and seat are just hard coded generated. The controller doesn't provide
        // this info because the presenter doesn't.
        Flight flight1 = flightFactory.create(FlightType.INTERNATIONAL, from, to, airplaneFactory.create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
        Seat seat1 = seatFactory.create("A1", passenger.isVIP() ? SeatType.FIRST_CLASS : SeatType.REGULAR, passenger);
        return reservationFactory.create(flight1, seat1, passenger, TimeHelper.getTimeAfterHours(48), ReservationType.ONLINE);
    }
}
