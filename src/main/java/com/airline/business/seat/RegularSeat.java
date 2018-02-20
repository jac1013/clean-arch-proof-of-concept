package com.airline.business.seat;

import com.airline.business.seat.cost.SeatCostFactorCalculator;
import com.airline.business.passenger.Passenger;

class RegularSeat extends Seat {
    RegularSeat(String code, Passenger passenger, SeatCostFactorCalculator costCalculator) {
        this.code = code;
        this.passenger = passenger;
        this.costCalculator = costCalculator;
    }

    public double getCostFactor() {
        return costCalculator.calculate(SeatType.REGULAR);
    }
}
