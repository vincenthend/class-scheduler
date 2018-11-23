package scheduler.model;

import scheduler.model.enums.Facility;
import scheduler.model.type.Facilities;

public class Lecture {

    public String name;
    public Lecturer lecturer;
    public int students;
    public Facilities requirements;

    public Lecture(String name, Lecturer lecturer, int students, Facility... requirements){
        this.name = name;
        this.students = students;
        this.lecturer = lecturer;
        this.requirements = new Facilities(requirements);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
