package com.example.projet_inf1163.src;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public boolean isZero() {
        return months == 0 && days == 0 && hours == 0 && minutes == 0 && seconds == 0;
    }

    public long getMonths() {
        return months;
    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public LocalDateTime add(LocalDateTime dateTime, int qttPeriod){
        return dateTime.plusMonths(this.months * qttPeriod)
                .plusDays(this.days * qttPeriod)
                .plusHours(this.hours * qttPeriod)
                .plusMinutes(this.minutes * qttPeriod)
                .plusSeconds(this.seconds * qttPeriod);
    }
}
