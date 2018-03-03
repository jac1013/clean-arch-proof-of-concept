package com.airline.spring.rest.passenger;

import com.airline.business.database.DatabaseFactory;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.database.PassengerRepository;
import com.airline.business.passenger.rest.PassengerRestTranslator;
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

    private PassengerRepository repository;
    private PassengerRestTranslator<PassengerRest> translator;

    @Autowired
    public PassengerController(DatabaseFactory<PassengerRepository> repositoryFactory, PassengerRestTranslatorImpl translator) {
        this.repository = repositoryFactory.getPassengerDatabase();
        this.translator = translator;
    }

    @PostMapping("/passenger")
    public ResponseEntity<?> save(@RequestBody PassengerRest passengerRest) {
        return this.catchValidationAndRespondAccordingly(passengerRest, p -> this.repository.save(p),
                "New Passenger was created with ID: ");
    }

    private ResponseEntity<?> catchValidationAndRespondAccordingly(PassengerRest p, Function<Passenger, Passenger>
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
    public ResponseEntity<PassengerRest> get(@PathVariable("id") long id) {
        Passenger passenger = this.repository.find(id);
        return ResponseEntity.ok().body(this.translator.translate(passenger));
    }

    @GetMapping("/passenger")
    public ResponseEntity<List<PassengerRest>> list() {
        Stream<Passenger> passengers = this.repository.findAll();
        return ResponseEntity.ok().body(passengers.map(this.translator::translate).collect(Collectors.toList()));
    }

    @PutMapping("/passenger/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody PassengerRest passengerRest) {
        passengerRest.setId(id);
        return this.catchValidationAndRespondAccordingly(passengerRest, p -> this.repository.update(p),
                "Passenger has been updated successfully, ID: ");
    }

    @DeleteMapping("/passenger/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        this.repository.delete(id);
        return ResponseEntity.ok().body("Passenger has been deleted successfully.");
    }

}
