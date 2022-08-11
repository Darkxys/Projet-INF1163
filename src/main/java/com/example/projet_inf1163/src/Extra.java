package com.example.projet_inf1163.src;

public class Extra {
    private String nom;
    private String description;
    // On stocke le prix en int (cents) car les nombre flotants peuvent être imprécis
    private int prix;

    public Extra(String n, String d, float prix){
        this.description = d;
        this.nom = n;
        this.prix = (int)(prix*100);
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrix() {
        return (float)this.prix / 100;
    }

    @Override
    public String toString() {
        return this.nom + "(+" + this.prix/100 + ")";
    }
}
