/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Course;
import WebApp.Model.CourseTeacher;
import WebApp.Model.TeacherCourse;
import WebApp.Util.CourseMapper;
import WebApp.Util.CourseTeacherMapper;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.TeacherCourseMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class CourseTeacherDAOImp implements CourseTeacherDAO
{

    @Override
    public void saveCourseTeacher(CourseTeacher courseTeacher) 
    {
        String SQL = "INSERT INTO CourseTeacher (course_code, session, email) VALUES (?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL, courseTeacher.getCourseCode(),courseTeacher.getSession(),courseTeacher.getEmail());
    }

    @Override
    public List<TeacherCourse> findTeacherCourseByEmailAndSession(String email,String session)
    {
        String SQL = "SELECT * FROM Course NATURAL JOIN CourseTeacher NATURAL JOIN Teacher WHERE email= ? AND session = ?";
        List<TeacherCourse> courseTeachers = DatabaseTemplate.executeQuery(SQL, new Object[]{email,session},new TeacherCourseMapper());
        return courseTeachers;
    }
     @Override
    public List<TeacherCourse> findTeacherCourseByEmail(String email) 
    {
        String SQL = "SELECT * FROM Course NATURAL JOIN CourseTeacher NATURAL JOIN Teacher WHERE email= ?";
        List<TeacherCourse> courseTeachers = DatabaseTemplate.executeQuery(SQL, new Object[]{email},new TeacherCourseMapper());
        return courseTeachers;  
    }

    @Override
    public List<CourseTeacher> getTeachingCourseCode(String email, String session) 
    {
        String SQL = "SELECT * FROM CourseTeacher WHERE email= ? AND session = ?";
        List<CourseTeacher> courseTeachers = DatabaseTemplate.executeQuery(SQL, new Object[]{email,session}, new CourseTeacherMapper());
        return courseTeachers;
    }

    @Override
    public List<Course> getCourseByTeacher(String email) 
    {
        String SQL = "SELECT * FROM Course NATURAL JOIN CourseTeacher WHERE email= ?";
        List<Course> courses = DatabaseTemplate.executeQuery(SQL, new Object[]{email},new CourseMapper());
        return courses;
    }

    @Override
    public List<Course> getCourseByTeacher(String email, String session) 
    {
        String SQL = "SELECT * FROM Course NATURAL JOIN CourseTeacher WHERE email= ? AND session = ?";
        List<Course> courses = DatabaseTemplate.executeQuery(SQL, new Object[]{email,session},new CourseMapper());
        return courses;
    }

    @Override
    public List<CourseTeacher> findCourseTeacherByEmailAndSession(String email, String session)
    {
        String SQL = "SELECT * FROM CourseTeacher WHERE email= ? AND session = ?";
        List<CourseTeacher> courseTeachers = DatabaseTemplate.executeQuery(SQL, new Object[]{email,session},new CourseTeacherMapper());
        return courseTeachers;
    }

    @Override
    public TeacherCourse getTeacherAndCourse(String courseCode, String session) 
    {
        String SQL = "SELECT * FROM Course NATURAL JOIN CourseTeacher NATURAL JOIN Teacher WHERE course_code = ? AND session =?";
        List<TeacherCourse> courseTeachers = DatabaseTemplate.executeQuery(SQL, new Object[]{courseCode,session},new TeacherCourseMapper());
        
        if(courseTeachers!=null && !courseTeachers.isEmpty())
        {
            return courseTeachers.get(0);
        } 
        return null;
    }

    
}
