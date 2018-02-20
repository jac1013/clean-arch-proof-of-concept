package com.airline.business.passenger;

import java.time.Instant;

public class PassengerBuilder {
    private String name;
    private String lastName;
    private String passportId;
    private Instant dateOfBirth;
    private Gender gender;
    private boolean hasSpecialNeeds;
    private PassengerType passengerType;

    public PassengerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PassengerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerBuilder setPassportId(String passportId) {
        this.passportId = passportId;
        return this;
    }

    public PassengerBuilder setDateOfBirth(Instant date) {
        this.dateOfBirth = date;
        return this;
    }

    public PassengerBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PassengerBuilder setHasSpecialNeeds(boolean hasSpecialNeeds) {
        this.hasSpecialNeeds = hasSpecialNeeds;
        return this;
    }

    public PassengerBuilder setType(PassengerType passengerType) {
        this.passengerType = passengerType;
        return this;
    }

    public Passenger build() {
        switch (this.passengerType) {
            case STANDARD:
            default:
                return new StandardPassenger(this.name, this.lastName, this.passportId, this.dateOfBirth, this.gender, this.hasSpecialNeeds);

        }
    }
}
