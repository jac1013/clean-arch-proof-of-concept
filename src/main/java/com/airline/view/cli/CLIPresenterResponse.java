package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;
import com.airline.view.cli.controller.PresenterResponse;

class CLIPresenterResponse extends PresenterResponse {
    CLIPresenterResponse(Passenger passenger, City departureCity, City arrivalCity, boolean isFirstClass) {
        this.passenger = passenger;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.isFirstClass = isFirstClass;
    }
}
