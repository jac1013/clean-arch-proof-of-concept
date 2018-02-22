package com.airline.view.cli;

import com.airline.business.airplane.AirplaneFactory;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactory;
import com.airline.business.flight.FlightType;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactory;
import com.airline.business.seat.SeatType;
import com.airline.use_case.OnlineReservator;

import java.time.Instant;
import java.util.Optional;

class Controller {
    private String[] CLIArguments;

    Controller(String[] CLIArguments) {
        this.CLIArguments = CLIArguments;
    }

    Optional<Reservation> bookFlight() {
        Optional<PresenterRequest> optionalRequest = new Presenter().parseCommandLine(this.CLIArguments);
        if(optionalRequest.isPresent()) {
            return this.constructReservation(optionalRequest.get());
        }
        return Optional.empty();
    }

    private Optional<Reservation> constructReservation(PresenterRequest request) {
        Optional<PresenterResponse> optionalResponse = new PresenterDataTransformer(request).transform();
        if(optionalResponse.isPresent()) {
            PresenterResponse response = optionalResponse.get();
            Flight flight = FlightFactory.getFlight(FlightType.INTERNATIONAL, response.getFrom(), response.getTo(), AirplaneFactory.getAirplane("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
            Seat seat = SeatFactory.getSeat("A1", response.isFirstClass() ? SeatType.FIRST_CLASS : SeatType.REGULAR, response.getPassenger());
            return Optional.of(new OnlineReservator().bookFlight(flight, seat, response.getPassenger()));
        }

        return Optional.empty();
    }
}
