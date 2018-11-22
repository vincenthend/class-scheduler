# class-scheduler
DSL Language To Schedule Class based on a specific constraint. Parsing are done using ANTLR, base code in java

## Requirements
ANTLR4

Sample DSL :
```
  CREATE CLASSROOM 7602 FOR 100 STUDENTS WITH FACILITIES 'PROJECTOR', 'AC';
  CREATE LECTURER 'Bu Dessi' AVAILABLE AT SUNDAY FROM 7 UNTIL 10, WEDNESDAY FROM 7 UNTIL 10;
  CREATE LECTURE 'ML' TAUGHT BY "Bu Dessi" FOR 100 STUDENTS REQUIRING 'AC';
  MAKE SCHEDULE;
  CONSTRAIN NOT OVERLAPPING "ML", "NLP";
```
