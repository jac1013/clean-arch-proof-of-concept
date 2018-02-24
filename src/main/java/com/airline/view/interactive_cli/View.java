package com.airline.view.interactive_cli;

import com.airline.business.reservation.Reservation;
import com.airline.view.cli.PresenterRequest;

import java.util.Scanner;

class View {
    private Scanner sc;

    View() {
        sc = new Scanner(System.in);
    }

    PresenterRequest askForInformation() {
        greet();

        String name = askForName();
        String lastName = askForLastName();
        String dateOfBirth = askForDateOfBirth();
        String passportId = askForPassportId();
        String isFirstClass = askForFirstClass();
        String from = askDepartureCity();
        String to = askForArrivalCity();

        return new PresenterRequest.PresenterRequestBuilder(name, lastName, passportId)
                .dateOfBirth(dateOfBirth)
                .departureCity(from)
                .arrivalCity(to)
                .isFirstClass(isFirstClass).build();
    }

    private void greet() {
        System.out.println("All right, Let's book a flight together! ");
    }

    private String askForName() {
        System.out.print("Please enter the Passenger name: ");
        return sc.nextLine();
    }

    private String askForLastName() {
        System.out.print("Please enter the Passenger last name: ");
        return sc.nextLine();
    }

    private String askForDateOfBirth() {
        System.out.print("Please enter the Passenger date of birth (format: yyyy-mm-dd): ");
        return sc.nextLine();
    }

    private String askForPassportId() {
        System.out.print("Please enter the Passenger passport ID: ");
        return sc.nextLine();
    }

    private String askForFirstClass() {
        System.out.print("Is this passenger a First Class Passenger (Y/N): ");
        if(sc.nextLine().equals("Y")) {
            return "true";
        }
        return "false";
    }

    private String askDepartureCity() {
        System.out.print("Please enter the Departure city: ");
        return sc.nextLine();
    }

    private String askForArrivalCity() {
        System.out.print("Please enter the Arrival city: ");
        return sc.nextLine();
    }

    boolean needsLoopOrGoodBye() {
        System.out.print("Another Passenger (Y/N) : ");
        String response= sc.nextLine();
        if(response.equalsIgnoreCase("Y")){
            return true;
        } else {
            System.out.println("Bon voyage!");
            return false;
        }
    }

    static void feedbackUserWithReservation(Reservation reservation) {
        System.out.println("Your Reservation is:");
        System.out.println(reservation);
        System.out.print("And the price for your Ticket is: ");
        System.out.println(reservation.getTickerPrice());
    }
}
