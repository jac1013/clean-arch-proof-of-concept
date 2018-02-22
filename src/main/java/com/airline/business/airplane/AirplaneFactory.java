package com.airline.business.airplane;

import com.airline.business.seat.Seat;

import java.util.List;

public interface AirplaneFactory {
    Airplane create(String name, List<Seat> seats, AirplaneType type);
}
