package com.airline.business.passenger.database;

import com.airline.business.passenger.Gender;
import com.airline.business.passenger.PassengerType;

import java.time.Instant;

public interface PassengerSchema {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    String getLastName();
    void setLastName(String lastName);
    String getPassportId();
    void setPassportId(String passportId);
    boolean isNeedsSpecialTreatment();
    void setNeedsSpecialTreatment(boolean needsSpecialTreatment);
    PassengerType getPassengerType();
    void setPassengerType(PassengerType passengerType);
    Instant getDateOfBirth();
    void setDateOfBirth(Instant dateOfBirth);
    Gender getGender();
    void setGender(Gender gender);
}
