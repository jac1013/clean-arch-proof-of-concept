package com.airline.business.seat;

import com.airline.business.seat.cost.SeatCostFactorCalculator;
import com.airline.business.passenger.Passenger;

class EmergencySeat extends Seat {
    EmergencySeat(String code, Passenger passenger, SeatCostFactorCalculator costCalculator) {
        this.code = code;
        this.passenger = passenger;
        this.costCalculator = costCalculator;
    }

    @Override
    public double getCostFactor() {
        return costCalculator.calculate(SeatType.EMERGENCY);
    }
}
