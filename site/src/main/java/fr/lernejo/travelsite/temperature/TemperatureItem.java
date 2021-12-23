package fr.lernejo.travelsite.temperature;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

public record TemperatureItem(@NotNull @DateTimeFormat String date, @NotNull Number temperature) {}
