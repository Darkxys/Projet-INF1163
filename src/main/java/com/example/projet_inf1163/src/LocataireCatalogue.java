package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LocataireCatalogue {
    private static ArrayList<Locataire> createInitLocataires() {
        ArrayList<Locataire> locataires = new ArrayList<Locataire>();

        Locataire l = new Locataire();
        l.setNom("Jérémie Ouimet");
        l.setPhone("450 123 4567");
        l.setCote_credit(670);
        l.setAdresse("60 some address, mtl");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Francis Painchaud");
        l.setPhone("450 765 4321");
        l.setCote_credit(700);
        l.setAdresse("");
        locataires.add(l);

        return locataires;
    }

    private static ArrayList<Locataire> locataires = createInitLocataires();

    public static Locataire getLocataire(int i) {
        try {
            return locataires.get(i);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<Locataire> getLocataires() {
        return locataires;
    }

    public static void addLocataire(Locataire locataire) {
        locataires.add(locataire);
    }
}
