package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HistoriquePaiement {
    private ArrayList<Paiement> paiements;

    public HistoriquePaiement() {
        this.paiements = new ArrayList<>();
    }

    public ArrayList<Paiement> getPaiements() {
        return paiements;
    }

    public void addPaiement(Paiement p) {
        this.paiements.add(p);
    }

    public void generatePaiements(Bail bail, LocalDateTime endDate) {
        LocalDateTime paiementDate = bail.getDate_debut();
        while (paiementDate.compareTo(endDate) < 0) {
            bail.calculateTotalForPeriod(paiementDate);
        }
    }
}
