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
    private AirplaneFactory airplaneFactory;
    private FlightFactory flightFactory;
    private SeatFactory seatFactory;

    Controller(String[] CLIArguments, AirplaneFactory airplaneFactory, FlightFactory flightFactory, SeatFactory seatFactory) {
        this.CLIArguments = CLIArguments;
        this.airplaneFactory = airplaneFactory;
        this.flightFactory = flightFactory;
        this.seatFactory = seatFactory;
    }

    Optional<Reservation> bookFlight() {
        Optional<PresenterRequest> optionalRequest = new Presenter(CLIArguments).parseCommandLine();
        if(optionalRequest.isPresent()) {
            return constructReservation(optionalRequest.get());
        }
        return Optional.empty();
    }

    private Optional<Reservation> constructReservation(PresenterRequest request) {
        Optional<PresenterResponse> optionalResponse = new PresenterDataTransformer(request).transform();
        if(optionalResponse.isPresent()) {
            PresenterResponse response = optionalResponse.get();
            Flight flight = flightFactory.create(FlightType.INTERNATIONAL, response.getFrom(), response.getTo(), airplaneFactory.create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
            Seat seat = seatFactory.create("A1", response.isFirstClass() ? SeatType.FIRST_CLASS : SeatType.REGULAR, response.getPassenger());
            return Optional.of(new OnlineReservator().bookFlight(flight, seat, response.getPassenger()));
        }

        return Optional.empty();
    }
}
