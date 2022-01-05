package fr.lernejo.travelsite.travel;

import java.util.Objects;

public class Travel {
    static Long globalId = 0L;
    private final Long id;
    private final String country;
    private final Number temperature;

    Travel(String country, Number temperature) {
        Objects.requireNonNull(country);
        Objects.requireNonNull(temperature);
        this.id = globalId++;
        this.country = country;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Number getTemperature() {
        return temperature;
    }
}
