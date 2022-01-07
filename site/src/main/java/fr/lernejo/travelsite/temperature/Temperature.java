package fr.lernejo.travelsite.temperature;

import java.util.List;

public record Temperature(String country, List<TemperatureItem> temperatureItems) {}
