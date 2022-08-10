package com.example.projet_inf1163.src;

public class Extra {
    private String nom;
    private String description;
    // On stocke le prix en int (cents) car les nombre flotants peuvent être imprécis
    private int prix;

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrix() {
        return this.prix;
    }
}
