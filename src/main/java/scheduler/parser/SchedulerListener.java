// Generated from E:/Literal Zoo/Semester 7/RPLSD/class-scheduler/src/main/java/scheduler\Scheduler.g4 by ANTLR 4.7
package scheduler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SchedulerParser}.
 */
public interface SchedulerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SchedulerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SchedulerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#create_classroom}.
	 * @param ctx the parse tree
	 */
	void enterCreate_classroom(SchedulerParser.Create_classroomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#create_classroom}.
	 * @param ctx the parse tree
	 */
	void exitCreate_classroom(SchedulerParser.Create_classroomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#create_lecture}.
	 * @param ctx the parse tree
	 */
	void enterCreate_lecture(SchedulerParser.Create_lectureContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#create_lecture}.
	 * @param ctx the parse tree
	 */
	void exitCreate_lecture(SchedulerParser.Create_lectureContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#create_lecturer}.
	 * @param ctx the parse tree
	 */
	void enterCreate_lecturer(SchedulerParser.Create_lecturerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#create_lecturer}.
	 * @param ctx the parse tree
	 */
	void exitCreate_lecturer(SchedulerParser.Create_lecturerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#create_schedule}.
	 * @param ctx the parse tree
	 */
	void enterCreate_schedule(SchedulerParser.Create_scheduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#create_schedule}.
	 * @param ctx the parse tree
	 */
	void exitCreate_schedule(SchedulerParser.Create_scheduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#make_constrain}.
	 * @param ctx the parse tree
	 */
	void enterMake_constrain(SchedulerParser.Make_constrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#make_constrain}.
	 * @param ctx the parse tree
	 */
	void exitMake_constrain(SchedulerParser.Make_constrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#time_specification}.
	 * @param ctx the parse tree
	 */
	void enterTime_specification(SchedulerParser.Time_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#time_specification}.
	 * @param ctx the parse tree
	 */
	void exitTime_specification(SchedulerParser.Time_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SchedulerParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SchedulerParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#class_name}.
	 * @param ctx the parse tree
	 */
	void enterClass_name(SchedulerParser.Class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#class_name}.
	 * @param ctx the parse tree
	 */
	void exitClass_name(SchedulerParser.Class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#classroom_name}.
	 * @param ctx the parse tree
	 */
	void enterClassroom_name(SchedulerParser.Classroom_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#classroom_name}.
	 * @param ctx the parse tree
	 */
	void exitClassroom_name(SchedulerParser.Classroom_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#facility_name}.
	 * @param ctx the parse tree
	 */
	void enterFacility_name(SchedulerParser.Facility_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#facility_name}.
	 * @param ctx the parse tree
	 */
	void exitFacility_name(SchedulerParser.Facility_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#lecturer_name}.
	 * @param ctx the parse tree
	 */
	void enterLecturer_name(SchedulerParser.Lecturer_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#lecturer_name}.
	 * @param ctx the parse tree
	 */
	void exitLecturer_name(SchedulerParser.Lecturer_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#num_students}.
	 * @param ctx the parse tree
	 */
	void enterNum_students(SchedulerParser.Num_studentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#num_students}.
	 * @param ctx the parse tree
	 */
	void exitNum_students(SchedulerParser.Num_studentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SchedulerParser#class_target}.
	 * @param ctx the parse tree
	 */
	void enterClass_target(SchedulerParser.Class_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SchedulerParser#class_target}.
	 * @param ctx the parse tree
	 */
	void exitClass_target(SchedulerParser.Class_targetContext ctx);
}