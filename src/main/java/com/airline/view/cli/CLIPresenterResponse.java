package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;

class CLIPresenterResponse {
    private Passenger passenger;
    private City from;
    private City to;
    private boolean isFirstClass;

    CLIPresenterResponse(Passenger passenger, City from, City to, boolean isFirstClass) {
        this.passenger = passenger;
        this.from = from;
        this.to = to;
        this.isFirstClass = isFirstClass;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    @Override
    public String toString() {
        return "CLIPresenterResponse{" +
                "passenger=" + passenger +
                ", from=" + from +
                ", to=" + to +
                ", isFirstClass=" + isFirstClass +
                '}';
    }
}
