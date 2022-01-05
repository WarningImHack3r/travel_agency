package fr.lernejo.travelsite.travel;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TravelController {
    private final ArrayList<Travel> travels;

    TravelController() {
        travels = new ArrayList<>();
    }

    @GetMapping("/api/travels")
    public  Iterable<Travel> getTravels(@RequestParam String userName) {
        return travels;
    }
}
