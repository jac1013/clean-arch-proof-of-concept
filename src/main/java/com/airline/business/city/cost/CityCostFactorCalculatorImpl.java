package com.airline.business.city.cost;

import com.airline.business.city.City;

import java.util.HashMap;
import java.util.Map;

public class CityCostFactorCalculatorImpl implements CityCostFactorCalculator {
    private Map<String, Double> costs = new HashMap<>();
    static private CityCostFactorCalculatorImpl singleton;


    private CityCostFactorCalculatorImpl() {
        this.costs.put("New York", 3.0);
        this.costs.put("Tokyo", 3.0);
        this.costs.put("Sidney", 2.5);
        this.costs.put("Paris", 3.5);
    }

    public static CityCostFactorCalculatorImpl getInstance() {
        if(CityCostFactorCalculatorImpl.singleton == null) {
            CityCostFactorCalculatorImpl.singleton = new CityCostFactorCalculatorImpl();
        }
        return CityCostFactorCalculatorImpl.singleton;
    }

    @Override
    public double calculate(City city) {
        return this.costs.get(city.getName());
    }
}
