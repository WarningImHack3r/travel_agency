package fr.lernejo.travelsite.travel;

import fr.lernejo.travelsite.inscription.Inscription;
import fr.lernejo.travelsite.inscription.WeatherExpectations;
import fr.lernejo.travelsite.storage.Storage;
import fr.lernejo.travelsite.temperature.TemperatureService;
import fr.lernejo.travelsite.temperature.data.TemperatureItem;
import fr.lernejo.travelsite.temperature.data.TemperatureResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public record TravelController(TemperatureService service) {

    private double temperatureItemsToDouble(List<TemperatureItem> items) {
        return items.stream().mapToDouble(item -> item.temperature().doubleValue()).average().orElse(Double.NaN);
    }

    private Iterable<Destination> mostRelevantDestinations(String country, WeatherExpectations colderOrWarmer, Integer of) {
        List<TemperatureResult> results = new ArrayList<>();
        // Loop countries.txt
        try {
            new String(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("countries.txt")).readAllBytes(), StandardCharsets.UTF_8)
                .lines().forEach(c -> results.add(service.getTemperatures(c))); // Fetch /api/temperature for all
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Calculate
        double currentCountryTemperature = temperatureItemsToDouble(results.stream().filter(c -> c.country().equals(country)).findFirst().orElseThrow().temperatureItems());
        return () -> results.stream().filter(result -> {
            double average = temperatureItemsToDouble(result.temperatureItems());
            return (colderOrWarmer.equals(WeatherExpectations.COLDER) && currentCountryTemperature - of > average) ||
                       (colderOrWarmer.equals(WeatherExpectations.WARMER) && currentCountryTemperature + of < average);
        }).map(e -> new Destination(e.country(), temperatureItemsToDouble(e.temperatureItems()))).iterator();
    }

    @GetMapping("/api/travels")
    public Iterable<Destination> getTravels(@RequestParam String userName) {
        Inscription relatedInscription = Storage.getInscriptions()
            .stream()
            .filter(inscription -> inscription.userName().equals(userName))
            .reduce((first, second) -> second) // find last occurrence
            .orElseThrow();
        return mostRelevantDestinations(
            relatedInscription.userCountry(),
            WeatherExpectations.valueOf(relatedInscription.weatherExpectation()),
            relatedInscription.minimumTemperatureDistance()
        );
    }
}
