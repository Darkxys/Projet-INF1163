package com.example.projet_inf1163.src;

import java.time.LocalDateTime;

public class Paiement {
    private int valeur_cents;
    private LocalDateTime dateTime;
    private String num_confirmation;


    public float getValeur_cents() {
        return (float)this.valeur_cents / 100;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String getNum_confirmation() {
        return this.num_confirmation;
    }
}
