package com.airline.business.seat.cost;

import com.airline.business.seat.SeatType;

public interface SeatCostFactorCalculator {
    double calculate(SeatType seatType);
}
