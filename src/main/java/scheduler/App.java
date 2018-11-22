package scheduler;

import scheduler.controller.Scheduler;
import scheduler.model.Schedule;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Read parser

        // Serialize object

        // Schedule
        Scheduler scheduler = new Scheduler();
        scheduler.setLectures(null);
        scheduler.setClassrooms(null);
        scheduler.setConstraints(null);

        Schedule[] schedules = scheduler.schedule();

        // Print Schedules

    }
}
