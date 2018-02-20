package com.airline.business.airplane.cost;

public class SmallAirplaneCostFactorCalculator implements AirplaneCostFactorCalculator {
    @Override
    public double calculate() {
        return 1.8;
    }
}
