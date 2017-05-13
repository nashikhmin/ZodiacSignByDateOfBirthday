package ru.nashikhmin.zodiac.model;

/**
 * It is model of date without year for zodiac signs
 */
public class Date implements Comparable<Date> {
    public Date() {
    }

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    private int day;
    private int month;

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public int compareTo(Date date) {
        if (date == null) {
            return -1;
        }

        if (month != date.month) {
            return new Integer(month).compareTo(date.month);
        }
        return new Integer(day).compareTo(date.day);
    }

    @Override
    public String toString() {
        return String.format("{\"day\":%d,\"month\":%d}", day, month);
    }
}
