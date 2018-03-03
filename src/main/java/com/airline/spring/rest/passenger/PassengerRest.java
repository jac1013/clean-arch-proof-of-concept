package com.airline.spring.rest.passenger;

import com.airline.business.passenger.Gender;
import com.airline.business.passenger.PassengerType;

import java.time.Instant;

public class PassengerRest implements com.airline.business.passenger.rest.PassengerRest {
    private Long id;
    private String name;
    private String lastName;
    private String passportId;
    private boolean needsSpecialTreatment;
    private PassengerType passengerType;
    private Instant dateOfBirth;
    private Gender gender;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public boolean isNeedsSpecialTreatment() {
        return needsSpecialTreatment;
    }

    public void setNeedsSpecialTreatment(boolean needsSpecialTreatment) {
        this.needsSpecialTreatment = needsSpecialTreatment;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
