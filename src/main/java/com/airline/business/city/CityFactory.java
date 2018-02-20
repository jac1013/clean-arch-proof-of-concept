package com.airline.business.city;

import com.airline.business.city.cost.CityCostFactorCalculatorImpl;

public class CityFactory {
    public static City getCity(String name) {
        return new CityImpl(name, CityCostFactorCalculatorImpl.getInstance());
    }
}
