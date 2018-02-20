package com.airline.business.city;

import com.airline.business.city.cost.CityCostFactorCalculator;

class CityImpl extends City {
    CityImpl(String name, CityCostFactorCalculator costFactorCalculator) {
        this.name = name;
        this.costFactorCalculator = costFactorCalculator;
    }
}
