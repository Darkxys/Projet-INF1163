package com.example.projet_inf1163.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BailTest {
    @Test
    public void createBail(){
        Locataire l = LocataireCatalogue.getLocataire(0);
        Unite u = UniteCatalogue.getUnit(0);
        u.setPrix(122.4f);
        Bail b = new Bail(l);
        b.setUnite(u);
        LocalDateTime now = LocalDateTime.now();
        b.setDate_debut(now);
        b.setAssurance("1234567890");
        b.setRenouvelable(true);
        b.setDate_fin(now.plusYears(1));
        b.setPeriode(new Periode(1));
        BailCatalogue.addBail(b);

        assertTrue(BailCatalogue.getBails().contains(b));
    }

    @Test
    public void updateBail(){
        Locataire l = LocataireCatalogue.getLocataire(0);
        Unite u = UniteCatalogue.getUnit(0);
        u.setPrix(122.4f);
        Bail b = BailCatalogue.getBail(0);
        b.setUnite(u);
        LocalDateTime now = LocalDateTime.now();
        b.setDate_debut(now);
        b.setAssurance("1234567890");
        b.setRenouvelable(true);
        b.setDate_fin(now.plusYears(1));
        b.setPeriode(new Periode(1));
        BailCatalogue.setBail(b,0);

        assertTrue(BailCatalogue.getBails().contains(b));
    }

    @Test
    public void renewBail(){
        Bail b = BailCatalogue.getBail(0);
        Bail newB = b.renew();

        assertTrue(BailCatalogue.getBails().contains(newB));
    }
}