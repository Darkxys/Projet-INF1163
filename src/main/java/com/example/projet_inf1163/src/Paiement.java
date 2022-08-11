package com.example.projet_inf1163.src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Paiement {
    // Properties declaration
    private Long valeur_cents;
    private LocalDateTime dateTime;
    private String num_confirmation;

    // Constructor with value, paymentDate, confirmationNum
    public Paiement(long value, LocalDateTime dateTime, String numConf) {
        this.valeur_cents = value;
        this.dateTime = dateTime;
        this.num_confirmation = numConf;
    }

    //region Getters
    public Long getValeur_cents() {
        return this.valeur_cents;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String getNum_confirmation() {
        return this.num_confirmation;
    }
    //endregion

    @Override
    public String toString() {
        BigDecimal bigDecimal = new BigDecimal(this.getValeur_cents().doubleValue());
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return this.dateTime.getYear() + "-" +
                this.dateTime.getMonthValue() + "-" +
                this.dateTime.getDayOfMonth() + " " +
                this.dateTime.getHour() + ":" +
                this.dateTime.getMinute() + ":" +
                this.dateTime.getSecond() + " " +
                bigDecimal + "$ " +
                this.num_confirmation;
    }
}
