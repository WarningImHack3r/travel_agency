package fr.lernejo.travelsite.temperature;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

@RestController
public class TemperatureController {

    private Spliterator<Temperature> fetchResultsFromBackend() {
        return null;
    }

    @GetMapping("/api/temperature")
    public ResponseEntity<Iterable<Temperature>> getTemperatures(@RequestParam String country) {
        Iterator<Temperature> iterator = StreamSupport.stream(fetchResultsFromBackend(), false)
            .filter(e -> e.country().equals(country))
            .iterator();
        if (!iterator.hasNext())
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(() -> iterator, HttpStatus.OK);
    }
}
