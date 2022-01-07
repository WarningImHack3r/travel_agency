package fr.lernejo.travelsite.inscription;

import org.apache.commons.validator.routines.EmailValidator;

public record Inscription(String userEmail, String userName, String userCountry, String weatherExpectation, Integer minimumTemperatureDistance) {
    public Inscription {
        if (!EmailValidator.getInstance().isValid(userEmail))
            throw new IllegalArgumentException("userEmail doesn't seem to be a valid email");

        try {
            WeatherExpectations.valueOf(weatherExpectation.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("weatherExpectation should be \"WARMER\" or \"COLDER\"");
        }

        if (minimumTemperatureDistance < 0 || minimumTemperatureDistance > 39)
            throw new NumberFormatException("minimumTemperatureDistance should be between 0 and 39");
    }
}
