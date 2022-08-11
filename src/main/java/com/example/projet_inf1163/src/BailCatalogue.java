package com.example.projet_inf1163.src;

import java.time.LocalDate;
import java.util.ArrayList;

public class BailCatalogue {
    private static ArrayList<Bail> createInitBails() {
        ArrayList<Bail> bails = new ArrayList<Bail>();

        Locataire l = new Locataire();
        l.setNom("Jérémie Ouimet");
        l.setPhone("450 123 4567");
        Bail b = new Bail(l);
        LocalDate now = LocalDate.now();
        b.setDate_debut(now);
        b.setAssurance("1234567890");
        b.setRenouvelable(true);
        b.setDate_fin(now.plusYears(1));

        bails.add(b);

        l = new Locataire();
        l.setNom("Francis Painchaud");
        l.setPhone("450 765 4321");
        b = new Bail(l);
        now = LocalDate.now();
        b.setDate_debut(now);
        b.setAssurance("0987654321");
        b.setRenouvelable(false);
        b.setDate_fin(now.plusYears(1));

        bails.add(b);

        return bails;
    }

    private static ArrayList<Bail> bails = createInitBails();

    public static Bail getBail(int i) {
        try {
            return bails.get(i);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<Bail> getBails() {
        return bails;
    }

    public static void addBail(Bail bail) {
        bails.add(bail);
    }
}
