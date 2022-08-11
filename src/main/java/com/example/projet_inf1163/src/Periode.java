package com.example.projet_inf1163.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

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

    public double getPriceMultipleForNextPayment(LocalDateTime dateTime) {
        LocalDateTime nextDateTime = this.add(dateTime, 1);
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
}
