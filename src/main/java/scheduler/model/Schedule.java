package scheduler.model;

public class Schedule {
    public Class class_obj;
    public Lecturer lecturer;

    public Schedule(Class class_obj, Lecturer lecturer) {
        this.class_obj = class_obj;
        this.lecturer = lecturer;
    }
}
