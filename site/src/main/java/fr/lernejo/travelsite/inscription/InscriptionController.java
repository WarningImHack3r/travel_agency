package fr.lernejo.travelsite.inscription;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InscriptionController {
    private final ArrayList<Inscription> inscriptions;

    InscriptionController() {
        inscriptions = new ArrayList<>();
    }

    @PostMapping("/api/inscription")
    public void postInscription(@RequestBody Inscription inscription) {
        inscriptions.add(inscription);
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
}
