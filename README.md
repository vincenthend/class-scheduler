# Class Scheduler
Interactive console application for class scheduling using custom DSL called CSQL (Class Scheduling Query Language).

## Requirements
- Java 8
- ANTLR 4 from Maven repository

## CSQL Tutorial
CSQL can be used to define classrooms, lecturers, lectures, constraints, and class scheduling.

- Create Classroom
```
  CREATE CLASSROOM 7602 FOR 100 STUDENTS WITH FACILITIES "PROJECTOR", "AUDIO";
```

- Create Lecturer
```
  CREATE LECTURER "Roland" AVAILABLE AT MONDAY FROM 7 UNTIL 8, WEDNESDAY FROM 12 UNTIL 14;
```

- Create Lecture
```
  CREATE LECTURE "NLP" TAUGHT BY "Roland" FOR 80 STUDENTS REQUIRING "PROJECTOR";
```

- Create Constraint
```
  CONSTRAINT NOT OVERLAPPING "ML", "NLP";
```

- Scheduling
```
  CREATE SCHEDULE;
```

## Interactive Console and Examples
We provide interactive console to deliver the best experience of CSQL.

- Successful scheduling
  

![Success](assets/scheduling-success.png)

- Failed scheduling (impossible)
  

![Failed](assets/scheduling-failed.png)

- Quit console
  

![Quit](assets/scheduling-quit.png)

## Use Case

![Diagram Diagram-Use Case Diagram](assets/Diagram Diagram-Use Case Diagram.png)

## Developers

- [Reinhard Linardi](https://github.com/reinhardlinardi) (13515011)
- [Vincent Hendryanto H.](https://github.com/vincenthend) (13515089)
- [Mikhael Artur D.](https://github.com/mikhael-artur) (13515099)
