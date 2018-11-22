package scheduler.model;

import scheduler.model.enums.Facility;

public class Classroom {

    public String name;
    public int capacity;
    public int facilities;

    public Classroom(String name, int capacity, Facility... facilities) {
        this.name = name;
        this.capacity = capacity;

        for(Facility facility : facilities) {
            this.facilities |= (1 << facility.getBitmask());
        }
    }

    public boolean canAccomodate(int students, Facility... facilities) {
        return hasCapacityFor(students) && hasFacilities(facilities);
    }

    private boolean hasCapacityFor(int students) {
        return this.capacity >= students;
    }

    private boolean hasFacilities(Facility... facilities) {
        for(Facility facility : facilities) {
            if((this.facilities & (1 << facility.getBitmask())) == 0) return false;
        }

        return true;
    }
}
