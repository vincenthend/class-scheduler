package scheduler.controller;

import java.util.ArrayList;
import java.util.List;
import scheduler.model.Classroom;
import scheduler.model.Lecture;
import scheduler.model.Lecturer;
import scheduler.model.enums.Facility;
import scheduler.parser.SchedulerBaseListener;
import scheduler.parser.SchedulerParser.Create_classroomContext;
import scheduler.parser.SchedulerParser.Create_lectureContext;
import scheduler.parser.SchedulerParser.Create_lecturerContext;
import scheduler.parser.SchedulerParser.Create_scheduleContext;
import scheduler.parser.SchedulerParser.Facility_nameContext;
import scheduler.parser.SchedulerParser.Make_constrainContext;

public class SchedulerActionListener extends SchedulerBaseListener {
  public List<Classroom> classrooms;
  public List<Lecture> lectures;
  public List<Lecturer> lecturers;

  public SchedulerActionListener(){
    classrooms = new ArrayList<>();
    lectures = new ArrayList<>();
    lecturers = new ArrayList<>();
  }

  @Override
  public void exitCreate_classroom(Create_classroomContext ctx) {
    super.exitCreate_classroom(ctx);

    // Get name and remove quotes
    String name = ctx.classroom_name().getText().replaceAll("[\'\"]","");
    Integer capacity = Integer.parseInt(ctx.num_students().NUM().getText());
    List<Facility> facilities = new ArrayList<>();
    for (Facility_nameContext f : ctx.facility_name()){
      String s = f.getText().replaceAll("[\'\"]","");
      facilities.add(Facility.valueOf(s));
    }
    Facility[] facilities_arr = facilities.toArray((new Facility[facilities.size()]));

    Classroom classroom = new Classroom(name, capacity, facilities_arr);
    classrooms.add(classroom);

    System.out.printf("ADDED CLASSROOM %s WITH CAPACITY %d and FACILITIES %s\n", name, capacity, facilities);
  }

  @Override
  public void exitCreate_lecture(Create_lectureContext ctx) {
    super.exitCreate_lecture(ctx);
  }

  @Override
  public void exitCreate_lecturer(Create_lecturerContext ctx) {
    super.exitCreate_lecturer(ctx);
  }

  @Override
  public void exitCreate_schedule(Create_scheduleContext ctx) {
    super.exitCreate_schedule(ctx);
  }

  @Override
  public void exitMake_constrain(Make_constrainContext ctx) {
    super.exitMake_constrain(ctx);
  }
}
