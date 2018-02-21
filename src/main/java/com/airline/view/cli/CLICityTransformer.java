package com.airline.view.cli;

import com.airline.business.city.City;
import com.airline.business.city.CityFactory;
import org.apache.commons.cli.CommandLine;

class CLICityTransformer {
    private CommandLine line;

    CLICityTransformer(CommandLine line) {
        this.line = line;
    }

    City transformDepartureCity() {
        return this.transform(line, CLIPresenter.DEPARTURE_DATE_SHORT);
    }

    City transformArrivalCity() {
        return this.transform(line, CLIPresenter.ARRIVAL_DATE_SHORT);
    }

    private City transform(CommandLine line, String option) {
        return CityFactory.getCity(line.getOptionValue(option));
    }
}
