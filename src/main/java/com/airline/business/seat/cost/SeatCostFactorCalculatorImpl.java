package com.airline.business.seat.cost;

import com.airline.business.seat.SeatType;

import java.util.HashMap;
import java.util.Map;

public class SeatCostFactorCalculatorImpl implements SeatCostFactorCalculator {
    private Map<SeatType, Double> costs = new HashMap<>();
    static private SeatCostFactorCalculatorImpl singleton;

    private SeatCostFactorCalculatorImpl() {
        this.costs.put(SeatType.REGULAR, 1.0);
        this.costs.put(SeatType.EMERGENCY, 0.9);
        this.costs.put(SeatType.FIRST_CLASS, 3.5);
        this.costs.put(SeatType.SPECIAL_NEEDS, 1.2);
    }

    public static SeatCostFactorCalculatorImpl getInstance() {
        if(SeatCostFactorCalculatorImpl.singleton == null) {
            SeatCostFactorCalculatorImpl.singleton = new SeatCostFactorCalculatorImpl();
        }
        return SeatCostFactorCalculatorImpl.singleton;
    }

    @Override
    public double calculate(SeatType seatType) {
        return this.costs.get(seatType);
    }
}
