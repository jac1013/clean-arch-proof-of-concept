package com.airline.view.cli;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.CityFactoryImpl;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.business.seat.SeatType;
import com.airline.database.spring.DatabaseFactoryImpl;
import com.airline.main.SpringConfig;
import com.airline.reservation.controller.PresenterResponse;
import com.airline.reservation.controller.ReservationController;
import com.airline.use_case.AirlineReservatorFactoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.util.Optional;

// EXAMPLE: -n "John" -d "2018-01-30" -l "Doe" p "12345678" -dc "New York" -ac "Tokyo" -sf "false"
@SpringBootApplication
@Import({SpringConfig.class})
@ComponentScan("com.airline.database")
@EntityScan("com.airline.database")
@EnableJpaRepositories("com.airline.database")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(DatabaseFactoryImpl databaseFactory) {
        return (args) -> {
            Optional<PresenterRequest> request = new View(args).parseCommandLine();
            if (!request.isPresent()) {
                return;
            }

            Optional<PresenterResponse> response = new PresenterDataTransformer(request.get(),
                    new CityFactoryImpl(), new PassengerFactoryImpl(databaseFactory.getPassengerDatabase()))
                    .transform();
            if (!response.isPresent()) {
                return;
            }

            createReservation(response.get());
        };
    }

    private static void createReservation(PresenterResponse response) {
        Seat seat =  new SeatFactoryImpl().create("A1", SeatType.REGULAR, response.getPassenger());
        Flight flight = new FlightFactoryImpl().create(FlightType.INTERNATIONAL, new CityFactoryImpl().create("New York"), new CityFactoryImpl().create("Tokyo"), new AirplaneFactoryImpl().create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
        Optional<Reservation> reservation = new ReservationController(response, new AirlineReservatorFactoryImpl()
                .create())
                .bookFlight(flight, seat);
        reservation.ifPresent(r -> {
            System.out.println(r);
            System.out.println(r.getTickerPrice());
            response.getPassenger().save();
        });
    }


}
