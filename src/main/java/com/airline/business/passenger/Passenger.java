package com.airline.business.passenger;

import java.time.Instant;

public abstract class Passenger {
    Long id;
    String name;
    String lastName;
    String passportId;
    Instant dateOfBirth;
    Gender gender;
    boolean needsSpecialTreatment;
    PassengerType passengerType;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportId() {
        return passportId;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isNeedsSpecialTreatment() {
        return needsSpecialTreatment;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }


    public Long getId() {
        return id;
    }

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
        Long id;
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
            if(passengerType != null) {
                this.passengerType = passengerType;
            }
            return this;
        }

        public PassengerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        Passenger build() {
            switch (passengerType) {
                case STANDARD:
                default:
                    return new StandardPassenger(this);

            }
        }
    }
}

