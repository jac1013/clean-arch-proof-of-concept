package com.airline.database.spring.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.database.passenger.PassengerDatabaseTransformer;

public class PassengerTransformer implements PassengerDatabaseTransformer<PassengerEntity> {
    @Override
    public PassengerEntity transform(Passenger passenger) {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setName(passenger.getName());
        passengerEntity.setLastName(passenger.getLastName());
        passengerEntity.setPassportId(passenger.getPassportId());
        passengerEntity.setNeedsSpecialTreatment(passenger.isNeedsSpecialTreatment());
        passengerEntity.setGender(passenger.getGender());
        passengerEntity.setPassengerType(passenger.getPassengerType());
        passengerEntity.setDateOfBirth(passenger.getDateOfBirth());
        return passengerEntity;
    }
}
