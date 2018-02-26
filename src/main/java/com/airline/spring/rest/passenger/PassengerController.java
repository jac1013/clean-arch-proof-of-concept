package com.airline.spring.rest.passenger;

import com.airline.business.database.DatabaseFactory;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.database.PassengerDatabase;
import com.airline.business.passenger.database.PassengerDatabaseTranslator;
import com.airline.spring.database.passenger.PassengerEntity;
import com.airline.spring.database.passenger.PassengerTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PassengerController {

    private PassengerDatabase database;
    private PassengerDatabaseTranslator<PassengerEntity> translator;

    @Autowired
    public PassengerController(DatabaseFactory<PassengerDatabase> databaseFactory, PassengerTranslator translator) {
        this.database = databaseFactory.getPassengerDatabase();
        this.translator = translator;
    }

    @PostMapping("/passenger")
    public ResponseEntity<?> save(@RequestBody PassengerEntity passengerEntity) {
        return this.catchValidationAndRespondAccordingly(passengerEntity, p -> this.database.save(p),
                "New Passenger was created with ID: ");
    }

    private ResponseEntity<?> catchValidationAndRespondAccordingly(PassengerEntity p, Function<Passenger, Passenger>
            operation, String message) {
        Passenger passenger = this.translator.translate(p);
        try {
            passenger = operation.apply(passenger);
        } catch(TransactionSystemException exception) {
            if(exception.getCause().getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException e = (ConstraintViolationException) exception.getCause().getCause();
                return ResponseEntity.badRequest().body("Property: " + e.getConstraintViolations().iterator().next()
                        .getPropertyPath() + " Problem: " + e.getConstraintViolations().iterator().next().getMessage());
            }
            exception.printStackTrace();

        }
        return ResponseEntity.ok().body(message + passenger.getId());
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<Passenger> get(@PathVariable("id") long id) {
        Passenger passenger = this.database.find(id);
        return ResponseEntity.ok().body(passenger);
    }

    @GetMapping("/passenger")
    public ResponseEntity<List<Passenger>> list() {
        Stream<Passenger> passengers = this.database.findAll();
        return ResponseEntity.ok().body(passengers.collect(Collectors.toList()));
    }

    @PutMapping("/passenger/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody PassengerEntity passengerEntity) {
        passengerEntity.setId(id);
        return this.catchValidationAndRespondAccordingly(passengerEntity, p -> this.database.update(p),
                "Passenger has been updated successfully, ID: ");
    }

    @DeleteMapping("/passenger/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        this.database.delete(id);
        return ResponseEntity.ok().body("Passenger has been deleted successfully.");
    }

}
