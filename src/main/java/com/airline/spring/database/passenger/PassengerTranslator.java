package com.airline.spring.database.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerFactory;
import com.airline.business.passenger.database.PassengerDatabaseTranslator;
import org.springframework.stereotype.Service;

@Service
public class PassengerTranslator implements PassengerDatabaseTranslator<PassengerEntity> {
    private PassengerFactory passengerFactory;

    public PassengerTranslator(PassengerFactory passengerFactory) {
        this.passengerFactory = passengerFactory;
    }

    @Override
    public PassengerEntity translate(Passenger passenger) {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setName(passenger.getName());
        passengerEntity.setLastName(passenger.getLastName());
        passengerEntity.setPassportId(passenger.getPassportId());
        passengerEntity.setNeedsSpecialTreatment(passenger.isNeedsSpecialTreatment());
        passengerEntity.setGender(passenger.getGender());
        passengerEntity.setPassengerType(passenger.getPassengerType());
        passengerEntity.setDateOfBirth(passenger.getDateOfBirth());
        passengerEntity.setId(passenger.getId());
        return passengerEntity;
    }

    @Override
    public Passenger translate(PassengerEntity passengerEntity) {
        return passengerFactory.create(new Passenger.PassengerBuilder
                (passengerEntity.getName(), passengerEntity.getLastName(), passengerEntity
                        .getPassportId())
                .needsSpecialTreatment(passengerEntity.isNeedsSpecialTreatment())
                .gender(passengerEntity.getGender())
                .dateOfBirth(passengerEntity.getDateOfBirth())
                .type(passengerEntity.getPassengerType())
                .id(passengerEntity.getId()));
    }
}
