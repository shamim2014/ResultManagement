CREATE DATABASE resultmanagment;

CREATE TABLE Teacher
(
 id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 dept_name VARCHAR(50) NOT NULL,
 name VARCHAR(50) NOT NULL,
 email  VARCHAR(50) UNIQUE NOT NULL,
 phone VARCHAR(50)
);

CREATE TABLE Course
(
 course_code VARCHAR(20) NOT NULL PRIMARY KEY,
 title VARCHAR(50) NOT NULL,
 year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th')),
 credit DECIMAL(2,1),
 semester VARCHAR(5) CHECK (semester IN ('1st','2nd'))
);

CREATE TABLE User 
(
ID INT(10) NOT NULL, 
PassWord VARCHAR(30) NOT NULL, 
Type VARCHAR(30) NOT NULL, 
PRIMARY KEY (ID))
 ENGINE = InnoDB

CREATE TABLE ExamCommittee
(
 chairmanId INT(6),
 firstMemberId INT(6),
 secondMemberId INT(6),
 year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th','Ms')),
 session VARCHAR(30),
 PRIMARY KEY (year,session)
)

CREATE TABLE Student
(
 name VARCHAR(50) NOT NULL,
 dept_roll VARCHAR(10) NOT NULL,
 gender VARCHAR(5)  CHECK (gender IN ('Male','Female')),
 session VARCHAR(30),
 batch VARCHAR(6),
 exam_roll VARCHAR(10),
 email  VARCHAR(50) UNIQUE NOT NULL,
 phone VARCHAR(50),
 year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th','ms')),
semester VARCHAR(5) CHECK (semester IN ('1st','2nd')),
 regi_session VARCHAR(20),
 registration VARCHAR(20),
 hall VARCHAR(30),
PRIMARY KEY (dept_roll,year,session)
);

CREATE TABLE TheorySubject
(
 firstExaminerId INT(6) UNSIGNED NOT NULL,
 secondExaminerId INT(6) UNSIGNED,
 course_code VARCHAR(20) NOT NULL,
 session VARCHAR(30) NOT NULL,
 PRIMARY KEY (course_code,session)
);

CREATE TABLE Lab
(
 firstExaminerId INT(6) UNSIGNED NOT NULL,
 secondExaminerId INT(6) UNSIGNED NOT NULL,
 course_code VARCHAR(20) NOT NULL,
 session VARCHAR(30) NOT NULL,
 PRIMARY KEY (course_code,session)
);
 


CREATE TABLE FinalExamMarks
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  exam_roll VARCHAR(10) NOT NULL,
  examinerId INT(6) NOT NULL,
  questionOneMarks DECIMAL(5,2),
  questionTwoMarks DECIMAL(5,2),
  questionThreeMarks DECIMAL(5,2),
  questionFourMarks DECIMAL(5,2),
  questionFiveMarks DECIMAL(5,2),
  questionSixMarks DECIMAL(5,2),
  totalMarks DECIMAL(5,2),
  PRIMARY KEY(course_code,session,exam_roll,examinerId)
);
CREATE TABLE CourseTeacher
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  id INT(6),
 PRIMARY KEY(course_code,session)
)

CREATE TABLE IncourseMarkingScale
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  incourse_exam DECIMAL(5,2),
  viva DECIMAL(5,2),
  attendance  DECIMAL(5,2),
  assignment  DECIMAL(5,2),
  presentation  DECIMAL(5,2),
  suddent_test DECIMAL(5,2),
  totalMarks DECIMAL(5,2),
  PRIMARY KEY(course_code,session)
);

CREATE TABLE IncourseMark
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  dept_roll VARCHAR(10) NOT NULL,
  incourse_exam DECIMAL(5,2),
  viva DECIMAL(5,2),
  attendance  DECIMAL(5,2),
  assignment  DECIMAL(5,2),
  presentation  DECIMAL(5,2),
  suddent_test DECIMAL(5,2),
  totalMarks DECIMAL(5,2),
  PRIMARY KEY(course_code,session,dept_roll)
);



CREATE TABLE CourseSemester 
(
   year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th','ms')),
semester VARCHAR(5) CHECK (semester IN ('1st','2nd')),
 course_code1 VARCHAR(20),
 course_code2 VARCHAR(20),
 course_code3 VARCHAR(20),
 course_code4 VARCHAR(20),
 course_code5 VARCHAR(20),
 course_code6 VARCHAR(20),
 course_code7 VARCHAR(20),
 course_code8 VARCHAR(20),
 course_code9 VARCHAR(20),
 course_code10 VARCHAR(20),
 course_code11 VARCHAR(20),
 PRIMARY KEY (year,semester)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tabulation 
(
   registration VARCHAR(20),
   regi_session VARCHAR(20),
   exam_roll VARCHAR(10) NOT NULL,
   exam_year VARCHAR(10) NOT NULL,
   year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th','ms')),
semester VARCHAR(5) CHECK (semester IN ('1st','2nd')),
 course_code1 decimal(5,2),
 course_code2 decimal(5,2),
 course_code3 decimal(5,2),
 course_code4 decimal(5,2),
 course_code5 decimal(5,2),
 course_code6 decimal(5,2),
 course_code7 decimal(5,2),
 course_code8 decimal(5,2),
 course_code9 decimal(5,2),
 course_code10 decimal(5,2),
 course_code11 decimal(5,2),
 sgpa decimal(5,2),
 PRIMARY KEY (registration,regi_session,exam_roll,year,semester)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE BatchSemester 
(
   batch VARCHAR(20),
   year  VARCHAR(5)  CHECK (year IN ('1st','2nd','3rd','4th','ms')),
semester VARCHAR(5) CHECK (semester IN ('1st','2nd')),
 current_session VARCHAR(20),
 PRIMARY KEY (batch)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE checkFinalResultData 
(
   course_code VARCHAR(20) NOT NULL,
   session VARCHAR(30) NOT NULL,
   batch VARCHAR(6),
   Incourse VARCHAR(5),
   firstFinal VARCHAR(5),
   secondFinal VARCHAR(5),
    CHECK(Incourse IN('YES','NO')),
   CHECK(firstFinal IN('YES','NO')),
  CHECK(secondFinal IN('YES','NO'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE IncourseExamScale
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  batch VARCHAR(6),
  incourse_exam1 DECIMAL(5,2),
  incourse_exam2 DECIMAL(5,2),
  incourse_exam3 DECIMAL(5,2),
  incourse_exam4 DECIMAL(5,2),
  totalIncourse DECIMAL(5,2),
  PRIMARY KEY(course_code,session,batch)
);


CREATE TABLE IncourseExam
(
  course_code VARCHAR(20) NOT NULL,
  session VARCHAR(30) NOT NULL,
  dept_roll VARCHAR(10) NOT NULL,
  batch VARCHAR(6),
  incourse_exam1 DECIMAL(5,2),
  incourse_exam2 DECIMAL(5,2),
  incourse_exam3 DECIMAL(5,2),
  incourse_exam4 DECIMAL(5,2),
  PRIMARY KEY(batch,dept_roll)
);


