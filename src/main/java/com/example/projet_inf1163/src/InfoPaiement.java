package com.example.projet_inf1163.src;

public abstract class InfoPaiement {
    // Property declaration
    private String tokenized_card;

    /**
     * Methode to validate a payment
     * @return
     */
    public abstract boolean validate();

    // Getter
    public String getTokenizedCard() {
        return this.tokenized_card;
    }
}
