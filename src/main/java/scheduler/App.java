package scheduler;

import scheduler.controller.Scheduler;
import scheduler.model.*;
import scheduler.model.enums.Facility;
import scheduler.model.type.Time;
import scheduler.util.ScheduleTable;

import java.time.DayOfWeek;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        // Read parser

        // Serialize object

        // Scheduling
        try {
            // TODO : Remove these test data
            Classroom room7602 = new Classroom("7602", 50, Facility.WHITEBOARD, Facility.PROJECTOR);
            Classroom room7603 = new Classroom("7603", 40, Facility.WHITEBOARD);
            Lecturer dessi = new Lecturer("Dessi", new Time(DayOfWeek.SUNDAY, 7, 13));
            Lecturer windy = new Lecturer("Windy", new Time(DayOfWeek.SUNDAY, 7, 8));
            Lecture ml = new Lecture("ML", dessi, 50, Facility.PROJECTOR);
            Lecture sil = new Lecture("SIL", windy, 30, Facility.WHITEBOARD);
            Constraint constraint = new Constraint(ml, sil);

            Scheduler scheduler = new Scheduler();
            scheduler.setLectures(ml, sil);
            scheduler.setClassrooms(room7602, room7603);
            scheduler.setConstraints(constraint);

            ScheduleTable table = new ScheduleTable(scheduler.schedule());
            table.print();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        // Print Schedules

    }
}
