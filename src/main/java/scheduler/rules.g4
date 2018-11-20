grammar rules;
start : ((create_classroom | create_class | create_lecturer | make_schedule | make_constrain)';')+;
// CREATE CLASSROOM 7602 FOR 100 STUDENTS WITH FACILITIES 'PROJECTOR', 'AC';
create_classroom: K_CREATE K_CLASSROOM classroom_name K_FOR num_students K_STUDENTS (K_WITH K_FACILITIES facility_name (COMMA facility_name)*)?;
// CREATE CLASS 'ML' TAUGHT BY "Bu Dessi" FOR 100 STUDENTS REQUIRING 'AC';
create_class: K_CREATE K_CLASS class_name K_TAUGHT K_BY lecturer_name K_FOR num_students K_STUDENTS (K_REQUIRING facility_name (COMMA facility_name)*)?;
// CREATE LECTURER 'Bu Dessi' AVAILABLE AT SUNDAY FROM 7 UNTIL 10, WEDNESDAY FROM 7 UNTIL 10
create_lecturer: K_CREATE K_LECTURER lecturer_name K_AVAILABLE K_AT time_specification (COMMA time_specification)*;
// MAKE SCHEDULE FOR NLP, ML;
make_schedule: K_MAKE K_SCHEDULE K_FOR class_target;
// CONSTRAIN ML NOT OVERLAPPING WITH NLP
make_constrain: K_CONSTRAINT K_NOT K_OVERLAPPING class_name (COMMA class_name)+;
time_specification : K_DAYS K_FROM NUM K_UNTIL NUM;


class_name : STR_LITERAL;
classroom_name : STR_LITERAL | NUM;
facility_name: STR_LITERAL;
lecturer_name : STR_LITERAL;
num_students : NUM;
class_target : class_name (COMMA class_name)* | K_ALL;


WS: [ \t\r\n]+ -> channel(HIDDEN);

K_ALL : A L L;
K_AT : A T;
K_AVAILABLE : A V A I L A B L E;
K_BY : B Y;
K_CLASS : C L A S S;
K_CLASSROOM : C L A S S R O O M;
K_CONSTRAIN : C O N S T R A I N T;
K_CREATE : C R E A T E;
K_DAYS : C_MONDAY | C_TUESDAY | C_WEDNESDAY | C_THURSDAY | C_FRIDAY | C_SATURDAY | C_SUNDAY;
K_FACILITIES : F A C I L I T I E S;
K_FOR : F O R;
K_FROM : F R O M;
K_LECTURER : L E C T U R E R;
K_MAKE : M A K E;
K_NOT : N O T;
K_OVERLAPPING : O V E R L A P P I N G;
K_REQUIRING : R E Q U I R I N G;
K_SCHEDULE : S C H E D U L E;
K_STUDENTS : S T U D E N T S;
K_TAUGHT : T A U G H T;
K_UNTIL : U N T I L;
K_WITH : W I T H;


C_MONDAY : M O N D A Y;
C_TUESDAY : T U E S D A Y;
C_WEDNESDAY : W E D N E S D A Y;
C_THURSDAY : T H U R S D A Y;
C_FRIDAY : F R I D A Y;
C_SATURDAY : S A T U R D A Y;
C_SUNDAY : S U N D A Y;

NUM : DIGIT+;
STR_LITERAL : ('\'') [a-zA-Z][a-zA-Z_0-9 ]* ('\'') | ('"') [a-zA-Z][a-zA-Z_0-9 ]* ('"');
COMMA : ',';

fragment DIGIT : [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];