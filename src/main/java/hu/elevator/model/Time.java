package hu.elevator.model;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Time {

    private final int hour;
    private final int minute;
    private final int second;

    public Time(final int hour, final int minute, final int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
