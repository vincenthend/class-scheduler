package scheduler.model;

public class Constraint {

    public Lecture[] lectures;

    public Constraint(Lecture... lectures) {
        this.lectures = lectures;
    }

    public boolean has(Lecture lecture) {
        for(Lecture constrainedLecture : lectures) {
            if(lecture == constrainedLecture) return true;
        }

        return false;
    }
}
