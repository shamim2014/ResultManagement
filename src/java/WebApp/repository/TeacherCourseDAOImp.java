/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.TeacherCourse;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.InstructorMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class TeacherCourseDAOImp implements TeacherCourseDAO
{

    @Override
    public List<TeacherCourse> getFirstTheoryTeacherCourse(String email) 
    {
        String SQL="SELECT course_code,title,credit,course_type,year,semester,session,firstExaminerEmail as email FROM Course NATURAL JOIN TheorySubject WHERE firstExaminerEmail =? AND SESSION =(SELECT DISTINCT(current_session) FROM BatchSemester)";
        List<TeacherCourse> teacherCourses = DatabaseTemplate.executeQuery(SQL,new Object[]{email},new InstructorMapper());
        if(teacherCourses!=null&&!teacherCourses.isEmpty())
            return teacherCourses;
        
        return null;
    }

    @Override
    public List<TeacherCourse> getSecondTheoryTeacherCourse(String email)
    {
        String SQL="SELECT course_code,title,credit,course_type,year,semester,session,secondExaminerEmail as email FROM Course NATURAL JOIN TheorySubject WHERE secondExaminerEmail =? AND SESSION =(SELECT DISTINCT(current_session) FROM BatchSemester);";
        List<TeacherCourse> teacherCourses = DatabaseTemplate.executeQuery(SQL,new Object[]{email},new InstructorMapper());
        if(teacherCourses!=null&&!teacherCourses.isEmpty())
            return teacherCourses;
        
        return null;
    }

    @Override
    public List<TeacherCourse> getFirstLabTeacherCourse(String email)
    {
       String SQL="SELECT course_code,title,credit,course_type,year,semester,session,firstExaminerEmail as email FROM Course NATURAL JOIN Lab WHERE firstExaminerEmail =? AND SESSION =(SELECT DISTINCT(current_session) FROM BatchSemester);";
        List<TeacherCourse> teacherCourses = DatabaseTemplate.executeQuery(SQL,new Object[]{email},new InstructorMapper());
        if(teacherCourses!=null&&!teacherCourses.isEmpty())
            return teacherCourses;
        
        return null;
    }

    @Override
    public List<TeacherCourse> getSecondLabTeacherCourse(String email) 
    {
        String SQL="SELECT course_code,title,credit,course_type,year,semester,session,secondExaminerEmail as email FROM Course NATURAL JOIN Lab WHERE secondExaminerEmail =? AND SESSION =(SELECT DISTINCT(current_session) FROM BatchSemester)";
        List<TeacherCourse> teacherCourses = DatabaseTemplate.executeQuery(SQL,new Object[]{email},new InstructorMapper());
        if(teacherCourses!=null&&!teacherCourses.isEmpty())
            return teacherCourses; 
        
        return null;
    }
    
}
