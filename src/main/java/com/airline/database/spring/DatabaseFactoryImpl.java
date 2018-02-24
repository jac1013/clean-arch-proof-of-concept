package com.airline.database.spring;

import com.airline.business.database.Database;
import com.airline.business.passenger.Passenger;
import com.airline.database.DatabaseFactory;
import com.airline.database.PassengerPersistor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFactoryImpl implements DatabaseFactory {

    private PassengerRepository repository;

    @Autowired
    public DatabaseFactoryImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Database<Passenger> getPassengerDatabase() {
        return new PassengerPersistor(repository, new PassengerTransformer());
    }
}
