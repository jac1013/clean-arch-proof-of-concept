package com.airline.view.cli;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.city.CityFactoryImpl;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.reservation.Reservation;
import com.airline.business.reservation.ReservationFactoryImpl;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.reservation.controller.PresenterResponse;
import com.airline.reservation.controller.ReservationController;
import com.airline.use_case.OnlineReservator;

import java.util.Optional;

// EXAMPLE: -n "John" -d "2018-01-30" -l "Doe" p "12345678" -dc "New York" -ac "Tokyo" -sf "false"
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Optional<PresenterRequest> request = new Presenter(args).parseCommandLine();
        if (!request.isPresent()) {
            return;
        }

        Optional<PresenterResponse> response = new PresenterDataTransformer(request.get(), new CityFactoryImpl()).transform();
        if(!response.isPresent()) {
            return;
        }

        createReservation(response.get());

    }

    private static void createReservation(PresenterResponse response) {
        Optional<Reservation> reservation = new ReservationController(response, new AirplaneFactoryImpl(), new FlightFactoryImpl(), new SeatFactoryImpl(), new ReservationFactoryImpl(), new OnlineReservator()).bookFlight();
        reservation.ifPresent(r -> {
            System.out.println(r);
            System.out.println(r.getTickerPrice());
        });
    }


}
