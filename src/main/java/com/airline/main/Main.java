package com.airline.main;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.CityFactory;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerBuilder;
import com.airline.business.passenger.PassengerType;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.business.seat.SeatType;
import com.airline.use_case.OnlineReservator;
import com.airline.use_case.PhysicalReservator;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        Passenger passenger = new PassengerBuilder().setName("John").setLastName("Doe").setDateOfBirth(Instant.now()).setPassportId("12345678").setType(PassengerType.STANDARD).build();
        Seat seat =  new SeatFactoryImpl().create("A1", SeatType.FIRST_CLASS, passenger);
        Flight flight = new FlightFactoryImpl().create(FlightType.INTERNATIONAL, CityFactory.getCity("New York"), CityFactory.getCity("Tokyo"), new AirplaneFactoryImpl().create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());

        Reservation reservation = new OnlineReservator().bookFlight(flight, seat, passenger);

        System.out.println(reservation);

        System.out.println(reservation.getTickerPrice());

        Reservation reservation1 = new PhysicalReservator().bookFlight(flight, seat, passenger);

        System.out.println(reservation1);

        System.out.println(reservation1.getTickerPrice());

    }
}
