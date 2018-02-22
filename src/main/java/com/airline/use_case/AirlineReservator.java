package com.airline.use_case;

import com.airline.business.city.City;
import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.reservation.Reservation;
import com.airline.business.reservation.ReservationFactory;
import com.airline.business.reservation.ReservationType;
import com.airline.business.seat.Seat;

public interface AirlineReservator {
    Reservation bookFlight(Flight flight, Seat seat, Passenger passenger, City from, City to);
}
