package scheduler.controller;

import scheduler.model.Classroom;
import scheduler.model.Constraint;
import scheduler.model.Schedule;
import scheduler.model.Lecture;

public class Scheduler {

    public Lecture[] lectures;
    public Classroom[] classrooms;
    public Constraint[] constraints;
    private Schedule[] schedules;

    public Scheduler() {}

    public void setLectures(Lecture[] lectures) {
        this.lectures = lectures;
    }

    public void setClassrooms(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }

    public Schedule[] schedule() {
        return null;
    }
}
