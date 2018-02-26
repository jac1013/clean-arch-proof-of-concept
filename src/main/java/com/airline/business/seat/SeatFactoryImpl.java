package com.airline.business.seat;

import com.airline.business.passenger.Passenger;
import com.airline.business.seat.cost.SeatCostFactorCalculatorImpl;

public class SeatFactoryImpl implements SeatFactory {

    @Override
    public Seat create(String code, SeatType type, Passenger passenger) {
        switch (type) {
            case REGULAR:
                return this.getRegularSeat(code, passenger);
            case FIRST_CLASS:
                return new FirstClassSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
            case EMERGENCY:
                return new EmergencySeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
            case SPECIAL_NEEDS:
                return new SpecialNeedsSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
            default:
                throw new InvalidSeatType();
        }
    }

    private Seat getRegularSeat(String code, Passenger passenger) {
        return new RegularSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
    }

    public static class InvalidSeatType extends RuntimeException {

    }
}
