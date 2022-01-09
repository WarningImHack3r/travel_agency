package fr.lernejo.travelsite.inscription;

import fr.lernejo.travelsite.storage.Storage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscriptionController {

    @PostMapping("/api/inscription")
    public void postInscription(@RequestBody Inscription inscription) {
        Storage.addInscription(inscription);
    }
}
