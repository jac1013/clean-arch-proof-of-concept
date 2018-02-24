package com.airline.database.spring;

import com.airline.business.passenger.Passenger;

class PassengerTransformer implements PassengerDatabaseTransformer {
    @Override
    public DatabasePassenger transform(Passenger passenger) {
        DatabasePassenger databasePassenger = new DatabasePassenger();
        databasePassenger.setName(passenger.getName());
        databasePassenger.setLastName(passenger.getLastName());
        databasePassenger.setPassportId(passenger.getPassportId());
        databasePassenger.setNeedsSpecialTreatment(passenger.isNeedsSpecialTreatment());
        databasePassenger.setGender(passenger.getGender());
        databasePassenger.setPassengerType(passenger.getPassengerType());
        databasePassenger.setDateOfBirth(passenger.getDateOfBirth());
        return databasePassenger;
    }
}
