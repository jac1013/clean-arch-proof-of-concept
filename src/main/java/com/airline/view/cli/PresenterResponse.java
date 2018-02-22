package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;

class PresenterResponse {
    private Passenger passenger;
    private City departureCity;
    private City arrivalCity;
    private boolean isFirstClass;

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
