package com.example.projet_inf1163.src;

public abstract class InfoPaiement {
    private String tokenized_card;

    public abstract boolean validate();

    public String getTokenizedCard() {
        return this.tokenized_card;
    }
}
