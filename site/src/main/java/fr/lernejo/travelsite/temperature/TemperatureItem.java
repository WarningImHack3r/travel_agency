package fr.lernejo.travelsite.temperature;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

public class TemperatureItem {
    private final String date;
    private final Number temperature;

    TemperatureItem(@DateTimeFormat String date, Number temperature) {
        Objects.requireNonNull(date);
        Objects.requireNonNull(temperature);
        this.date = date;
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public Number getTemperature() {
        return temperature;
    }
}
