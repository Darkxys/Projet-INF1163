package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Bail {
    // Properties declaration
    private Locataire locataire;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private Periode periode;
    private boolean renouvelable;
    private String assurance;
    private Extra extra;
    private Unite unite;
    private HistoriquePaiement paiements;

    /**
     * Bail constructor with a Locataire
     * @param loc
     */
    public Bail(Locataire loc) {
        this.locataire = loc;
    }

    //region Getters and setters

    public List<Paiement> getPaiements() {
        HistoriquePaiement h = new HistoriquePaiement();
        h.generatePaiements(this, LocalDateTime.now());
        return h.getPaiements();
    }

    public double getExtraPrice() {
        if (this.extra == null)
            return 0;
        return this.extra.getPrix();
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
    //endregion

    //region Calculators
    public double calculateUnitPriceForPeriod(LocalDateTime date) {
        return getUnitPrice() * this.getPriceMultipleForNextPayment(date);
    }

    public double calculateExtraPriceForPeriod(LocalDateTime date) {
        return getExtraPrice() * this.getPriceMultipleForNextPayment(date);
    }

    public double calculateSubtotal() {
        return this.getUnitPrice() + getExtraPrice();
    }

    public double calculateSubtotalForPeriod(LocalDateTime date) {
        return calculateSubtotal() * this.getPriceMultipleForNextPayment(date);
    }

    public double calculateTPS() {
        return this.calculateSubtotal() * 0.05;
    }

    public double calculateTPSForPeriod(LocalDateTime date) {
        return calculateTPS() * this.getPriceMultipleForNextPayment(date);
    }

    public double calculateTVQ() {
        return this.calculateSubtotal() * 0.09975;
    }

    public double calculateTVQForPeriod(LocalDateTime date) {
        return calculateTVQ() * this.getPriceMultipleForNextPayment(date);
    }

    public double calculateTotal() {
        return this.calculateSubtotal() + this.calculateTPS() + this.calculateTVQ();
    }

    public double calculateTotalForPeriod(LocalDateTime date) {
        return calculateTotal() * this.getPriceMultipleForNextPayment(date);
    }
    //endregion

    /**
     * Method to calculate the price for the next payment
     * @param dateTime
     * @return Price for the next payment
     */
    public double getPriceMultipleForNextPayment(LocalDateTime dateTime) {
        LocalDateTime nextDateTime = this.periode.add(dateTime, 1);

        if (nextDateTime.compareTo(this.date_fin) > 0) {
            nextDateTime = this.date_fin;
        }

        double d = 0;
        long months = ChronoUnit.MONTHS.between(dateTime, nextDateTime);
        d += months;
        dateTime = dateTime.plusMonths(months);
        YearMonth yearMonthObject = YearMonth.of(dateTime.getYear(), dateTime.getMonth());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        long t = daysInMonth * 24 * 60 * 60;
        Long secondsInMonth = t;

        Long seconds = ChronoUnit.SECONDS.between(dateTime, nextDateTime);
        double fraction = seconds.doubleValue() / secondsInMonth.doubleValue();
        d += fraction;
        return d;
    }

    @Override
    public String toString() {
        return locataire + " " +
                date_debut.getYear() + "-" +
                (date_debut.getMonthValue() < 10 ? "0" : "") + date_debut.getMonthValue() + "-" +
                (date_debut.getDayOfMonth() < 10 ? "0" : "") + date_debut.getDayOfMonth() + " " +
                (date_debut.getHour() < 10 ? "0" : "") + date_debut.getHour() + ":" +
                (date_debut.getMinute() < 10 ? "0" : "") + date_debut.getMinute() + ":" +
                (date_debut.getSecond() < 10 ? "0" : "") + date_debut.getSecond();
    }
}
