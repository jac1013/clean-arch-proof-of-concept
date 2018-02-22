package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;

class PresenterResponse {
    private final Passenger passenger;
    private final City departureCity;
    private final City arrivalCity;
    private final boolean isFirstClass;

    PresenterResponse(Passenger passenger, City departureCity, City arrivalCity, boolean isFirstClass) {
        this.passenger = passenger;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.isFirstClass = isFirstClass;
    }

    public Passenger getPassenger() {
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
