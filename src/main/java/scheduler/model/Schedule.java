package scheduler.model;

import scheduler.model.type.Time;

public class Schedule {

    public Lecture lecture;
    public Classroom classroom;
    public Time time;

    public Schedule(Lecture lecture, Classroom classroom, Time time) {
        this.lecture = lecture;
        this.classroom = classroom;
        this.time = time;
    }
}
