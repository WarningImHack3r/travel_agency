package fr.lernejo.travelsite.temperature;

import java.util.List;
import java.util.Objects;

public class Temperature {
    private static Long globalId = 0L;
    private final Long id;
    private final String country;
    private final List<TemperatureItem> temperatureItems;

    Temperature(String country, List<TemperatureItem> temperatureItems) {
        Objects.requireNonNull(country);
        Objects.requireNonNull(temperatureItems);
        this.id = globalId++;
        this.country = country;
        this.temperatureItems = temperatureItems;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public List<TemperatureItem> getTemperatureItems() {
        return temperatureItems;
    }
}
