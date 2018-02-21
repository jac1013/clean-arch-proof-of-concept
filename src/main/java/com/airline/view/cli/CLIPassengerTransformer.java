package com.airline.view.cli;

import com.airline.business.passenger.Passenger;
import com.airline.business.passenger.PassengerBuilder;
import org.apache.commons.cli.CommandLine;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

class CLIPassengerTransformer {
    private CommandLine line;

    CLIPassengerTransformer(CommandLine line) {
        this.line = line;
    }

    Passenger transform() throws NoBirthDateProvidedException {
        return new PassengerBuilder().setName(line.getOptionValue(CLIPresenter.NAME_LONG)).setLastName(line.getOptionValue(CLIPresenter.LAST_NAME_LONG))
                .setDateOfBirth(this.getDateOfBirth()).setPassportId(line.getOptionValue(CLIPresenter.PASSPORT_ID_LONG)).build();
    }

    private Instant getDateOfBirth() throws NoBirthDateProvidedException {
        Instant instant;
        try {
            LocalDate date = LocalDate.parse(line.getOptionValue(CLIPresenter.DATE_OF_BIRTH_LONG));
            instant = date.atStartOfDay(ZoneId.of("UTC")).toInstant();
        } catch (Exception exception) {
            throw new NoBirthDateProvidedException();
        }
        return instant;
    }

    boolean isFirstClass() {
        return Boolean.valueOf(line.getOptionValue(CLIPresenter.FIRST_CLASS_SHORT));
    }

    private class NoBirthDateProvidedException extends Exception {

    }
}
