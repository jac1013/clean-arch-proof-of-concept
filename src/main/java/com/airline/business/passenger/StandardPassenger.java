package com.airline.business.passenger;

import java.time.Instant;

class StandardPassenger extends Passenger {
    StandardPassenger(String name, String lastName, String passportId, Instant dateOfBirth, Gender gender, boolean needsSpecialTreatment) {
        this.name = name;
        this.lastName = lastName;
        this.passportId = passportId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.needsSpecialTreatment = needsSpecialTreatment;
    }
}
