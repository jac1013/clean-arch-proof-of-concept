package com.airline.business.airplane;

import com.airline.business.airplane.cost.LargeAirplaneCostFactorCalculator;
import com.airline.business.airplane.cost.MediumAirplaneCostFactorCalculator;
import com.airline.business.airplane.cost.SmallAirplaneCostFactorCalculator;
import com.airline.business.seat.Seat;

import java.util.List;

public class AirplaneFactory {
    public static Airplane getAirplane(String name, List<Seat> seats, AirplaneType type) {
        switch(type) {
            case SMALL:
                return new SmallAirplane(name, seats, new SmallAirplaneCostFactorCalculator());
            case MEDIUM:
                return AirplaneFactory.getMediumAirplane(name, seats);
            case LARGE:
                return new LargeAirplane(name, seats, new LargeAirplaneCostFactorCalculator());
            default:
                return AirplaneFactory.getMediumAirplane(name, seats);
        }
    }

    private static Airplane getMediumAirplane(String name, List<Seat> seats) {
        return new MediumAirplane(name, seats, new MediumAirplaneCostFactorCalculator());
    }
}
