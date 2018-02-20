package com.airline.business.airplane.cost;

public class MediumAirplaneCostFactorCalculator implements AirplaneCostFactorCalculator {
    @Override
    public double calculate() {
        return 1.4;
    }
}
