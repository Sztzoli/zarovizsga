package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class WorkHoursPerDay {
    private String name;
    private int hours;
    private LocalDate time;

    public WorkHoursPerDay(String name, int hours, LocalDate time) {
        this.name = name;
        this.hours = hours;
        this.time = time;
    }

    public WorkHoursPerDay(String name, String hoursString, String timeString) {
        this.name = name;
        this.hours = Integer.parseInt(hoursString);
        this.time = LocalDate.parse(timeString);
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public LocalDate getTime() {
        return time;
    }

    public String toStringMinHours() {
        return name + ": " + time.toString();
    }
}
