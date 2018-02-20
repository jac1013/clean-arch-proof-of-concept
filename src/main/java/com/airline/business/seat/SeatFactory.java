package com.airline.business.seat;

import com.airline.business.seat.cost.SeatCostFactorCalculatorImpl;
import com.airline.business.passenger.Passenger;

public class SeatFactory {
    public static Seat getSeat(String code, SeatType type, Passenger passenger) {
        switch (type) {
            case REGULAR:
                return SeatFactory.getRegularSeat(code, passenger);
            case FIRST_CLASS:
                return new FirstClassSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
            case EMERGENCY:
                return new EmergencySeat(code, passenger,  SeatCostFactorCalculatorImpl.getInstance());
            case SPECIAL_NEEDS:
                return new SpecialNeedsSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
            default:
                return SeatFactory.getRegularSeat(code, passenger);
        }
    }

    private static Seat getRegularSeat(String code, Passenger passenger) {
        return new RegularSeat(code, passenger, SeatCostFactorCalculatorImpl.getInstance());
    }
}
