package fr.lernejo.travelsite.temperature;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public record TemperatureController(TemperatureRepository repository) {

    @GetMapping("/api/temperature")
    public @NotNull ResponseEntity<Iterable<TemperatureEntity>> getTemperatures(@RequestParam String country) {
        Stream<TemperatureEntity> stream = StreamSupport.stream(repository.findAll().spliterator(), false)
            .filter(e -> e.country.equals(country));
        if (stream.findAny().isEmpty())
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(stream::iterator, HttpStatus.OK);
    }
}
