package com.airline.spring.database;

import com.airline.business.database.DatabaseFactory;
import com.airline.business.passenger.PassengerFactoryImpl;
import com.airline.business.passenger.database.PassengerRepository;
import com.airline.spring.database.passenger.PassengerDatabase;
import com.airline.spring.database.passenger.PassengerPersistor;
import com.airline.spring.database.passenger.PassengerDatabaseTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseFactoryImpl implements DatabaseFactory<PassengerRepository> {

    private PassengerDatabase repository;

    @Autowired
    public DatabaseFactoryImpl(PassengerDatabase repository) {
        this.repository = repository;
    }

    @Override
    public PassengerRepository getPassengerDatabase() {
        PassengerDatabaseTranslator translator = new PassengerDatabaseTranslator();
        translator.setPassengerFactory(new PassengerFactoryImpl());
        return new PassengerPersistor(repository, translator);
    }
}
