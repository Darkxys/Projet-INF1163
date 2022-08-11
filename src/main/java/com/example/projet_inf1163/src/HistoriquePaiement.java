package com.example.projet_inf1163.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;

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
        Stack<Paiement> sPaiements = new Stack<Paiement>();

        if (endDate.compareTo(bail.getDate_fin()) > 0) {
            endDate = bail.getDate_fin();
        }
        LocalDateTime paiementDate = bail.getDate_debut();
        while (paiementDate.compareTo(endDate) < 0) {
            double d = bail.calculateTotalForPeriod(paiementDate);
            long l = Math.round(d * 100);
            UUID uuid = UUID.randomUUID();
            Paiement p = new Paiement(l, paiementDate, uuid.toString());

            sPaiements.push(p);

            paiementDate = bail.getPeriode().add(paiementDate, 1);
        }

        this.paiements = new ArrayList<>();

        while (!sPaiements.isEmpty()) {
            this.addPaiement(sPaiements.pop());
        }
    }
}
