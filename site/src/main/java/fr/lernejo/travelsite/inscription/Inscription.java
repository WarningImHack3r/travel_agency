package fr.lernejo.travelsite.inscription;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Inscription {
    private String userEmail;
    private String userName;
    private String userCountry;
    private WeatherExpectations weatherExpectation;
    private Integer minimumTemperatureDistance;

    public void setUserEmail(String userEmail) {
        Objects.requireNonNull(userEmail);
        if (!EmailValidator.getInstance().isValid(userEmail))
            throw new IllegalArgumentException("Email is not valid");
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserName(String userName) {
        Objects.requireNonNull(userName);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserCountry(String userCountry) {
        Objects.requireNonNull(userCountry);
        if (!Pattern.compile("^[A-Za-z]{2}$").matcher(userCountry.toUpperCase()).find())
            throw new InputMismatchException("userCountry isn't a 2-letters string");
        this.userCountry = userCountry.toUpperCase();
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setWeatherExpectation(String weatherExpectation) {
        Objects.requireNonNull(weatherExpectation);
        this.weatherExpectation = WeatherExpectations.valueOf(weatherExpectation);
    }

    public String getWeatherExpectation() {
        return weatherExpectation.getValue();
    }

    public void setMinimumTemperatureDistance(Integer minimumTemperatureDistance) {
        if (minimumTemperatureDistance > 39 || minimumTemperatureDistance < 0)
            throw new ArithmeticException("minimumTemperatureDistance should be between 0 and 39");
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }

    public Integer getMinimumTemperatureDistance() {
        return minimumTemperatureDistance;
    }
}
