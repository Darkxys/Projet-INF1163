package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Static class to have access to all Extras everywhere
 */
public class ExtraCatalogue {
    private static ArrayList<Extra> createInitExtra() {
        ArrayList<Extra> extras = new ArrayList<>();

        extras.add(new Extra("Électricité", "Électricité inclus", 50));
        extras.add(new Extra("Electricité + Internet", "Électricité et internet inclus", 100));
        extras.add(new Extra("Internet", "Internet inclus", 60));
        extras.add(new Extra("Tout inclus", "Tout inclus", 150));

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
