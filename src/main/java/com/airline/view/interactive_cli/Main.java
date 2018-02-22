package com.airline.view.interactive_cli;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.CityFactory;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerBuilder;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.business.seat.SeatType;
import com.airline.use_case.OnlineReservator;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

// A lot of everything that is in this main should be in it's own class,
// I'm too lazy right now for refactor, this is just a proof of concept for the plugin architecture.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        greet();

        String name = askForName(sc);
        String lastName = askForLastName(sc);
        String dateOfBirth = askForDateOfBirth(sc);
        String passportId = askForPassportId(sc);
        boolean isFirstClass = askForFirstClass(sc);
        String from = askDepartureCity(sc);
        String to = askForArrivalCity(sc);

        Reservation reservation = businessLogic(name, lastName, passportId, dateOfBirth, isFirstClass, from, to);
        feedbackUserWithReservation(reservation);

        tryToLoopOrGoodbye(sc);
    }

    private static void greet() {
        System.out.println("All right, Let's book a flight together! ");
    }

    private static String askForName(Scanner sc) {
        System.out.print("Please enter the Passenger name: ");
        return sc.nextLine();
    }

    private static String askForLastName(Scanner sc) {
        System.out.print("Please enter the Passenger last name: ");
        return sc.nextLine();
    }

    private static String askForDateOfBirth(Scanner sc) {
        System.out.print("Please enter the Passenger date of birth (format: yyyy-mm-dd): ");
        return sc.nextLine();
    }

    private static String askForPassportId(Scanner sc) {
        System.out.print("Please enter the Passenger passport ID: ");
        return sc.nextLine();
    }

    private static boolean askForFirstClass(Scanner sc) {
        System.out.print("Is this passenger a First Class Passenger (Y/N): ");
        return sc.nextLine().equals("Y");
    }

    private static String askDepartureCity(Scanner sc) {
        System.out.print("Please enter the Departure city: ");
        return sc.nextLine();
    }

    private static String askForArrivalCity(Scanner sc) {
        System.out.print("Please enter the Arrival city: ");
        return sc.nextLine();
    }

    private static Reservation businessLogic(String name, String lastName, String passportId, String dateOfBirth, boolean isFirstClass, String from, String to) {
        LocalDate date = LocalDate.parse(dateOfBirth);
        Instant instant = date.atStartOfDay(ZoneId.of("UTC")).toInstant();
        Passenger passenger = new PassengerBuilder().setName(name).setLastName(lastName).setDateOfBirth(instant).setPassportId(passportId).build();

        Flight flight = new FlightFactoryImpl().create(FlightType.INTERNATIONAL, CityFactory.getCity(from), CityFactory.getCity(to), new AirplaneFactoryImpl().create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
        Seat seat = new SeatFactoryImpl().create("A1", isFirstClass ? SeatType.FIRST_CLASS : SeatType.REGULAR, passenger);
        return new OnlineReservator().bookFlight(flight, seat, passenger);
    }

    private static void feedbackUserWithReservation(Reservation reservation) {
        System.out.println("Your Reservation is:");
        System.out.println(reservation);
        System.out.print("And the price for your Ticket is: ");
        System.out.println(reservation.getTickerPrice());
    }

    private static void tryToLoopOrGoodbye(Scanner sc) {
        System.out.print("Another Passenger (Y/N) : ");
        String var= sc.nextLine();
        if(var.equalsIgnoreCase("Y")){
            main(null);
        } else {
            System.out.println("Bon voyage!");
        }
    }
}
