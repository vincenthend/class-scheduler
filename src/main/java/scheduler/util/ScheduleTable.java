package scheduler.util;

import scheduler.model.Schedule;

public class ScheduleTable {

    private static final String NUMBER_COLUMN_NAME = "No";
    private static final String DAY_COLUMN_NAME = "Day";
    private static final String TIME_COLUMN_NAME = "Time";
    private static final String CLASSROOM_COLUMN_NAME = "Classroom";
    private static final String LECTURE_COLUMN_NAME = "Lecture";
    private static final String LECTURER_COLUMN_NAME = "Lecturer";

    int numberColumnWidth;
    int dayColumnWidth;
    int timeColumnWidth;
    int classroomColumnWidth;
    int lectureColumnWidth;
    int lecturerColumnWidth;

    private Schedule[] schedules;

    public ScheduleTable(Schedule[] schedules) {
        this.schedules = schedules;
    }

    public void print() {
        if(isSchedulingImpossible()) {
            System.out.println("Scheduling impossible.");
            return;
        }

        this.numberColumnWidth = getNumberColumnWidth();
        this.dayColumnWidth = getDayColumnWidth();
        this.timeColumnWidth = getTimeColumnWidth();
        this.classroomColumnWidth = getClassroomColumnWidth();
        this.lectureColumnWidth = getLectureColumnWidth();
        this.lecturerColumnWidth = getLecturerColumnWidth();

        // Print table header
        System.out.print("+"); for(int idx = 0; idx < this.numberColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.dayColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.timeColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.classroomColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.lectureColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.lecturerColumnWidth + 2; idx++) System.out.print("-");
        System.out.println("+");

        System.out.print("| "); System.out.print(ScheduleTable.NUMBER_COLUMN_NAME); for(int idx = ScheduleTable.NUMBER_COLUMN_NAME.length(); idx < this.numberColumnWidth; idx++) System.out.print(" ");
        System.out.print(" | "); System.out.print(ScheduleTable.DAY_COLUMN_NAME); for(int idx = ScheduleTable.DAY_COLUMN_NAME.length(); idx < this.dayColumnWidth; idx++) System.out.print(" ");
        System.out.print(" | "); System.out.print(ScheduleTable.TIME_COLUMN_NAME); for(int idx = ScheduleTable.TIME_COLUMN_NAME.length(); idx < this.timeColumnWidth; idx++) System.out.print(" ");
        System.out.print(" | "); System.out.print(ScheduleTable.CLASSROOM_COLUMN_NAME); for(int idx = ScheduleTable.CLASSROOM_COLUMN_NAME.length(); idx < this.classroomColumnWidth; idx++) System.out.print(" ");
        System.out.print(" | "); System.out.print(ScheduleTable.LECTURE_COLUMN_NAME); for(int idx = ScheduleTable.LECTURE_COLUMN_NAME.length(); idx < this.lectureColumnWidth; idx++) System.out.print(" ");
        System.out.print(" | "); System.out.print(ScheduleTable.LECTURER_COLUMN_NAME); for(int idx = ScheduleTable.LECTURER_COLUMN_NAME.length(); idx < this.lecturerColumnWidth; idx++) System.out.print(" ");
        System.out.println(" |");

        System.out.print("+"); for(int idx = 0; idx < this.numberColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.dayColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.timeColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.classroomColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.lectureColumnWidth + 2; idx++) System.out.print("-");
        System.out.print("+"); for(int idx = 0; idx < this.lecturerColumnWidth + 2; idx++) System.out.print("-");
        System.out.println("+");
    }

    private boolean isSchedulingImpossible() {
        for(Schedule schedule : this.schedules) {
            if(schedule == null) return true;
        }

        return false;
    }

    private int getNumberColumnWidth() {
        return Math.max(ScheduleTable.NUMBER_COLUMN_NAME.length(), this.schedules.length);
    }

    private int getDayColumnWidth() { return Math.max(ScheduleTable.DAY_COLUMN_NAME.length(), 9); }

    private int getTimeColumnWidth() { return Math.max(ScheduleTable.TIME_COLUMN_NAME.length(), 5); }

    private int getClassroomColumnWidth() {
        int width = ScheduleTable.CLASSROOM_COLUMN_NAME.length();

        for(Schedule schedule : this.schedules) width = Math.max(width, schedule.classroom.name.length());
        return width;
    }

    private int getLectureColumnWidth() {
        int width = ScheduleTable.LECTURE_COLUMN_NAME.length();

        for(Schedule schedule : this.schedules) width = Math.max(width, schedule.lecture.name.length());
        return width;
    }

    private int getLecturerColumnWidth() {
        int width = ScheduleTable.LECTURER_COLUMN_NAME.length();

        for(Schedule schedule : this.schedules) width = Math.max(width, schedule.lecture.lecturer.name.length());
        return width;
    }
}
