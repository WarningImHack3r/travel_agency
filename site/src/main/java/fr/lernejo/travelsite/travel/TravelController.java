package fr.lernejo.travelsite.travel;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record TravelController(TravelRepository repository) {

    @GetMapping("/api/travels")
    public @NotNull Iterable<TravelEntity> getTravels(@RequestParam String userName) {
        return repository.findAll();
    }
}
