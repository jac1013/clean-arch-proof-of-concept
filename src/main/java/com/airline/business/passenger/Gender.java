package com.airline.business.passenger;

public enum Gender {
    MASCULINE("M"),
    FEMENINE("F"),
    UNDEFINED("U");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return this.gender;
    }
}
