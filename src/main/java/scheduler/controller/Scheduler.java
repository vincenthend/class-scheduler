package scheduler.controller;

import java.util.List;
import scheduler.model.Classroom;
import scheduler.model.Constraint;
import scheduler.model.Lecture;
import scheduler.model.Lecturer;
import scheduler.model.Schedule;

public class Scheduler {

    public List<Lecture> lectures;
    public List<Classroom> classrooms;
    public List<Constraint> constraints;
    public List<Lecturer> lecturers;
    private Schedule[] schedules;

    public Scheduler() {}

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public void addLecturer(Lecturer lecturer){
        this.lecturers.add(lecturer);
    }

    public Schedule[] schedule() {
        return null;
    }
}
