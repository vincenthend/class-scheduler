package scheduler.controller;

import java.util.ArrayList;
import java.util.List;
import scheduler.model.Classroom;
import scheduler.model.Lecture;
import scheduler.model.Lecturer;
import scheduler.model.enums.Facility;
import scheduler.parser.SchedulerBaseListener;
import scheduler.parser.SchedulerParser.Create_classroomContext;
import scheduler.parser.SchedulerParser.Facility_nameContext;

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
    String name = ctx.classroom_name().getText();
    Integer capacity = Integer.parseInt(ctx.num_students().NUM().getText());
    List<Facility> facilities = new ArrayList<>();
    for (Facility_nameContext f : ctx.facility_name()){
      String s = f.getText().replaceAll("\'|\"","");
      System.out.println(f.getText());
      facilities.add(Facility.valueOf(s));
    }
    Facility[] facilities_arr = facilities.toArray((new Facility[facilities.size()]));

    Classroom classroom = new Classroom(name, capacity, facilities_arr);
    System.out.printf("ADDED CLASSROOM %s WITH CAPACITY %d and FACILITIES %s\n", name, capacity, facilities);
    classrooms.add(classroom);
  }


}
