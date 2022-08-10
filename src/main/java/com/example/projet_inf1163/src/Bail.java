package com.example.projet_inf1163.src;

import java.time.LocalDate;

public class Bail {
    private LocalDate date_debut;
    private LocalDate date_fin;
    private LocalDate periode;
    private boolean renouvelable;
    private String assurance;

    public LocalDate getDuree() {
        return this.date_fin;
    }

    public LocalDate getPeriode() {
        return periode;
    }

    public boolean isRenouvelable() {
        return renouvelable;
    }

    public String getAssurance() {
        return assurance;
    }
}
