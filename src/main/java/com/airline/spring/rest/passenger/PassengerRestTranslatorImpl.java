package com.airline.spring.rest.passenger;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerFactory;
import com.airline.business.passenger.rest.PassengerRestTranslator;
import org.springframework.stereotype.Service;

@Service
public class PassengerRestTranslatorImpl implements PassengerRestTranslator<PassengerRest> {

    private static PassengerFactory passengerFactory;

    static void setPassengerFactory(PassengerFactory passengerFactory) {
        PassengerRestTranslatorImpl.passengerFactory = passengerFactory;
    }

    @Override
    public PassengerRest translate(Passenger passenger) {
        PassengerRest passengerEntity = new PassengerRest();
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
    public Passenger translate(PassengerRest passengerRest) {
        return passengerFactory.create(new Passenger.PassengerBuilder
                (passengerRest.getName(), passengerRest.getLastName(), passengerRest
                        .getPassportId())
                .needsSpecialTreatment(passengerRest.isNeedsSpecialTreatment())
                .gender(passengerRest.getGender())
                .dateOfBirth(passengerRest.getDateOfBirth())
                .type(passengerRest.getPassengerType())
                .id(passengerRest.getId()));
    }
}
