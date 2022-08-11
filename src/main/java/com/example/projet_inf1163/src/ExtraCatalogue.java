package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ExtraCatalogue {
    private static ArrayList<Extra> createInitExtra() {
        ArrayList<Extra> extras = new ArrayList<>();

        extras.add(new Extra("Piscine", "Une piscine", 140));
        extras.add(new Extra("Balcon", "Un balcon", 100));
        extras.add(new Extra("Gazon", "Un service de razage de gazon", 1000));
        extras.add(new Extra("Réparation", "Service de garantie sur la maison", 2000));

        return extras;
    }

    private static ArrayList<Extra> extras = createInitExtra();

    public static Extra getExtra(int i) {
        try {
            return extras.get(i);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<Extra> getExtras() {
        return extras;
    }
}
