package com.airline.business.city;

import com.airline.business.city.cost.CityCostFactorCalculatorImpl;

public class CityFactoryImpl implements CityFactory {
    @Override
    public City create(String name) {
        return new CityImpl(name, CityCostFactorCalculatorImpl.getInstance());
    }
}
