package scheduler.model.type;

import java.time.DayOfWeek;

public class Time {
    public DayOfWeek day;
    public int startTime;
    public int endTime;

    public Time(DayOfWeek day, int startTime, int endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
