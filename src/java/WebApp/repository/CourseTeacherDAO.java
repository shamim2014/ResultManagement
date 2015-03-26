/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Course;
import WebApp.Model.CourseTeacher;
import WebApp.Model.TeacherCourse;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface CourseTeacherDAO
{
    public void saveCourseTeacher(CourseTeacher courseTeacher);
    public List<TeacherCourse> findTeacherCourseByEmailAndSession(String email,String session);
    public List<TeacherCourse> findTeacherCourseByEmail(String email);
    public List<CourseTeacher> getTeachingCourseCode(String email,String session);
    public List<Course> getCourseByTeacher(String email);
    public List<Course> getCourseByTeacher(String email,String session);
    public List<CourseTeacher> findCourseTeacherByEmailAndSession(String email,String session);
    public TeacherCourse getTeacherAndCourse(String courseCode,String session);
    
}
