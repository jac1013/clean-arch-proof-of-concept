package com.airline.spring.database;

import com.airline.business.database.DatabaseFactory;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.business.passenger.database.PassengerDatabase;
import com.airline.spring.database.passenger.PassengerPersistor;
import com.airline.spring.database.passenger.PassengerRepository;
import com.airline.spring.database.passenger.PassengerTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseFactoryImpl implements DatabaseFactory<PassengerDatabase> {

    private PassengerRepository repository;

    @Autowired
    public DatabaseFactoryImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PassengerDatabase getPassengerDatabase() {
        return new PassengerPersistor(repository, new PassengerTranslator(new PassengerFactoryImpl()));
    }
}
