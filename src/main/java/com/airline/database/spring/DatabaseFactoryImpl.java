package com.airline.database.spring;

import com.airline.business.database.Database;
import com.airline.business.passenger.Passenger;
import com.airline.business.database.DatabaseFactory;
import com.airline.database.spring.passenger.PassengerPersistor;
import com.airline.database.spring.passenger.PassengerRepository;
import com.airline.database.spring.passenger.PassengerTransformer;
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
