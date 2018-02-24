package com.airline.reservation.controller;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;

public abstract class PresenterResponse {
    protected Passenger passenger;
    protected City departureCity;
    protected City arrivalCity;
    protected boolean isFirstClass;

    public Passenger getPassenger() {
        return passenger;
    }

    public City getFrom() {
        return departureCity;
    }

    public City getTo() {
        return arrivalCity;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }
}
