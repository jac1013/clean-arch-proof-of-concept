package com.airline.view.cli;

public class PresenterRequest {
    private final String name;
    private final String lastName;
    private final String dateOfBirth;
    private final String passportId;
    private final String departureCity;
    private final String arrivalCity;
    private final String isFirstClass;

    private PresenterRequest(PresenterRequestBuilder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.passportId = builder.passportId;
        this.departureCity = builder.departureCity;
        this.arrivalCity = builder.arrivalCity;
        this.isFirstClass = builder.isFirstClass;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    String getDateOfBirth() {
        return dateOfBirth;
    }

    String getPassportId() {
        return passportId;
    }

    String getDepartureCity() {
        return departureCity;
    }

    String getArrivalCity() {
        return arrivalCity;
    }

    String getIsFirstClass() {
        return isFirstClass;
    }

    public static class PresenterRequestBuilder {
        private final String name;
        private final String lastName;
        private String dateOfBirth;
        private final String passportId;
        private String departureCity;
        private String arrivalCity;
        private String isFirstClass;

        public PresenterRequestBuilder(String name, String lastName, String passportId) {
            this.name = name;
            this.lastName = lastName;
            this.passportId = passportId;
        }

        public PresenterRequestBuilder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PresenterRequestBuilder departureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        public PresenterRequestBuilder arrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        public PresenterRequestBuilder isFirstClass(String isFirstClass) {
            this.isFirstClass = isFirstClass;
            return this;
        }

        public PresenterRequest build() {
            return new PresenterRequest(this);
        }
    }
}
