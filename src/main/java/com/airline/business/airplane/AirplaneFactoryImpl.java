package com.airline.business.airplane;

import com.airline.business.airplane.cost.LargeAirplaneCostFactorCalculator;
import com.airline.business.airplane.cost.MediumAirplaneCostFactorCalculator;
import com.airline.business.airplane.cost.SmallAirplaneCostFactorCalculator;
import com.airline.business.seat.Seat;

import java.util.List;

public class AirplaneFactoryImpl implements AirplaneFactory {
    @Override
    public Airplane create(String name, List<Seat> seats, AirplaneType type) {
        switch (type) {
            case SMALL:
                return new SmallAirplane(name, seats, new SmallAirplaneCostFactorCalculator());
            case MEDIUM:
                return this.getMediumAirplane(name, seats);
            case LARGE:
                return new LargeAirplane(name, seats, new LargeAirplaneCostFactorCalculator());
            default:
                throw new InvalidAirplaneType();

        }
    }

    private Airplane getMediumAirplane(String name, List<Seat> seats) {
        return new MediumAirplane(name, seats, new MediumAirplaneCostFactorCalculator());
    }

    public static class InvalidAirplaneType extends RuntimeException {

    }
}
