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

    public static class PassengerBuilder {
        final String name;
        final String lastName;
        final String passportId;
        Instant dateOfBirth;
        Gender gender;
        boolean needsSpecialTreatment;
        PassengerType passengerType = PassengerType.STANDARD;

        public PassengerBuilder(String name, String lastName, String passportId) {
            this.name = name;
            this.lastName = lastName;
            this.passportId = passportId;
        }

        public PassengerBuilder dateOfBirth(Instant dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PassengerBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PassengerBuilder needsSpecialTreatment(boolean needsSpecialTreatment) {
            this.needsSpecialTreatment = needsSpecialTreatment;
            return this;
        }

        public PassengerBuilder type(PassengerType passengerType) {
            this.passengerType = passengerType;
            return this;
        }

        public Passenger build() {
            switch (passengerType) {
                case STANDARD:
                default:
                    return new StandardPassenger(this);

            }
        }
    }
}

