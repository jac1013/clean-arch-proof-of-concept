package com.airline.database;

import com.airline.business.database.Database;
import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.database.spring.DatabasePassenger;
import com.airline.database.spring.PassengerDatabaseTransformer;
import com.airline.database.spring.PassengerRepository;


public class PassengerPersistor implements Database<Passenger> {
    private final PassengerRepository passengerRepository;
    private final PassengerDatabaseTransformer transformer;

    public PassengerPersistor(PassengerRepository passengerRepository, PassengerDatabaseTransformer transformer) {
        this.passengerRepository = passengerRepository;
        this.transformer = transformer;
    }

    @Override
    public Passenger save(Passenger passenger) {
        DatabasePassenger databasePassenger = transformer.transform(passenger);
        DatabasePassenger saved =  passengerRepository.save(databasePassenger);

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
