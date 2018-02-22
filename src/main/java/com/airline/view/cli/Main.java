package com.airline.view.cli;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.SeatFactoryImpl;

import java.util.Optional;

// EXAMPLE: -n "John" -d "2018-01-30" -l "Doe" p "12345678" -dc "New York" -ac "Tokyo" -sf "false"
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Optional<Reservation> reservation = new Controller(args, new AirplaneFactoryImpl(), new FlightFactoryImpl(), new SeatFactoryImpl()).bookFlight();
        reservation.ifPresent(r -> {
            System.out.println(r);
            System.out.println(r.getTickerPrice());
        });
    }
}
