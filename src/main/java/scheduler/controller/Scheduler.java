package scheduler.controller;

import scheduler.model.Classroom;
import scheduler.model.Constraint;
import scheduler.model.Schedule;
import scheduler.model.Lecture;
import scheduler.model.type.Time;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Comparator;

public class Scheduler {

    public Lecture[] lectures;
    public Classroom[] classrooms;
    public Constraint[] constraints;
    private Schedule[] schedules;

    public Scheduler() {}
    public void setLectures(Lecture... lectures) {
        this.lectures = lectures;
    }
    public void setClassrooms(Classroom... classrooms) {
        this.classrooms = classrooms;
    }
    public void setConstraints(Constraint... constraints) {
        this.constraints = constraints;
    }

    /* Scheduling */

    public Schedule[] schedule() {
        this.schedules = new Schedule[this.lectures.length];
        Arrays.fill(this.schedules, null);

        assignSchedule(0);

        Arrays.sort(this.schedules, (schedule1, schedule2) -> {
            // Different day
            if(schedule1.time.day.getValue() < schedule2.time.day.getValue()) return -1;
            if(schedule1.time.day.getValue() > schedule2.time.day.getValue()) return 1;

            // Same day, different start time
            if(schedule1.time.start < schedule2.time.start) return -1;
            else return 1;
        });

        return this.schedules;
    }

    private boolean assignSchedule(int lectureIdx) {
        // Assignment done
        if(lectureIdx == this.lectures.length) return true;

        // Assign with all possible classrooms and available time
        boolean assigned;

        Lecture lecture = this.lectures[lectureIdx];
        Time[] availability = lecture.lecturer.availability;

        for(Classroom classroom : this.classrooms) {
            if(!classroom.canAccommodate(lecture.students, lecture.requirements)) continue;

            for(Time time : availability) {
                for(int start = time.start; start < time.end; start++) {
                    if(!(isClassroomAvailableWithinSchedule(lectureIdx, classroom, time.day, start) && withinConstraints(lecture, time.day, start))) continue;

                    this.schedules[lectureIdx] = new Schedule(lecture, classroom, new Time(time.day, start, start + 1));
                    assigned = assignSchedule(lectureIdx + 1);

                    if(assigned) return true;
                    else this.schedules[lectureIdx] = null;
                }
            }
        }

        return false;
    }

    private boolean isClassroomAvailableWithinSchedule(int lectureIdx, Classroom classroom, DayOfWeek day, int start) {
        for(int idx = 0; idx < this.schedules.length; idx++) {
            if(idx == lectureIdx) continue;

            Schedule schedule = this.schedules[idx];
            if(schedule == null) continue;

            if(classroom == schedule.classroom && day == schedule.time.day && start == schedule.time.start) return false;
        }

        return true;
    }

    private boolean withinConstraints(Lecture lecture, DayOfWeek day, int start) {
        for(Constraint constraint : this.constraints) {
            if(!constraint.has(lecture)) continue;

            for(Lecture otherLecture : constraint.lectures) {
                if(otherLecture == lecture) continue;

                int otherLectureIdx = findLectureIdx(otherLecture);
                if(this.schedules[otherLectureIdx] == null) continue;

                if(day == this.schedules[otherLectureIdx].time.day && start == this.schedules[otherLectureIdx].time.start) return false;
            }
        }

        return true;
    }

    private int findLectureIdx(Lecture lecture) {
        for(int idx = 0; idx < this.lectures.length; idx++) {
            if(this.lectures[idx] == lecture) return idx;
        }

        return -1;
    }
}
