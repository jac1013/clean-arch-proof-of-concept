package com.airline.business.passenger;

import java.time.Instant;

public abstract class Passenger {
    String name;
    String lastName;
    String passportId;
    Instant dateOfBirth;
    Gender gender;
    boolean needsSpecialTreatment;

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportId='" + passportId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", needsSpecialTreatment=" + needsSpecialTreatment +
                '}';
    }
}

