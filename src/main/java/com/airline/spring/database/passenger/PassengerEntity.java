package com.airline.spring.database.passenger;

import com.airline.business.passenger.Gender;
import com.airline.business.passenger.PassengerType;
import com.airline.business.passenger.database.PassengerSchema;
import com.airline.spring.database.InstantPersistenceConverter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity(name="Passenger")
@Table(name="passenger")
public class PassengerEntity implements PassengerSchema {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String passportId;

    @Column(name="isSpecial")
    private boolean needsSpecialTreatment;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;

    @Convert(converter = InstantPersistenceConverter.class)
    private Instant dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportId='" + passportId + '\'' +
                ", needsSpecialTreatment=" + needsSpecialTreatment +
                ", passengerType=" + passengerType +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }

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
