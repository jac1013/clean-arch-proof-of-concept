package com.airline.business.airplane;

import com.airline.business.airplane.cost.AirplaneCostFactorCalculator;
import com.airline.business.seat.Seat;

import java.util.List;

public abstract class Airplane {
    String name;
    List<Seat> seats;
    AirplaneCostFactorCalculator costCalculator;

    public double getCostFactor() {
        return this.costCalculator.calculate();
    }
}
