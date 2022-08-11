package com.example.projet_inf1163.src;

public class Extra {
    // Properties declaration
    private String nom;
    private String description;
    // On stocke le prix en int (cents) car les nombre flotants peuvent être imprécis
    private int prix;

    // Constructor with name, description and price
    public Extra(String n, String d, float prix){
        this.description = d;
        this.nom = n;
        this.prix = (int)(prix*100);
    }

    //region Getters
    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrix() {
        return (float)this.prix / 100;
    }
    //endregion

    @Override
    public String toString() {
        return this.nom + "(+" + this.prix/100 + ")";
    }
}
