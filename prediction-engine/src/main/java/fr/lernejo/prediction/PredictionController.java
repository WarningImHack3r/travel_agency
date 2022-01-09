package fr.lernejo.prediction;

import fr.lernejo.travelsite.temperature.data.TemperatureItem;
import fr.lernejo.travelsite.temperature.data.TemperatureResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class PredictionController {

    @GetMapping("/api/temperature")
    public TemperatureResult getTemperatures(@RequestParam String country) {
        return new TemperatureResult(country, List.of(
            new TemperatureItem(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                new TemperatureService().getTemperature(country)),
            new TemperatureItem(
                DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now().plusDays(1)),
                new TemperatureService().getTemperature(country))
        ));
    }
}
