package scheduler;

import java.util.Scanner;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import scheduler.controller.Scheduler;
import scheduler.controller.SchedulerActionListener;
import scheduler.parser.SchedulerLexer;
import scheduler.parser.SchedulerParser;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    Scheduler scheduler = new Scheduler();
    SchedulerActionListener listener = new SchedulerActionListener(scheduler);

    // Read parser
    Scanner s = new Scanner(System.in);
    System.out.print("scheduler=# ");
    String input = s.nextLine();
    while(!input.equals("\\q")) {
      if(!input.equals("\\q")) {
        CharStream cs = CharStreams.fromString(input);

        // Tokenize and build parse tree
        SchedulerLexer lexer = new SchedulerLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SchedulerParser parser = new SchedulerParser(tokens);
        // Serialize object and Schedule
        parser.addParseListener(listener);
        parser.start();
        System.out.print("scheduler=# ");
        input = s.nextLine();
      }
    }
  }
}
