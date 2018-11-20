# class-scheduler
DSL Language To Schedule Class based on a specific constraint. Parsing are done using ANTLR, base code in java

## Requirements
ANTLR4

Sample DSL :
```
  CREATE CLASSROOM 7602 FOR 100 STUDENTS WITH FACILITIES 'PROJECTOR', 'AC';
  CREATE CLASS 'ML' TAUGHT BY "Mr X" FOR 50 STUDENTS REQUIRING 'AC';
  CREATE LECTURER 'Mr X' AVAILABLE AT SUNDAY FROM 7 UNTIL 13;
  MAKE SCHEDULE FOR "NLP", "ML";
  MAKE SCHEDULE FOR ALL;
  CONSTRAINT NOT OVERLAPPING "NLP", "ML";
```
