package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.city.CityFactory;
import com.airline.business.passenger.Passenger;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

class PresenterDataTransformer {
    private final PresenterRequest request;
    private CityFactory cityFactory;

    PresenterDataTransformer(PresenterRequest request, CityFactory cityFactory) {
        this.request = request;
        this.cityFactory = cityFactory;
    }

    Optional<PresenterResponse> transform() {
        try {
            Passenger passenger = transformPassenger();
            City departure = transformDepartureCity();
            City arrival = transformArrivalCity();
            return Optional.of(new PresenterResponse(passenger, departure, arrival, isFirstClass()));
        } catch(NoBirthDateProvidedException exception) {
            System.out.println("Make sure the Birth date is correctly formatted.");
        }
       return Optional.empty();
    }

    private Passenger transformPassenger() throws NoBirthDateProvidedException {
        return new Passenger.PassengerBuilder(request.getName(), request.getLastName(), request.getPassportId())
                .dateOfBirth(getDateOfBirth()).build();
    }

    private Instant getDateOfBirth() throws NoBirthDateProvidedException {
        Instant instant;
        try {
            LocalDate date = LocalDate.parse(request.getDateOfBirth());
            instant = date.atStartOfDay(ZoneId.of("UTC")).toInstant();
        } catch (Exception exception) {
            throw new NoBirthDateProvidedException();
        }
        return instant;
    }

    private City transformDepartureCity() {
        return transformCity(request.getDepartureCity());
    }

    private City transformArrivalCity() {
        return transformCity(request.getArrivalCity());
    }

    private City transformCity(String name) {
        return cityFactory.create(name);
    }

    boolean isFirstClass() {
        return Boolean.valueOf(request.getIsFirstClass());
    }

    private class NoBirthDateProvidedException extends Exception {}
}
