package com.airline.business.airplane;

import com.airline.business.airplane.cost.AirplaneCostFactorCalculator;
import com.airline.business.seat.Seat;

import java.util.List;

class MediumAirplane extends Airplane {
    MediumAirplane(String name, List<Seat> seats, AirplaneCostFactorCalculator costCalculator) {
        this.name = name;
        this.seats = seats;
        this.costCalculator = costCalculator;
    }
}
