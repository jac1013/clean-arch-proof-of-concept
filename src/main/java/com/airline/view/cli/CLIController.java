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

class CLIController {
    private String[] CLIArguments;

    CLIController(String[] CLIArguments) {
        this.CLIArguments = CLIArguments;
    }

    Reservation bookFlight() {
        CLIPresenterResponse c = new CLIPresenter().parseCLI(this.CLIArguments);
        if(c != null) {
            Flight flight = FlightFactory.getFlight(FlightType.INTERNATIONAL, c.getFrom(), c.getTo(), AirplaneFactory.getAirplane("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
            Seat seat = SeatFactory.getSeat("A1", c.isFirstClass() ? SeatType.FIRST_CLASS : SeatType.REGULAR, c.getPassenger());
            return new OnlineReservator().bookFlight(flight, seat, c.getPassenger());
        }
        return null;
    }
}
