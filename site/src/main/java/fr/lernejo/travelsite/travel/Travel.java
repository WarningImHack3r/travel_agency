package fr.lernejo.travelsite.travel;

import java.util.Objects;

public class Travel {
    private final String country;
    private final Number temperature;

    Travel(String country, Number temperature) {
        Objects.requireNonNull(country);
        Objects.requireNonNull(temperature);
        this.country = country;
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public Number getTemperature() {
        return temperature;
    }
}
