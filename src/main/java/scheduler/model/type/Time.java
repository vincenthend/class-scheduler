package scheduler.model.type;

import java.time.DayOfWeek;

public class Time {

    public DayOfWeek day;
    public int start;
    public int end;

    public Time(DayOfWeek day, int start, int end) throws IllegalArgumentException {
        if(!isRangeValid(start, end)) throw new IllegalArgumentException("Invalid Time range");

        this.day = day;
        this.start = start;
        this.end = end;
    }

    private boolean isRangeValid(int start, int end) {
        return start >= 0 && start < 24 && end > 0 && end <= 24 && start < end;
    }
}
