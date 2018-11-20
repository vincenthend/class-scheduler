package scheduler.model;

import scheduler.model.enums.Facility;

public class Class {
    public String name;
    public int capacity;
    public Facility[] requirements;
    public Lecturer lecturer;

    public Class(String name, int capacity, Lecturer lecturer, Facility[] requirements){
        this.name = name;
        this.capacity = capacity;
        this.lecturer = lecturer;
        this.requirements = requirements;
    }
}
