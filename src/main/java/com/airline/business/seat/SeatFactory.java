package com.airline.business.seat;

import com.airline.business.passenger.Passenger;

public interface SeatFactory {
    Seat create(String code, SeatType type, Passenger passenger);
}
