package com.airline.database;

import com.airline.business.database.Database;
import com.airline.business.passenger.Passenger;


public class PassengerPersistor implements Database<Passenger> {
    private final PassengerRepository passengerRepository;

    public PassengerPersistor(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger save(Passenger o) {
        DatabasePassenger p = new DatabasePassenger();
        p.setName(o.getName());
        p.setLastName(o.getLastName());
        p.setPassportId(o.getPassportId());
        p.setNeedsSpecialTreatment(o.isNeedsSpecialTreatment());
        p.setGender(o.getGender());

        DatabasePassenger saved =  passengerRepository.save(p);

        return new Passenger.PassengerBuilder(saved.getName(), saved.getLastName(), saved.getPassportId())
                .needsSpecialTreatment(saved.isNeedsSpecialTreatment()).gender(saved.getGender())
                .build();
    }

    @Override
    public Passenger update(Passenger o) {
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
