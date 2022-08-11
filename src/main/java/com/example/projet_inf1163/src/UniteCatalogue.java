package com.example.projet_inf1163.src;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Static class to access all Units everywhere
 */
public class UniteCatalogue {
    private static ArrayList<Unite> createInitUnit() {
        ArrayList<Unite> units = new ArrayList<>();

        Locataire l = new Locataire();
        l.setNom("Jérémie Ouimet");
        l.setPhone("450 123 4567");
        Unite u = new Unite();
        u.setOwner(l);
        u.setAdresse("12 12 adresse");
        u.setAir(12);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(true);
        u.setQttRoom(5);
        u.setQttBathRoom(1);
        u.setType(Unite.UnitType.Résidentiel);
        u.setRentIndication(Unite.RentIndication.Loué);
        u.setPrix(12.95f);

        units.add(u);

        l = new Locataire();
        l.setNom("Francis Painchaud");
        l.setPhone("450 765 4321");

        u = new Unite();
        u.setOwner(l);
        u.setAdresse("1238 malards");
        u.setAir(1200);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(false);
        u.setQttRoom(10);
        u.setQttBathRoom(3);
        u.setType(Unite.UnitType.Commercial);
        u.setRentIndication(Unite.RentIndication.Réservé);
        u.setPrix(129512.11f);

        units.add(u);

        return units;
    }

    private static ArrayList<Unite> units = createInitUnit();

    public static Unite getUnit(int i) {
        try {
            return units.get(i);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<Unite> getUnits() {
        return units;
    }

    public static void addUnit(Unite unit) {
        units.add(unit);
    }
    public static void setUnit(Unite unit, int index) {
        if(index < units.size()){
            try {
                units.set(index, unit);
            }
            catch (Exception e) {

            }
        }
    }
}
