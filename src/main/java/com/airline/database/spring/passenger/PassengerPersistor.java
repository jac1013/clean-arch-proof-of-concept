package com.airline.database.spring.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.database.passenger.PassengerDatabase;
import com.airline.database.passenger.PassengerDatabaseTransformer;

public class PassengerPersistor implements PassengerDatabase {
    private final PassengerRepository passengerRepository;
    private final PassengerDatabaseTransformer<PassengerEntity> transformer;

    public PassengerPersistor(PassengerRepository passengerRepository, PassengerDatabaseTransformer transformer) {
        this.passengerRepository = passengerRepository;
        this.transformer = transformer;
    }

    @Override
    public Passenger save(Passenger passenger) {
        PassengerEntity passengerEntity = transformer.transform(passenger);
        PassengerEntity saved =  passengerRepository.save(passengerEntity);

        return new PassengerFactoryImpl(this).create( new Passenger.PassengerBuilder(saved.getName(), saved
                .getLastName(), saved
                .getPassportId())
                .needsSpecialTreatment(saved.isNeedsSpecialTreatment())
                .gender(saved.getGender())
                .dateOfBirth(saved.getDateOfBirth())
                .type(saved.getPassengerType()));
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Passenger find(String id) {
        return null;
    }
}
