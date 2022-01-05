package fr.lernejo.travelsite.temperature;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

public class TemperatureItem {
    private String date;
    private Number temperature;

    public void setDate(@DateTimeFormat String date) {
        Objects.requireNonNull(date);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTemperature(Number temperature) {
        Objects.requireNonNull(temperature);
        this.temperature = temperature;
    }

    public Number getTemperature() {
        return temperature;
    }
}
