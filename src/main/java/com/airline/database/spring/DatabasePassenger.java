package com.airline.database.spring;

import com.airline.business.passenger.Gender;
import com.airline.business.passenger.PassengerType;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="passenger")
public class DatabasePassenger {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String passportId;

    @Column(name="isSpecial")
    private boolean needsSpecialTreatment;

    @Column(name="type")
    private PassengerType passengerType;

    private Instant dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    DatabasePassenger() {
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
