package scheduler.model;

import scheduler.model.enums.Facility;
import scheduler.model.type.Facilities;

public class Classroom {

    public String name;
    public int capacity;
    public Facilities facilities;

    public Classroom(String name, int capacity, Facility... facilities) {
        this.name = name;
        this.capacity = capacity;
        this.facilities = new Facilities(facilities);
    }

    public boolean canAccomodate(int students, Facility... facilities) {
        return hasCapacityFor(students) && hasFacilities(facilities);
    }

    private boolean hasCapacityFor(int students) {
        return this.capacity >= students;
    }

    private boolean hasFacilities(Facility... facilities) {
        return this.facilities.hasAllOf(facilities);
    }
}
