package scheduler.model;

import scheduler.model.enums.Facility;

public class Lecture {

    public String name;
    public Lecturer lecturer;
    public int students;
    public int requirements;

    public Lecture(String name, Lecturer lecturer, int students, Facility... requirements){
        this.name = name;
        this.students = students;
        this.lecturer = lecturer;

        for(Facility requirement : requirements) {
            this.requirements |= (1 << requirement.getBitmask());
        }
    }
}
