package com.example.projet_inf1163.src;

import java.time.LocalDate;

public class Paiement {
    private int valeur_cents;
    private LocalDate date;
    private String num_confirmation;


    public int getValeur_cents() {
        return this.valeur_cents;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getNum_confirmation() {
        return this.num_confirmation;
    }
}
