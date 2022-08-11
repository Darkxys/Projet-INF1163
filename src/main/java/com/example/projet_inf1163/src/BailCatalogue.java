package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BailCatalogue {
    private static ArrayList<Bail> createInitBails() {
        ArrayList<Bail> bails = new ArrayList<Bail>();

        Locataire l = LocataireCatalogue.getLocataire(0);
        Bail b = new Bail(l);
        LocalDateTime now = LocalDateTime.now();
        b.setDate_debut(now);
        b.setAssurance("1234567890");
        b.setRenouvelable(true);
        b.setDate_fin(now.plusYears(1));

        bails.add(b);

        l = LocataireCatalogue.getLocataire(1);
        b = new Bail(l);
        now = LocalDateTime.now();
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
    public static void setBail(Bail bail, int index) {
        if(index < bails.size()){
            try {
                bails.set(index, bail);
            }
            catch (Exception e) {

            }
        }
    }
}
