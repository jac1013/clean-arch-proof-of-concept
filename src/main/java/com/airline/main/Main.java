package com.airline.main;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.CityFactoryImpl;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.Gender;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.business.passenger.PassengerType;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.business.seat.SeatType;
import com.airline.spring.database.DatabaseFactoryImpl;
import com.airline.use_case.AirlineReservatorFactoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;

@SpringBootApplication()
@ComponentScan("com.airline.spring.database")
@EntityScan("com.airline.spring.database")
@EnableJpaRepositories("com.airline.spring.database")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(DatabaseFactoryImpl databaseFactory) {
        return (args) -> {
            Passenger passenger = new PassengerFactoryImpl().create(new  Passenger
                    .PassengerBuilder("John", "Doe", "12345678").dateOfBirth(Instant
                    .now()).gender(Gender.FEMININE).type(PassengerType.STANDARD));
            Seat seat =  new SeatFactoryImpl().create("A1", SeatType.REGULAR, passenger);
            Flight flight = new FlightFactoryImpl().create(FlightType.INTERNATIONAL, new CityFactoryImpl().create("New York"), new CityFactoryImpl().create("Tokyo"), new AirplaneFactoryImpl().create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());

            Reservation reservation = new AirlineReservatorFactoryImpl().create().bookFlight(flight, seat, passenger,
                    flight.getFrom(), flight.getTo());

            System.out.println(reservation);

            System.out.println(reservation.getTickerPrice());

            Reservation reservation1 = new AirlineReservatorFactoryImpl().create().bookFlight(flight, seat, passenger,
                    flight.getFrom(), flight.getTo());

            System.out.println(reservation1);

            System.out.println(reservation1.getTickerPrice());

            System.out.println(databaseFactory.getPassengerDatabase().save(passenger));

        };
    }
}
