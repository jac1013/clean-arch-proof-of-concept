package com.airline.business.city;

import com.airline.business.city.cost.CityCostFactorCalculator;

public abstract class City {
    protected String name;
    CityCostFactorCalculator costFactorCalculator;

    public String getName() {
        return name;
    }

    public double getCostFactor() {
        return this.costFactorCalculator.calculate(this);
    }
}
