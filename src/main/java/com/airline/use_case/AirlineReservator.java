package com.airline.use_case;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;

public interface AirlineReservator {
    Reservation bookFlight(Flight flight, Seat seat, Passenger passenger);
}
