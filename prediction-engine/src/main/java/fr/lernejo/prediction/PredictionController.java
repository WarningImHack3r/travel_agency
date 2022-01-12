package fr.lernejo.prediction;

import fr.lernejo.prediction.data.TemperatureItem;
import fr.lernejo.prediction.data.TemperatureResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PredictionController {

    @GetMapping("/api/temperature")
    public TemperatureResult getTemperatures(@RequestParam String country) {
        return new TemperatureResult(country, List.of(
            new TemperatureItem(
                LocalDate.now().toString(),
                new TemperatureService().getTemperature(country)),
            new TemperatureItem(
                LocalDate.now().minusDays(1).toString(),
                new TemperatureService().getTemperature(country))
        ));
    }
}
