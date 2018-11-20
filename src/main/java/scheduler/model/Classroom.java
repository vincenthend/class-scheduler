package scheduler.model;

import scheduler.model.enums.Facility;

public class Classroom {
    public String name;
    public int capacity;
    public Facility[] facilities;

    public Classroom(String name, int capacity, Facility[] facilities) {
        this.name = name;
        this.capacity = capacity;
        this.facilities = facilities;
    }
}
