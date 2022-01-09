package fr.lernejo.travelsite.storage;

import fr.lernejo.travelsite.inscription.Inscription;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final ArrayList<Inscription> INSCRIPTIONS = new ArrayList<>();

    private Storage() {}

    public static void addInscription(Inscription inscription) {
        INSCRIPTIONS.add(inscription);
    }

    public static List<Inscription> getInscriptions() {
        return INSCRIPTIONS;
    }
}
