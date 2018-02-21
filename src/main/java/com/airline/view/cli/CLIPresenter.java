package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.passenger.Passenger;
import org.apache.commons.cli.*;

public class CLIPresenter {

    static final String NAME_LONG = "name";
    static final String LAST_NAME_LONG = "last-name";
    static final String DATE_OF_BIRTH_LONG = "date-of-birth";
    static final String PASSPORT_ID_LONG = "passport-id";
    static final String FIRST_CLASS_SHORT = "sf";
    static final String ARRIVAL_DATE_SHORT = "ac";
    static final String DEPARTURE_DATE_SHORT = "dc";
    private static final String CLI_NAME = "airline-booker";

    public CLIPresenterResponse parseCLI(String[] arguments) {
        if (arguments.length == 0) {
            this.printHelp();
        } else {
            return this.parseCommandLine(arguments);
        }

        return null;
    }

    private CLIPresenterResponse parseCommandLine(String[] arguments) {
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine line = parser.parse(this.createCLIOptions(), arguments);
            CLIPassengerTransformer transformer = new CLIPassengerTransformer(line);
            CLICityTransformer cityTransformer = new CLICityTransformer(line);
            Passenger passenger = transformer.transform();
            City from = cityTransformer.transformDepartureCity();
            City to = cityTransformer.transformArrivalCity();
            boolean isFirstClass = transformer.isFirstClass();

            return new CLIPresenterResponse(passenger, from, to, isFirstClass);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }

    private Options createCLIOptions() {
        Options options = new Options();
        options.addOption("n", NAME_LONG, true, "Name of the Passenger.");
        options.addOption("l", LAST_NAME_LONG, true, "Last name of the Passenger.");
        options.addOption("d", DATE_OF_BIRTH_LONG, true, "Date of birth of the Passenger. (use this format, yyyy-mm-dd");
        options.addOption("p", PASSPORT_ID_LONG, true, "Passport ID of the Passenger.");
        options.addOption(DEPARTURE_DATE_SHORT, "departure-city", true, "Departure City");
        options.addOption(ARRIVAL_DATE_SHORT, "arrival-city", true, "Arrival City");
        options.addOption(FIRST_CLASS_SHORT, "seat-first-class", true, "whether this is a first class reservation or not");
        return options;
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CLI_NAME, this.createCLIOptions());
    }
}

