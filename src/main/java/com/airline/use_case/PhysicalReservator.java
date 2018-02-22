package com.airline.use_case;

import com.airline.business.flight.Flight;
import com.airline.business.passenger.Passenger;
import com.airline.business.reservation.Reservation;
import com.airline.business.reservation.ReservationFactory;
import com.airline.business.reservation.ReservationType;
import com.airline.business.seat.Seat;
import com.airline.business.util.TimeHelper;

public class PhysicalReservator implements AirlineReservator {
    @Override
    public Reservation bookFlight(Flight flight, Seat seat, Passenger passenger, ReservationFactory reservationFactory) {
        return reservationFactory.create(flight, seat, passenger, TimeHelper.getTimeAfterHours(72), ReservationType.PHYSICAL);
    }
}
