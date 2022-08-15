package com.example.projet_inf1163.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    public void createUnit(){
        Unite u = new Unite();
        u.setPrix(12.5f);
        u.setOwner(LocataireCatalogue.getLocataire(0));
        u.setBuiltDate(LocalDate.now());
        u.setType(Unite.UnitType.Commercial);
        u.setRentable(true);
        u.setRentIndication(Unite.RentIndication.Libre);
        u.setQttRoom(2);
        u.setQttBathRoom(1);
        u.setAir(120);
        u.setAdresse("adresse");
        u.updateIdentifiant();
        UniteCatalogue.addUnit(u);

        Assertions.assertEquals(UniteCatalogue.getUnits().contains(u), true);
    }

    @Test
    public void updateUnit(){
        Unite u = UniteCatalogue.getUnit(0);
        u.setPrix(12.5f);
        u.setOwner(LocataireCatalogue.getLocataire(0));
        u.setBuiltDate(LocalDate.now());
        u.setType(Unite.UnitType.Commercial);
        u.setRentable(true);
        u.setRentIndication(Unite.RentIndication.Libre);
        u.setQttRoom(2);
        u.setQttBathRoom(1);
        u.setAir(120);
        u.setAdresse("adresse");
        u.updateIdentifiant();
        UniteCatalogue.setUnit(u,0);

        Assertions.assertEquals(UniteCatalogue.getUnits().contains(u), true);
    }
}