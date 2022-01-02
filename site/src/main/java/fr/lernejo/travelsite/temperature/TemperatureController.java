package fr.lernejo.travelsite.temperature;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class TemperatureController {

    private @NotNull Spliterator<TemperatureEntity> fetchResultsFromBackend() {
        return null;
    }

    @GetMapping("/api/temperature")
    public @NotNull ResponseEntity<Iterable<TemperatureEntity>> getTemperatures(@RequestParam String country) {
        Stream<TemperatureEntity> stream = StreamSupport.stream(fetchResultsFromBackend(), false)
            .filter(e -> e.country.equals(country));
        if (stream.findAny().isEmpty())
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(stream::iterator, HttpStatus.OK);
    }
}
