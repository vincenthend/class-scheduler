package scheduler.model;

import scheduler.model.type.Time;

public class Lecturer {
    public String name;
    public Time[] availability;

    public Lecturer(String name, Time[] availability){
        this.name = name;
        this.availability = availability;
    }
}
