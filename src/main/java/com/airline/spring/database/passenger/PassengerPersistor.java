package com.airline.spring.database.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.database.PassengerRepository;
import com.airline.business.passenger.database.PassengerRepositoryTranslator;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PassengerPersistor implements PassengerRepository {
    private final PassengerDatabase passengerDatabase;
    private final PassengerRepositoryTranslator<PassengerEntity> translator;

    public PassengerPersistor(PassengerDatabase passengerDatabase, PassengerRepositoryTranslator<PassengerEntity>
            translator) {
        this.passengerDatabase = passengerDatabase;
        this.translator = translator;
    }

    @Override
    public Passenger save(Passenger passenger) {
        System.out.println(passenger);
        PassengerEntity passengerEntity = translator.translate(passenger);
        PassengerEntity saved = passengerDatabase.save(passengerEntity);

        return this.translator.translate(saved);
    }

    @Override
    public Passenger update(Passenger passenger) {
        PassengerEntity passengerEntity = translator.translate(passenger);
        PassengerEntity updated = passengerDatabase.save(passengerEntity);

        return this.translator.translate(updated);
    }

    @Override
    public void delete(Long id) {
        passengerDatabase.delete(id);
    }

    @Override
    public Passenger find(Long id) {
        PassengerEntity passengerEntity = passengerDatabase.findOne(id);

        return this.translator.translate(passengerEntity);
    }

    @Override
    public Stream<Passenger> findAll() {
        Iterable<PassengerEntity> i = passengerDatabase.findAll();

        return StreamSupport.stream(i.spliterator(), true)
                .map(this.translator::translate);
    }
}
