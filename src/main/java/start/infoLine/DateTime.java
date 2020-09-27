package start.infoLine;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTime implements InfoLine {
    private int second = -1;
    private int day = -1;
    private boolean cycle;

    @Override
    public boolean stepSecond() {
        return comparisonSecond(LocalTime.now().getSecond());
    }

    private boolean comparisonSecond(int second) {
        return this.second != second && setSecond(second);
    }

    private boolean setSecond(int second) {
        cycle = this.second != -1;
        this.second = second;
        return true;
    }

    @Override
    public boolean stepDay() {
        return stateDay(LocalDate.now().getDayOfMonth());
    }

    private boolean stateDay(int day) {
        return this.day != day && setDay(day);
    }

    private boolean setDay(int day) {
        this.day = day;
        return true;
    }

    @Override
    public void refresh() {
        cycle = stepSleep(cycle ? 980 : 5);
    }

    private boolean stepSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
        return false;
    }

    @Override
    public String time() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String date() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
