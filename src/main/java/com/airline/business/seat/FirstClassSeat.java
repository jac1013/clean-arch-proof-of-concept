package com.airline.business.seat;

import com.airline.business.seat.cost.SeatCostFactorCalculator;
import com.airline.business.passenger.Passenger;

class FirstClassSeat extends Seat {
    FirstClassSeat(String code, Passenger passenger, SeatCostFactorCalculator costCalculator) {
        this.code = code;
        this.passenger = passenger;
        this.costCalculator = costCalculator;
    }

    public double getCostFactor() {
        return costCalculator.calculate(SeatType.FIRST_CLASS);
    }
}
