package com.airline.reservation.controller;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;

public abstract class PresenterResponse {
    protected Passenger passenger;
    protected City departureCity;
    protected City arrivalCity;
    protected boolean isFirstClass;

    protected Passenger getPassenger() {
        return passenger;
    }

    City getFrom() {
        return departureCity;
    }

    City getTo() {
        return arrivalCity;
    }

    boolean isFirstClass() {
        return isFirstClass;
    }
}
