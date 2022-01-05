package fr.lernejo.travelsite.travel;

import java.util.Objects;

public class Travel {
    private String country;
    private Number temperature;

    public void setCountry(String country) {
        Objects.requireNonNull(country);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setTemperature(Number temperature) {
        Objects.requireNonNull(temperature);
        this.temperature = temperature;
    }

    public Number getTemperature() {
        return temperature;
    }
}
