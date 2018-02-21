package com.airline.view.cli;

import com.airline.business.reservation.Reservation;

// EXAMPLE: -n "John" -d "2018-01-30" -l "Doe" p "12345678" -dc "New York" -ac "Tokyo" -sf "false"
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Reservation reservation = new CLIController(args).bookFlight();
        if(reservation != null) {
            System.out.println(reservation);
            System.out.println(reservation.getTickerPrice());
        }

        Thread.currentThread().join();
    }
}
