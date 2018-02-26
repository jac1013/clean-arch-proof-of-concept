package com.airline.business.passenger;

class StandardPassenger extends Passenger {
    StandardPassenger(Passenger.PassengerBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.passportId = builder.passportId;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.needsSpecialTreatment = builder.needsSpecialTreatment;
        this.passengerType = builder.passengerType;
    }
}
