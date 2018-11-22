package scheduler;

import scheduler.controller.Scheduler;
import scheduler.model.Classroom;
import scheduler.model.Lecture;
import scheduler.model.Lecturer;
import scheduler.model.Schedule;
import scheduler.model.enums.Facility;
import scheduler.model.type.Time;
import scheduler.util.ScheduleTable;

import java.time.DayOfWeek;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Read parser

        // Serialize object

        // Scheduling
        try {
            Classroom classroom = new Classroom("7602", 50, Facility.WHITEBOARD, Facility.PROJECTOR);
            Lecturer dessi = new Lecturer("Dessi", new Time(DayOfWeek.SUNDAY, 7, 13));
            Lecture ml = new Lecture("ML", dessi, 50, Facility.PROJECTOR);

            Scheduler scheduler = new Scheduler();
            scheduler.setLectures(ml);
            scheduler.setClassrooms(classroom);
            scheduler.setConstraints();

            ScheduleTable table = new ScheduleTable(scheduler.schedule());
            table.print();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        // Print Schedules

    }
}
