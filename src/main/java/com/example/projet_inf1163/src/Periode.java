package com.example.projet_inf1163.src;

public class Periode {
    private long months;
    private long days;
    private long hours;
    private long minutes;
    private long seconds;

    public Periode(long months) {
        this(months, 0, 0, 0, 0);
    }

    public Periode(long months, long days) {
        this(months, days, 0, 0, 0);
    }

    public Periode(long months, long days, long hours) {
        this(months, days, hours, 0, 0);
    }

    public Periode(long months, long days, long hours, long minutes) {
        this(months, days, hours, minutes, 0);
    }

    public Periode(long months, long days, long hours, long minutes, long seconds) {
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
