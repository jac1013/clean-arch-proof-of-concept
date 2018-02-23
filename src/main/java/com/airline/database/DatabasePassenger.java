package com.airline.database;

import com.airline.business.passenger.Gender;

import javax.persistence.*;

@Entity
@Table(name="passenger")
public class DatabasePassenger {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String passportId;
    private boolean specialTreatment;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    DatabasePassenger() {
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getPassportId() {
        return passportId;
    }

    void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    boolean isNeedsSpecialTreatment() {
        return specialTreatment;
    }

    void setNeedsSpecialTreatment(boolean needsSpecialTreatment) {
        this.specialTreatment = needsSpecialTreatment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
