package com.airline.business.airplane.cost;

public class LargeAirplaneCostFactorCalculator implements AirplaneCostFactorCalculator {
    @Override
    public double calculate() {
        return 1.2;
    }
}
