package fr.lernejo.travelsite.temperature.data;

import java.util.List;

public record TemperatureResult(String country, List<TemperatureItem> temperatures) {}
