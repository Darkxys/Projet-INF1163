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
        l.setNom("John Smith");
        l.setPhone("450 123 4567");
        Unite u = new Unite();
        u.setOwner(l);
        u.setAdresse("12 12 adresse");
        u.setAir(800);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(true);
        u.setQttRoom(5);
        u.setQttBathRoom(1);
        u.setType(Unite.UnitType.Résidentiel);
        u.setRentIndication(Unite.RentIndication.Loué);
        u.setPrix(1200.00f);

        units.add(u);

        l = new Locataire();
        l.setNom("Jenny Manny");
        l.setPhone("450 765 4321");

        u = new Unite();
        u.setOwner(l);
        u.setAdresse("1238 des pinsons");
        u.setAir(1200);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(false);
        u.setQttRoom(10);
        u.setQttBathRoom(3);
        u.setType(Unite.UnitType.Commercial);
        u.setRentIndication(Unite.RentIndication.Réservé);
        u.setPrix(3199.99f);

        units.add(u);

        l = new Locataire();
        l.setNom("Henriette Opaline");
        l.setPhone("111 111 1111");

        u = new Unite();
        u.setOwner(l);
        u.setAdresse("548 des érables");
        u.setAir(1200);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(false);
        u.setQttRoom(3);
        u.setQttBathRoom(3);
        u.setType(Unite.UnitType.Résidentiel);
        u.setRentIndication(Unite.RentIndication.Loué);
        u.setPrix(750.00f);

        units.add(u);

        l = new Locataire();
        l.setNom("Reanna Randy");
        l.setPhone("222 222 2222");

        u = new Unite();
        u.setOwner(l);
        u.setAdresse("33 12ieme avenue");
        u.setAir(1200);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(false);
        u.setQttRoom(4);
        u.setQttBathRoom(1);
        u.setType(Unite.UnitType.Résidentiel);
        u.setRentIndication(Unite.RentIndication.Libre);
        u.setPrix(900.00f);

        units.add(u);

        l = new Locataire();
        l.setNom("Luc Beulah");
        l.setPhone("333 333 3333");

        u = new Unite();
        u.setOwner(l);
        u.setAdresse("9987 rue jean-talon");
        u.setAir(1200);
        u.setBuiltDate(LocalDate.now());
        u.setRentable(false);
        u.setQttRoom(16);
        u.setQttBathRoom(3);
        u.setType(Unite.UnitType.Commercial);
        u.setRentIndication(Unite.RentIndication.Libre);
        u.setPrix(5199.99f);

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
