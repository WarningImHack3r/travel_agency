package fr.lernejo.prediction.data;

import java.util.List;

public record TemperatureResult(String country, List<TemperatureItem> temperatures) {}
