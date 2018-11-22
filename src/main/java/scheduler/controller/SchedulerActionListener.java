package scheduler.controller;

import scheduler.model.Classroom;
import scheduler.model.Constraint;
import scheduler.model.Lecture;
import scheduler.model.Lecturer;
import scheduler.model.enums.Facility;
import scheduler.model.type.Time;
import scheduler.parser.SchedulerBaseListener;
import scheduler.parser.SchedulerParser;
import scheduler.parser.SchedulerParser.*;
import scheduler.util.ScheduleTable;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class SchedulerActionListener extends SchedulerBaseListener {
  private Scheduler scheduler;

  public SchedulerActionListener(Scheduler scheduler) {
    this.scheduler = scheduler;
  }

  @Override
  public void exitCreate_classroom(Create_classroomContext ctx) {
    super.exitCreate_classroom(ctx);

    // Get name and remove quotes
    String name = ctx.classroom_name().getText().replaceAll("[\'\"]", "");
    Integer capacity = Integer.parseInt(ctx.num_students().NUM().getText());
    List<Facility> facilities = new ArrayList<>();
    for (Facility_nameContext f : ctx.facility_name()) {
      String s = f.getText().replaceAll("[\'\"]", "");
      facilities.add(Facility.valueOf(s));
    }
    Facility[] facilities_arr = facilities.toArray((new Facility[facilities.size()]));

    Classroom classroom = new Classroom(name, capacity, facilities_arr);
    scheduler.addClassroom(classroom);

    System.out.printf("ADDED CLASSROOM %s WITH CAPACITY %d and FACILITIES %s.\n", name, capacity, facilities);
  }

  @Override
  public void exitCreate_lecture(Create_lectureContext ctx) {
    super.exitCreate_lecture(ctx);
    String name = ctx.class_name().getText().replaceAll("[\'\"]", "");
    String lecturer_name = ctx.lecturer_name().getText().replaceAll("[\'\"]", "");
    Integer capacity = Integer.parseInt(ctx.num_students().NUM().getText());
    List<Facility> facilities = new ArrayList<>();
    for (Facility_nameContext f : ctx.facility_name()) {
      String s = f.getText().replaceAll("[\'\"]", "");
      facilities.add(Facility.valueOf(s));
    }
    Facility[] facilities_arr = facilities.toArray((new Facility[facilities.size()]));

    Lecturer lecturer = null;
    int i = 0;
    boolean found = false;
    while (i < this.scheduler.lecturers.size() && !found) {
      if (lecturer_name.equalsIgnoreCase(this.scheduler.lecturers.get(i).name)) {
        found = true;
        lecturer = this.scheduler.lecturers.get(i);
      }
      i++;
    }
    if (!found) {
      throw new IllegalArgumentException("LECTURER " + lecturer_name + " DOES NOT EXIST! CREATE ONE.\n");
    }
    Lecture lecture = new Lecture(name, lecturer, capacity, facilities_arr);
    scheduler.addLecture(lecture);
    System.out.printf("LECTURE %s ADDED.\n", name);
  }

  @Override
  public void exitCreate_lecturer(Create_lecturerContext ctx) {
    super.exitCreate_lecturer(ctx);
    String name = ctx.lecturer_name().getText().replaceAll("[\'\"]", "");
    List<Time> availabilities = new ArrayList<>();
    for (SchedulerParser.Time_specificationContext t : ctx.time_specification()) {
      availabilities.add(new Time(
        DayOfWeek.valueOf(t.K_DAYS().getText()),
        Integer.parseInt(t.NUM(0).getText()),
        Integer.parseInt(t.NUM(1).getText()))
      );
    }

    Time[] availability_arr = availabilities.toArray((new Time[availabilities.size()]));
    scheduler.addLecturer(new Lecturer(name, availability_arr));
    System.out.printf("LECTURER %s ADDED.\n", ctx.lecturer_name().getText());
  }

  @Override
  public void exitCreate_schedule(Create_scheduleContext ctx) {
    super.exitCreate_schedule(ctx);
    ScheduleTable st = new ScheduleTable(scheduler.schedule());
    st.print();
  }

  @Override
  public void exitMake_constrain(Make_constrainContext ctx) {
    super.exitMake_constrain(ctx);
    List<Lecture> lectures = new ArrayList<>();
    for (SchedulerParser.Class_nameContext l : ctx.class_name()) {
      int i = 0;
      boolean found = false;
      while (i < this.scheduler.lectures.size() && !found) {
        if (l.getText().equalsIgnoreCase(this.scheduler.lectures.get(i).name)) {
          found = true;
          lectures.add(this.scheduler.lectures.get(i));
        }
        i++;
      }
      if (!found) {
        throw new IllegalArgumentException("LECTURE " + l.getText() + " DOES NOT EXIST! CREATE ONE.\n");
      }
    }

    Lecture[] lectures_arr = lectures.toArray((new Lecture[lectures.size()]));
    scheduler.addConstraint(new Constraint(lectures_arr));
    System.out.printf("CONSTRAINTS FOR %s ADDED\n", lectures.toString());
  }
}
