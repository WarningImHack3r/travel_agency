package fr.lernejo.travelsite.temperature;

import java.util.List;
import java.util.Objects;

public class Temperature {
    private String country;
    private List<TemperatureItem> temperatureItems;

    public void setCountry(String country) {
        Objects.requireNonNull(country);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setTemperatureItems(List<TemperatureItem> temperatureItems) {
        Objects.requireNonNull(temperatureItems);
        this.temperatureItems = temperatureItems;
    }

    public List<TemperatureItem> getTemperatureItems() {
        return temperatureItems;
    }
}
