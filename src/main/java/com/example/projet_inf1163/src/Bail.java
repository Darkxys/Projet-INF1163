package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bail {
    private Locataire locataire;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private Periode periode;
    private boolean renouvelable;
    private String assurance;
    private ArrayList<Extra> extras;
    private Unite unite;

    public Bail(Locataire loc) {
        this.locataire = loc;
        this.extras = new ArrayList<Extra>();
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setLocataire(Locataire loc) {
        this.locataire = loc;
    }

    public Locataire getLocataire() {
        return this.locataire;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_debut() {
        return this.date_debut;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public LocalDateTime getDate_fin() {
        return this.date_fin;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Periode getPeriode() {
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

    public void addExtra(Extra extra) {
        this.extras.add(extra);
    }

    public void removeExtra(Extra extra) {
        try {
            this.extras.remove(extra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Extra getExtra(int i) {
        try {
            return this.extras.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Extra> getExtras() {
        return this.extras;
    }

    @Override
    public String toString() {
        return locataire + " " + date_debut.toString();
    }
}
