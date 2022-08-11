package com.example.projet_inf1163.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BailTest {
    @Test
    public void calculateSubtotalTest(){
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

        Assertions.assertEquals(Math.round(b.calculateSubtotal() * 100), 12240);
    }

    @Test
    public void calculateTPSTest(){
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

        Assertions.assertEquals(Math.round(b.calculateTPS() * 100), 12240*0.05);
    }

    @Test
    public void calculateTVQTest(){
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

        long answer = Math.round(122.4f * 0.09975 * 100);

        Assertions.assertEquals(Math.round(b.calculateTVQ() * 100), answer);
    }

    @Test
    public void calculateTotalTest(){
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

        long answer = Math.round(122.4f * 1.14975 * 100);
        Assertions.assertEquals(Math.round(b.calculateTotal() * 100), answer);
    }

    @Test
    public void calculateUnitPriceForPeriodTest(){
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

        Assertions.assertEquals(Math.round(b.calculateUnitPriceForPeriod(LocalDateTime.now()) * 100), 12240);
    }

    @Test
    public void calculateSubtotalForPeriodTest(){
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

        Assertions.assertEquals(Math.round(b.calculateSubtotalForPeriod(LocalDateTime.now()) * 100), 12240);
    }

    @Test
    public void calculateTPSForPeriodTest(){
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

        Assertions.assertEquals(Math.round(b.calculateTPSForPeriod(LocalDateTime.now()) * 100), 12240 * 0.05);
    }

    @Test
    public void calculateTVQForPeriodTest(){
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

        long answer = Math.round(122.4f * 0.09975 * 100);

        Assertions.assertEquals(Math.round(b.calculateTVQForPeriod(LocalDateTime.now()) * 100), answer);
    }

    @Test
    public void calculateTotalForPeriodTest(){
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

        long answer = Math.round(122.4f * 1.14975 * 100);

        Assertions.assertEquals(Math.round(b.calculateTotalForPeriod(LocalDateTime.now()) * 100), answer);
    }

    @Test
    public void calculateExtraPriceForPeriodTest(){
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
        b.setExtra(new Extra("","",345.34f));

        Assertions.assertEquals(Math.round(b.calculateExtraPriceForPeriod(LocalDateTime.now()) * 100), 34534);
    }
}