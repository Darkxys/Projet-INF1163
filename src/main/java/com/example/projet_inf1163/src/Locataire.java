package com.example.projet_inf1163.src;

public class Locataire {
    private String nom;
    private int cote_credit;
    private String adresse;
    private String phone;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setCote_credit(int cote_credit) {
        this.cote_credit = cote_credit;
    }

    public int getCote_credit() {
        return this.cote_credit;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return nom;
    }
}
