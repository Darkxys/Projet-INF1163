package com.example.projet_inf1163.src;

import java.time.LocalDate;

public class Bail {
    private Locataire locataire;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private LocalDate periode;
    private boolean renouvelable;
    private String assurance;

    public Bail(Locataire loc) {
        this.locataire = loc;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_debut() {
        return this.date_debut;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public LocalDate getDate_fin() {
        return this.date_fin;
    }

    public void setPeriode(LocalDate periode) {
        this.periode = periode;
    }

    public LocalDate getPeriode() {
        return periode;
    }

    public void setRenouvelable(boolean renouvelable) {
        this.renouvelable = renouvelable;
    }

    public boolean isRenouvelable() {
        return renouvelable;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getAssurance() {
        return assurance;
    }

    @Override
    public String toString() {
        return locataire + " " + date_debut.toString();
    }
}
