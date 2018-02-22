package com.airline.view.cli;

import org.apache.commons.cli.*;

import java.util.Optional;


class Presenter {

    private static final String NAME_LONG = "name";
    private static final String NAME_SHORT = "n";
    private static final String LAST_NAME_LONG = "last-name";
    private static final String LAST_NAME_SHORT = "l";
    private static final String DATE_OF_BIRTH_LONG = "date-of-birth";
    private static final String DATE_OF_BIRTH_SHORT = "d";
    private static final String PASSPORT_ID_LONG = "passport-id";
    private static final String PASSPORT_ID_SHORT = "p";
    private static final String DEPARTURE_DATE_LONG = "departure-city";
    private static final String DEPARTURE_DATE_SHORT = "dc";
    private static final String ARRIVAL_DATE_LONG = "arrival-city";
    private static final String ARRIVAL_DATE_SHORT = "ac";
    private static final String FIRST_CLASS_LONG = "seat-first-class";
    private static final String FIRST_CLASS_SHORT = "sf";
    private static final String CLI_NAME = "airline-booker";
    private final String[] arguments;

    Presenter(String[] arguments) {
        this.arguments = arguments;
    }

    Optional<PresenterRequest> parseCommandLine() {
        if (shouldPrintHelp()) {
            printHelp();
        } else {
            return Optional.of(parseCommandLineArguments());
        }

        return Optional.empty();
    }

    private boolean shouldPrintHelp() {
        return arguments.length == 0;
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CLI_NAME, createCLIOptions());
    }

    private PresenterRequest parseCommandLineArguments() {
        PresenterRequest request = null;
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine line = parser.parse(createCLIOptions(), arguments);
            request = new PresenterRequest.CLIPresenterRequestBuilder(line.getOptionValue(NAME_LONG), line.getOptionValue(LAST_NAME_LONG), line.getOptionValue(PASSPORT_ID_LONG))
                    .dateOfBirth(line.getOptionValue(DATE_OF_BIRTH_LONG))
                    .isFirstClass(line.getOptionValue(FIRST_CLASS_LONG))
                    .departureCity(line.getOptionValue(DEPARTURE_DATE_LONG))
                    .arrivalCity(line.getOptionValue(ARRIVAL_DATE_LONG))
                    .build();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return request;
    }

    private Options createCLIOptions() {
        Options options = new Options();
        options.addOption(NAME_SHORT, NAME_LONG, true, "Name of the Passenger.");
        options.addOption(LAST_NAME_SHORT, LAST_NAME_LONG, true, "Last name of the Passenger.");
        options.addOption(DATE_OF_BIRTH_SHORT, DATE_OF_BIRTH_LONG, true, "Date of birth of the Passenger. (use this format, yyyy-mm-dd");
        options.addOption(PASSPORT_ID_SHORT, PASSPORT_ID_LONG, true, "Passport ID of the Passenger.");
        options.addOption(DEPARTURE_DATE_SHORT, DEPARTURE_DATE_LONG, true, "Departure City");
        options.addOption(ARRIVAL_DATE_SHORT, ARRIVAL_DATE_LONG, true, "Arrival City");
        options.addOption(FIRST_CLASS_SHORT, FIRST_CLASS_LONG, true, "whether this is a first class reservation or not");
        return options;
    }
}

