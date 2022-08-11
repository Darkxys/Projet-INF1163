package com.example.projet_inf1163.src;

import java.time.LocalDate;

public class Unite {
    public enum UnitType {
        Commercial,
        Résidentiel,
        Autre
    }
    public enum RentIndication {
        Loué,
        Réservé,
        Libre
    }

    private String identifiant;
    private String adresse;
    // On stocke le prix en int (cents) car les nombre flotants peuvent être imprécis
    private int prix_base_cents;
    private Locataire owner;
    private UnitType type;
    private int air;
    private boolean isRentable;
    private int qttRoom;
    private int qttBathRoom;
    private LocalDate builtDate;
    private RentIndication rentIndication;

    public float getPrix() {
        return (float) this.prix_base_cents / 100;
    }
    public void setPrix(float prix) { this.prix_base_cents = (int)(prix * 100); }

    public void updateIdentifiant() {
        this.identifiant = this.owner + " | " + this.adresse;
    }

    public String getIdentifiant() {
        if(this.identifiant == null){
            this.updateIdentifiant();
        }
        return this.identifiant;
    }
    public void setIdentifiant(String id) { this.identifiant = id; }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Locataire getOwner() {
        return owner;
    }

    public void setOwner(Locataire owner) {
        this.owner = owner;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public boolean isRentable() {
        return isRentable;
    }

    public void setRentable(boolean rentable) {
        isRentable = rentable;
    }

    public int getQttRoom() {
        return qttRoom;
    }

    public void setQttRoom(int qttRoom) {
        this.qttRoom = qttRoom;
    }

    public int getQttBathRoom() {
        return qttBathRoom;
    }

    public void setQttBathRoom(int qttBathRoom) {
        this.qttBathRoom = qttBathRoom;
    }

    public LocalDate getBuiltDate() {
        return builtDate;
    }

    public void setBuiltDate(LocalDate builtDate) {
        this.builtDate = builtDate;
    }

    public RentIndication getRentIndication() {
        return rentIndication;
    }

    public void setRentIndication(RentIndication rentIndication) {
        this.rentIndication = rentIndication;
    }

    @Override
    public String toString() {
        return this.getIdentifiant();
    }

    public boolean matches(String s) {
        return identifiant.contains(s) || adresse.contains(s) || (owner.getNom() != null && owner.getNom().contains(s));
    }
}
