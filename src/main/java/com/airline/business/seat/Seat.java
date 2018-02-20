package com.airline.business.seat;

import com.airline.business.seat.cost.SeatCostFactorCalculator;
import com.airline.business.passenger.Passenger;

public abstract class Seat {
    String code;
    Passenger passenger;
    SeatCostFactorCalculator costCalculator;

    public abstract double getCostFactor();

    protected boolean isFree() {
        return this.passenger == null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

