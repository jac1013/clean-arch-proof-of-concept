package com.airline.database.passenger;

import com.airline.business.passenger.Gender;
import com.airline.business.passenger.PassengerType;

import java.time.Instant;


public interface PassengerSchema {
    public Long getId();

    public void setId(Long id);

    public String getName();

    public void setName(String name);

    public String getLastName();

    public void setLastName(String lastName);

    public String getPassportId();

    public void setPassportId(String passportId);

    public boolean isNeedsSpecialTreatment();

    public void setNeedsSpecialTreatment(boolean needsSpecialTreatment);

    public PassengerType getPassengerType();

    public void setPassengerType(PassengerType passengerType);

    public Instant getDateOfBirth();

    public void setDateOfBirth(Instant dateOfBirth);

    public Gender getGender();

    public void setGender(Gender gender);
}
