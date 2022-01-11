package fr.lernejo.travelsite.travel;

import fr.lernejo.travelsite.inscription.Inscription;
import fr.lernejo.travelsite.inscription.WeatherExpectations;
import fr.lernejo.travelsite.temperature.TemperatureService;
import fr.lernejo.travelsite.temperature.data.TemperatureItem;
import fr.lernejo.travelsite.temperature.data.TemperatureResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class TravelController {
    private final TemperatureService service;
    private final List<Inscription> inscriptions;

    public TravelController(TemperatureService service) {
        this.service = service;
        inscriptions = new ArrayList<>();
    }

    @PostMapping("/api/inscription")
    public void postInscription(@RequestBody Inscription inscription) {
        inscriptions.add(inscription);
    }

    private double temperaturesToDouble(List<TemperatureItem> items) {
        return items.stream().mapToDouble(item -> item.temperature().doubleValue()).average().orElse(Double.NaN);
    }

    private Iterable<Destination> mostRelevantDestinations(String country, WeatherExpectations colderOrWarmer, Integer of) {
        String fileContent = null;
        try {
            fileContent = new String(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("countries.txt")).readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fileContent != null;
        TemperatureResult currentResult = service.getTemperatures(country);
        double currentCountryTemperature = currentResult != null ? temperaturesToDouble(currentResult.temperatures()) : 0.0;
        String finalFileContent = fileContent;
        return () -> finalFileContent.lines().filter(Objects::nonNull).map(service::getTemperatures).filter(Objects::nonNull).filter(result -> {
            double average = temperaturesToDouble(result.temperatures());
            return (colderOrWarmer.equals(WeatherExpectations.COLDER) && currentCountryTemperature - of >= average) ||
                       (colderOrWarmer.equals(WeatherExpectations.WARMER) && currentCountryTemperature + of <= average);
        }).map(e -> new Destination(e.country(), temperaturesToDouble(e.temperatures()))).iterator();
    }

    @GetMapping("/api/travels")
    public Iterable<Destination> getTravels(@RequestParam String userName) {
        Inscription relatedInscription = inscriptions.stream()
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
