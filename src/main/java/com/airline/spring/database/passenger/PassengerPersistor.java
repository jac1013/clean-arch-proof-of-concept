package com.airline.spring.database.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.database.PassengerDatabase;
import com.airline.business.passenger.database.PassengerDatabaseTranslator;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PassengerPersistor implements PassengerDatabase {
    private final PassengerRepository passengerRepository;
    private final PassengerDatabaseTranslator<PassengerEntity> translator;

    public PassengerPersistor(PassengerRepository passengerRepository, PassengerDatabaseTranslator<PassengerEntity>
            translator) {
        this.passengerRepository = passengerRepository;
        this.translator = translator;
    }

    @Override
    public Passenger save(Passenger passenger) {
        System.out.println(passenger);
        PassengerEntity passengerEntity = translator.translate(passenger);
        PassengerEntity saved = passengerRepository.save(passengerEntity);

        return this.translator.translate(saved);
    }

    @Override
    public Passenger update(Passenger passenger) {
        PassengerEntity passengerEntity = translator.translate(passenger);
        PassengerEntity updated = passengerRepository.save(passengerEntity);

        return this.translator.translate(updated);
    }

    @Override
    public void delete(Long id) {
        passengerRepository.delete(id);
    }

    @Override
    public Passenger find(Long id) {
        PassengerEntity passengerEntity = passengerRepository.findOne(id);

        return this.translator.translate(passengerEntity);
    }

    @Override
    public Stream<Passenger> findAll() {
        Iterable<PassengerEntity> i = passengerRepository.findAll();

        return StreamSupport.stream(i.spliterator(), true)
                .map(this.translator::translate);
    }
}
