package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Static class to access all Locataire everywhere
 */
public class LocataireCatalogue {
    private static ArrayList<Locataire> createInitLocataires() {
        ArrayList<Locataire> locataires = new ArrayList<Locataire>();

        Locataire l = new Locataire();
        l.setNom("John Smith");
        l.setPhone("450 123 4567");
        l.setCote_credit(670);
        l.setAdresse("60 some address, mtl");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Jean Pierre");
        l.setPhone("450 765 4321");
        l.setCote_credit(700);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Pelagiya Axel");
        l.setPhone("111 111 1111");
        l.setCote_credit(500);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Jordane Memphis");
        l.setPhone("222 222 2222");
        l.setCote_credit(443);
        l.setAdresse("1023 some street, qc");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Nadine Ludger");
        l.setPhone("333 333 3333");
        l.setCote_credit(732);
        l.setAdresse("10235 some street, gatineau");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Wilkie Basant");
        l.setPhone("444 444 4444");
        l.setCote_credit(563);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Salome Barney");
        l.setPhone("555 555 5555");
        l.setCote_credit(300);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Kathy Andrey");
        l.setPhone("666 666 6666");
        l.setCote_credit(925);
        l.setAdresse("215 some road, st-lin");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Anton Hagen");
        l.setPhone("777 777 7777");
        l.setCote_credit(432);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Jean Paul Balfour");
        l.setPhone("888 888 8888");
        l.setCote_credit(654);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Guy Luann");
        l.setPhone("999 999 9999");
        l.setCote_credit(582);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Emmanuel Jena");
        l.setPhone("514 514 5145");
        l.setCote_credit(528);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Kristine Reynold");
        l.setPhone("514 123 4321");
        l.setCote_credit(754);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Léonce Justin");
        l.setPhone("987 789 9898");
        l.setCote_credit(639);
        l.setAdresse("");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Olive Upton");
        l.setPhone("844 937 0707");
        l.setCote_credit(498);
        l.setAdresse("295 some road, laval");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Jenny Manny");
        l.setPhone("911 911 9119");
        l.setCote_credit(598);
        l.setAdresse("999 some street, rawdon");
        locataires.add(l);

        l = new Locataire();
        l.setNom("Nina Alaya");
        l.setPhone("525 252 5252");
        l.setCote_credit(855);
        l.setAdresse("12345 some street, shawinigan");
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
