package fr.lernejo.travelsite.temperature;

import org.apache.commons.validator.routines.DateValidator;

public record TemperatureItem(String date, Number temperature) {
    public TemperatureItem {
        if (!DateValidator.getInstance().isValid(date))
            throw new IllegalArgumentException("date field doesn't seem to be a valid date");
    }
}
