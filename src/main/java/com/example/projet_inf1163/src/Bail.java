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
    private Extra extra;
    private Unite unite;

    public Bail(Locataire loc) {
        this.locataire = loc;
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

    public Extra getExtra() { return this.extra; }

    public void setExtra(Extra extra) { this.extra = extra; }

    public double getUnitPrice() {
        return this.unite.getPrix();
    }

    public double calculateUnitPriceForPeriod(LocalDateTime date, Periode p) {
        return getUnitPrice() * p.getPriceMultipleForNextPayment(date);
    }

    public double getExtraPrice() {
        if (this.extra == null)
            return 0;
        return this.extra.getPrix();
    }

    public double calculateExtraPriceForPeriod(LocalDateTime date, Periode p) {
        return getExtraPrice() * p.getPriceMultipleForNextPayment(date);
    }

    public double calculateSubtotal() {
        return this.getUnitPrice() + getExtraPrice();
    }

    public double calculateSubtotalForPeriod(LocalDateTime date, Periode p) {
        return calculateSubtotal() * p.getPriceMultipleForNextPayment(date);
    }

    public double calculateTPS() {
        return this.calculateSubtotal() * 0.05;
    }

    public double calculateTPSForPeriod(LocalDateTime date, Periode p) {
        return calculateTPS() * p.getPriceMultipleForNextPayment(date);
    }

    public double calculateTVQ() {
        return this.calculateSubtotal() * 0.09975;
    }

    public double calculateTVQForPeriod(LocalDateTime date, Periode p) {
        return calculateTVQ() * p.getPriceMultipleForNextPayment(date);
    }

    public double calculateTotal() {
        return this.calculateSubtotal() + this.calculateTPS() + this.calculateTVQ();
    }

    public double calculateTotalForPeriod(LocalDateTime date, Periode p) {
        return calculateTotal() * p.getPriceMultipleForNextPayment(date);
    }

    @Override
    public String toString() {
        return locataire + " " + date_debut.toString();
    }
}
