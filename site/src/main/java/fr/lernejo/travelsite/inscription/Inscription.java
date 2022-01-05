package fr.lernejo.travelsite.inscription;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Inscription {
    private static Long globalId = 0L;
    private final Long id;
    private final String userEmail;
    private final String userName;
    private final String userCountry;
    private final WeatherExpectations weatherExpectation;
    private final Integer minimumTemperatureDistance;

    Inscription(String userEmail, String userName, String userCountry, WeatherExpectations weatherExpectation, Integer minimumTemperatureDistance) {
        if (!EmailValidator.getInstance().isValid(userEmail))
            throw new IllegalArgumentException("Email is not valid");
        if (!Pattern.compile("^[A-Z]{2}$").matcher(userCountry.toUpperCase()).find())
            throw new InputMismatchException("userCountry isn't a 2-letters string");
        if (minimumTemperatureDistance > 39 || minimumTemperatureDistance < 0)
            throw new ArithmeticException("minimumTemperatureDistance should be between 0 and 39");
        Objects.requireNonNull(userEmail);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(userCountry);
        Objects.requireNonNull(weatherExpectation);
        Objects.requireNonNull(minimumTemperatureDistance);
        this.id = globalId++;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry.toUpperCase();
        this.weatherExpectation = weatherExpectation;
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }

    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public WeatherExpectations getWeatherExpectation() {
        return weatherExpectation;
    }

    public Integer getMinimumTemperatureDistance() {
        return minimumTemperatureDistance;
    }
}
