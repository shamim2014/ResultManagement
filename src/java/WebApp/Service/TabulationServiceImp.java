
package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.Model.Course;
import WebApp.Model.CourseMap;
import WebApp.Model.CourseMarks;
import WebApp.Model.CourseSemester;
import WebApp.Model.FinalMarks;
import WebApp.Model.LabMarkingScale;
import WebApp.Model.Student;
import WebApp.Model.StudentTabulation;
import WebApp.Model.StudentTabulationHeader;
import WebApp.Model.Tabulation;
import WebApp.Util.Excel;
import WebApp.repository.BatchSemesterDAO;
import WebApp.repository.BatchSemesterDAOImp;
import WebApp.repository.CourseDAO;
import WebApp.repository.CourseDAOImp;
import WebApp.repository.CourseSemesterDAO;
import WebApp.repository.CourseSemesterDAOImp;
import WebApp.repository.LabDAO;
import WebApp.repository.LabDAOImp;
import WebApp.repository.StudentDAO;
import WebApp.repository.StudentDAOImp;
import WebApp.repository.TabulationDAO;
import WebApp.repository.TabulationDAOImp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shamim
 */
public class TabulationServiceImp implements TabulationService
{
    private TabulationDAO tabulationDAO;
    private BatchSemesterDAO batchSemesterDAO;
    private CourseSemesterDAO courseSemesterDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private LabDAO labDAO;
    
    public TabulationServiceImp()
    {
        tabulationDAO = new TabulationDAOImp();
        batchSemesterDAO = new BatchSemesterDAOImp();
        studentDAO = new StudentDAOImp();
        courseDAO = new CourseDAOImp();
        courseSemesterDAO = new CourseSemesterDAOImp();
        labDAO = new LabDAOImp();
    }
    
    @Override
    public List<Tabulation> createTabulation(BatchSemester batchSemester,CourseSemester courseSemester,List<Student> students, List<Course> courses,String examYear) 
    {
        List<CourseMarks>courseMarkses;
        List<Tabulation> tabulationList= new ArrayList<Tabulation>();
        LabMarkingScale labMarkingScale;
        
        if(courses.get(0).getCourseType().equalsIgnoreCase("Lab"))
            courseMarkses=tabulationDAO.getTablutionByCourseCodeLab(courses.get(0).getCourseCode(),batchSemester.getSession(),batchSemester.getBatch());
        else
            courseMarkses=tabulationDAO.getTablutionByCourseCode(courses.get(0).getCourseCode(),batchSemester.getSession(),batchSemester.getBatch());
        
        Tabulation tabulation;
        for(int i=0;i<students.size();i++)
        {
            tabulation = new Tabulation();
            setTabulation(tabulation,students.get(i),examYear);
            tabulationList.add(tabulation);
        }
        double totalCredit =0;
        
        for(int i=0;i<courses.size();i++)
        {
            labMarkingScale=null;
            if(courses.get(i).getCourseType().equalsIgnoreCase("Lab"))
            {
                courseMarkses=tabulationDAO.getTablutionByCourseCodeLab(courses.get(i).getCourseCode(),batchSemester.getSession(),batchSemester.getBatch());
                labMarkingScale=labDAO.getLabMarkingScale(courses.get(i).getCourseCode(), batchSemester.getSession());
            }  
            else
                courseMarkses=tabulationDAO.getTablutionByCourseCode(courses.get(i).getCourseCode(),batchSemester.getSession(),batchSemester.getBatch());
            
            totalCredit +=courses.get(i).getCredit();
            int last =0;
            for(int j=0;j<tabulationList.size();j++)
            {      
                   tabulation=tabulationList.get(j);
                   if(last<courseMarkses.size()&&courseMarkses.get(last).getExamRoll().equals(tabulation.getExamRoll()))
                   {
                       if(courses.get(i).getCourseType().equalsIgnoreCase("Lab"))
                       {
                           setTabulationLab(tabulation,courseMarkses.get(last),labMarkingScale.getTotalMarks());
                           tabulation.setTotalMarks(tabulation.getTotalMarks()+courseMarkses.get(last).getTotalMarks());
                       }
                       else
                       {
                           setTabulation(tabulation,courseMarkses.get(last));
                           tabulation.setTotalMarks(tabulation.getTotalMarks()+courseMarkses.get(last).getTotalMarks());
                       }
                       
                       tabulation.setTotalPoint(tabulation.getCoursePoint(courses.get(i).getCourseCode())*courses.get(i).getCredit());
                       last++;
                   }
                   else
                   {
                       setGradeForAbsent(tabulationList.get(j),courses.get(i).getCourseCode());
                   }             
            }
            
        }
        for(int j=0;j<tabulationList.size();j++)
        {      
            tabulation=tabulationList.get(j);
            tabulation.setTotalCredit(totalCredit);
            tabulation.setSgpa(tabulation.getTotalPoint()/totalCredit);
        }
        tabulationDAO.saveTabulation(tabulationList, courseSemester);
       return tabulationList; 
    }
    private void setGradeForAbsent(Tabulation tabulation,String courseCode)
    {
        tabulation.setCoursePoint(courseCode,0.0);
    }
    private void setTabulation(Tabulation tabulation,Student student,String examYear)
    {
        tabulation.setDept_Roll(student.getDeptRoll());
        tabulation.setExamRoll(student.getExamRoll());
        tabulation.setHall(student.getHall());
        tabulation.setRegistration(student.getRegistration());
        tabulation.setRegistrationSession(student.getRegistrationSession());
        tabulation.setSemester(student.getSemester());
        tabulation.setYear(student.getYear());
        tabulation.setExamYear(examYear);
    }
    private void setTabulation(Tabulation tabulation,CourseMarks courseMarks)
    {
        if(!tabulation.getExamRoll().equals(courseMarks.getExamRoll()))
            throw new RuntimeException("student mismatch");
        else
        {
            tabulation.setYear(courseMarks.getYear());
            tabulation.setSemester(courseMarks.getSemester());
            tabulation.setCoursePoint(courseMarks.getCourseCode(),getPoint(courseMarks.getTotalMarks()));
        }
        
    }
    private void setTabulationLab(Tabulation tabulation,CourseMarks courseMarks,double scale)
    {
        if(!tabulation.getExamRoll().equals(courseMarks.getExamRoll()))
            throw new RuntimeException("student mismatch");
        else
        {
            tabulation.setYear(courseMarks.getYear());
            tabulation.setSemester(courseMarks.getSemester());
            tabulation.setCoursePoint(courseMarks.getCourseCode(),getPoint(courseMarks.getTotalMarks()*100/scale));
        }
    }
    private double getPoint(double mark)
    {
        
        if(mark>=80)
            return 4.0;
        else if(mark>=75)
            return 3.75;
        else if(mark>=70)
            return 3.5;
        else if(mark>=65)
            return 3.25;
        else if(mark>=60)
            return 3.0;
        else if(mark>=55)
            return 2.75;
        else if(mark>=50)
            return 2.50;
        else if(mark>=45)
            return 2.25;
        else if(mark>=40)
            return 2.0;
        else
            return 0.0;
            
            
    }

    @Override
    public Hashtable<String, Hashtable<String, CourseMarks>> getCourseMarks(BatchSemester batchSemester, List<Student> students, List<Course> courses) 
    {
        Hashtable<String, Hashtable<String, CourseMarks>> markSheet = new Hashtable<String, Hashtable<String, CourseMarks>>();
        List<CourseMarks>courseMarkses;
        
        for(Course course: courses)
        {
            courseMarkses=tabulationDAO.getTablutionByCourseCode(course.getCourseCode(),batchSemester.getSession(),batchSemester.getBatch());
            
            for(CourseMarks courseMarks : courseMarkses)
            {
               if(!markSheet.containsKey(courseMarks.getExamRoll()))
                          markSheet.put(courseMarks.getExamRoll(),new Hashtable<String, CourseMarks>());
               markSheet.get(courseMarks.getExamRoll()).put(courseMarks.getCourseCode(), courseMarks);
            }
            
        }
        return markSheet;
    }

    @Override
    public List<Tabulation> getTabulation(String registration, String registrationSession)
    {
        CourseSemesterDAO courseSemesterDAO = new CourseSemesterDAOImp();
        List<Tabulation> tabulations = tabulationDAO.getTabulationByStudent(registration, registrationSession);
        List<CourseMap> courseMaps = courseSemesterDAO.getCourseMaps();
        
        int i=0;
        for(Tabulation tabulation: tabulations)
        {
            if(courseMaps.get(i).getSemesterCourseMap("course_code1")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code1"), tabulation.getCoursePoint("course_code1"));
                tabulation.remove("course_code1");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code2")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code2"), tabulation.getCoursePoint("course_code2"));
                tabulation.remove("course_code2");
            }   
            if(courseMaps.get(i).getSemesterCourseMap("course_code3")!=null)
            {
                 tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code3"), tabulation.getCoursePoint("course_code3"));
                 tabulation.remove("course_code3");
            }  
            if(courseMaps.get(i).getSemesterCourseMap("course_code4")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code4"), tabulation.getCoursePoint("course_code4"));
                tabulation.remove("course_code4");
            }
                 
            if(courseMaps.get(i).getSemesterCourseMap("course_code5")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code5"), tabulation.getCoursePoint("course_code5")); 
                tabulation.remove("course_code5");
            }
                
            if(courseMaps.get(i).getSemesterCourseMap("course_code6")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code6"), tabulation.getCoursePoint("course_code6"));
                tabulation.remove("course_code6");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code7")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code7"), tabulation.getCoursePoint("course_code7"));
                tabulation.remove("course_code7");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code8")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code8"), tabulation.getCoursePoint("course_code8"));
                tabulation.remove("course_code8");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code9")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code9"), tabulation.getCoursePoint("course_code9"));
                tabulation.remove("course_code9");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code10")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code10"), tabulation.getCoursePoint("course_code10"));
                tabulation.remove("course_code10");
            }
            if(courseMaps.get(i).getSemesterCourseMap("course_code11")!=null)
            {
                tabulation.setCoursePoint(courseMaps.get(i).getSemesterCourseMap("course_code11"), tabulation.getCoursePoint("course_code11"));
                tabulation.remove("course_code11");
            }
            i++;
        }
        return tabulations;
    }

    @Override
    public List<Tabulation> createTabulation(String year) 
    {
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        CourseSemester courseSemester =courseSemesterDAO.getCourseSemester(batchSemester.getYear(), batchSemester.getSemester());
        List<Student> students = studentDAO.getStudentByBatch(batchSemester.getBatch());
        List<Course> courses = courseDAO.getSemesterCourses(courseSemester);
        String examYear[] = batchSemester.getSession().split("-");
        
        return createTabulation(batchSemester,courseSemester,students,courses,examYear[1]);
    }

    @Override
    public List<Tabulation> getTabulation(List<Student> students)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<Tabulation>> getTabulation(String year) 
    {
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        List<Student> students = studentDAO.getStudentByBatch(batchSemester.getBatch());
        List<List<Tabulation>> tabulations = new ArrayList<List<Tabulation>>();
        List<Tabulation> tabulation;
        
        for(Student student : students)
        {
            tabulation = getTabulation(students);
            tabulations.add(tabulation);
        }
        
        if(tabulations!=null && !tabulations.isEmpty())
            return tabulations;
        
        return null;
    }

    @Override
    public StudentTabulationHeader getStudentTabulationHeader(String year)
    {
        StudentTabulationHeader studentTabulationHeader = new StudentTabulationHeader();
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        CourseSemester courseSemester =courseSemesterDAO.getCourseSemester(batchSemester.getYear(), batchSemester.getSemester());
        List<Course> courses = courseDAO.getSemesterCourses(courseSemester);
        
        List<Course> lab= new ArrayList<Course>();
        List<Course> theory = new ArrayList<Course>();
        for(Course course : courses)
        {
            if(course.getCourseType().equalsIgnoreCase("Lab"))
            {
                studentTabulationHeader.setLabCourse(studentTabulationHeader.getLabCourse()+1);
                lab.add(course);
            }
            else
            {
                studentTabulationHeader.setTheoryCourse(studentTabulationHeader.getTheoryCourse()+1);
                theory.add(course);
            }
        }
        
        studentTabulationHeader.setLab(lab);
        studentTabulationHeader.setTheory(theory);
        
        if(batchSemester.getYear().equalsIgnoreCase("4th")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
        {
            studentTabulationHeader.setSemister(8);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("4th")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
        {
            studentTabulationHeader.setSemister(7);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("3rd")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
        {
            studentTabulationHeader.setSemister(6);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("3rd")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
        {
            studentTabulationHeader.setSemister(5);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("2nd")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
        {
            studentTabulationHeader.setSemister(4);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("2nd")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
        {
            studentTabulationHeader.setSemister(3);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("1st")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
        {
            studentTabulationHeader.setSemister(2);
        }
        else if(batchSemester.getYear().equalsIgnoreCase("1st")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
        {
            studentTabulationHeader.setSemister(1);
        }
        
        return studentTabulationHeader;
    }

    @Override
    public List<StudentTabulation> getStudentTabulation(String year) 
    {
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        List<Student> students = studentDAO.getStudentByBatch(batchSemester.getBatch());
        CourseSemester courseSemester =courseSemesterDAO.getCourseSemester(batchSemester.getYear(), batchSemester.getSemester());
        List<Course> courses = courseDAO.getSemesterCourses(courseSemester);
        
        List<StudentTabulation> studentTabulations = new ArrayList<StudentTabulation>();
        Tabulation tabulation;
        StudentTabulation studentTabulation;
        List<CourseMarks> theory;
        List<CourseMarks>lab;
        FinalMarks finalMarks;
        CourseMarks courseMarks;
        double point=0,credit=0;
        
        for(Student student : students)
        {
            point=0;
            credit=0;
            studentTabulation = new StudentTabulation();
            studentTabulation.setDept_Roll(student.getDeptRoll());
            studentTabulation.setExamRoll(student.getExamRoll());
            studentTabulation.setName(student.getName());
            studentTabulation.setNameOfHall(student.getHall());
            studentTabulation.setRegistration(student.getRegistration());
            studentTabulation.setRegistrationSession(student.getRegistrationSession());
            
            if(batchSemester.getYear().equalsIgnoreCase("4th")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"4th","2nd");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(8);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"4th","1st");
                studentTabulation.setPrevouseWeightedPoint(tabulation.getTotalPoint());
                studentTabulation.setPrevouseTotalCredit(tabulation.getTotalCredit());
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                
                studentTabulation.setFourYearWeightedPoint(point);
                studentTabulation.setFourYearCredit(credit);
                
                double thirdPoint=0;
                double thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setThreeYearWeightedPoint(thirdPoint);
                studentTabulation.setThreeYearCredit(thirdcredit);
                
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setTwoYearWeightedPoint(thirdPoint);
                studentTabulation.setTwoYearCredit(thirdcredit);
               
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("4th")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"4th","1st");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(7);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
             
                
                double thirdPoint=0;
                double thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setThreeYearWeightedPoint(thirdPoint);
                studentTabulation.setThreeYearCredit(thirdcredit);
                
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setTwoYearWeightedPoint(thirdPoint);
                studentTabulation.setTwoYearCredit(thirdcredit);
               
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("3rd")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","2nd");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(6);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","1st");
                studentTabulation.setPrevouseWeightedPoint(tabulation.getTotalPoint());
                studentTabulation.setPrevouseTotalCredit(tabulation.getTotalCredit());
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                
                studentTabulation.setThreeYearWeightedPoint(point);
                studentTabulation.setThreeYearCredit(credit);
                
                double thirdPoint=0;
                double thirdcredit=0;
              
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setTwoYearWeightedPoint(thirdPoint);
                studentTabulation.setTwoYearCredit(thirdcredit);
               
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("3rd")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"3rd","1st");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(5);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
             
                
                double thirdPoint=0;
                double thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setTwoYearWeightedPoint(thirdPoint);
                studentTabulation.setTwoYearCredit(thirdcredit);
                
               
                thirdPoint=0;
                thirdcredit=0;
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("2nd")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","2nd");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(4);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                studentTabulation.setPrevouseWeightedPoint(tabulation.getTotalPoint());
                studentTabulation.setPrevouseTotalCredit(tabulation.getTotalCredit());
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                
                studentTabulation.setTwoYearWeightedPoint(point);
                studentTabulation.setTwoYearCredit(credit);
                
                double thirdPoint=0;
                double thirdcredit=0;
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("2nd")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"2nd","1st");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(3);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
             
                
                double thirdPoint=0;
                double thirdcredit=0;
                
 
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                thirdPoint+=tabulation.getTotalPoint();
                thirdcredit+=tabulation.getTotalCredit();
                studentTabulation.setOneYearWeightedPoint(thirdPoint);
                studentTabulation.setOneYearCredit(thirdcredit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("1st")&&batchSemester.getSemester().equalsIgnoreCase("2nd"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","2nd");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(2);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
                
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                studentTabulation.setPrevouseWeightedPoint(tabulation.getTotalPoint());
                studentTabulation.setPrevouseTotalCredit(tabulation.getTotalCredit());
                point+=tabulation.getTotalPoint();
                credit+=tabulation.getTotalCredit();
                
               
                studentTabulation.setOneYearWeightedPoint(point);
                studentTabulation.setOneYearCredit(credit);
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
            }
            else if(batchSemester.getYear().equalsIgnoreCase("1st")&&batchSemester.getSemester().equalsIgnoreCase("1st"))
            {
                tabulation=tabulationDAO.getTabulationByStudent(student.getRegistration(),student.getRegistrationSession(),"1st","1st");
                studentTabulation.setSgpa(tabulation.getSgpa());
                studentTabulation.setSemister(1);
                studentTabulation.setCurrentTotalMarks(tabulation.getTotalMarks());
                studentTabulation.setCurrentWeightedPoint(tabulation.getTotalPoint());
                point=tabulation.getTotalPoint();
                studentTabulation.setCurrentTotalCredit(tabulation.getTotalCredit());
                credit=tabulation.getTotalCredit();
             
                studentTabulation.setTotalCredit(credit);
                studentTabulation.setTotalWeightedPoint(point);
                
                 
            }
            studentTabulation.setCgpa(studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit());
            theory = new ArrayList<CourseMarks>();
            lab = new ArrayList<CourseMarks>();
            for(Course course : courses)
            {
                if(course.getCourseType().equalsIgnoreCase("Lab"))
                {
                    courseMarks=tabulationDAO.getTablutionByCourseCodeLabAndStudent(course.getCourseCode(),batchSemester.getSession(),batchSemester.getBatch(),student.getExamRoll());
                    lab.add(courseMarks);
                }
                else
                {
                    courseMarks=tabulationDAO.getTablutionByCourseCodeAndStudent(course.getCourseCode(),batchSemester.getSession(),batchSemester.getBatch(),student.getExamRoll());
                    theory.add(courseMarks);
                }
            }
            studentTabulation.setTheory(theory);
            studentTabulation.setLab(lab);
           
            studentTabulations.add(studentTabulation);
        }
       
        return studentTabulations;
    }

    @Override
    public String createExcel(StudentTabulationHeader studentTabulationHeader, List<StudentTabulation> studentTabulations,String realPath) 
    {
        try 
        {
            return Excel.createTabulationSheet(studentTabulationHeader, studentTabulations,realPath);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TabulationServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
