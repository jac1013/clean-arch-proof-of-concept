package com.airline.view.interactive_cli;

import com.airline.business.airplane.AirplaneFactoryImpl;
import com.airline.business.airplane.AirplaneType;
import com.airline.business.city.CityFactoryImpl;
import com.airline.business.flight.Flight;
import com.airline.business.flight.FlightFactoryImpl;
import com.airline.business.flight.FlightType;
import com.airline.business.passenger.*;
import com.airline.business.reservation.Reservation;
import com.airline.business.seat.Seat;
import com.airline.business.seat.SeatFactoryImpl;
import com.airline.business.seat.SeatType;
import com.airline.database.spring.DatabaseFactoryImpl;
import com.airline.main.SpringConfig;
import com.airline.reservation.controller.PresenterResponse;
import com.airline.reservation.controller.ReservationController;
import com.airline.use_case.AirlineReservatorFactoryImpl;
import com.airline.view.cli.PresenterDataTransformer;
import com.airline.view.cli.PresenterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.util.Optional;

@SpringBootApplication
@Import({SpringConfig.class})
@ComponentScan("com.airline.database")
@EntityScan("com.airline.database")
@EnableJpaRepositories("com.airline.database")
public class Main {

    @Autowired
    static DatabaseFactoryImpl databaseFactory;

    public static void main(String[] args) {
        initializeSpring(args);

        View view = new View();
        PresenterRequest request = view.askForInformation();
        Optional<PresenterResponse> response = new PresenterDataTransformer(request, new CityFactoryImpl(), new
                PassengerFactoryImpl(databaseFactory.getPassengerDatabase())).transform();

        response.ifPresent(Main::bookFlight);

        if(view.needsLoopOrGoodBye()) {
            main(null);
        }

    }

    private static void initializeSpring(String [] args) {
        if (args != null) {
            SpringApplication.run(Main.class, args);
        }
    }

    private static void bookFlight(PresenterResponse response) {
        Flight flight = new FlightFactoryImpl().create(FlightType.INTERNATIONAL, response.getFrom(), response.getTo(), new
                AirplaneFactoryImpl().create("747", null, AirplaneType.LARGE), Instant.now(), Instant.now());
        Seat seat = new SeatFactoryImpl().create("A1", response.isFirstClass() ? SeatType.FIRST_CLASS : SeatType.REGULAR,
                response.getPassenger());
        Optional<Reservation> reservation =  new ReservationController(response, new AirlineReservatorFactoryImpl()
                .create())
                .bookFlight(flight, seat);
        reservation.ifPresent(View::feedbackUserWithReservation);
    }
}
