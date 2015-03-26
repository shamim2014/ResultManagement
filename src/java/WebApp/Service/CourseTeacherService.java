/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Course;
import WebApp.Model.CourseTeacher;
import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shamim
 */
public interface CourseTeacherService 
{
    public void saveCourseTeacher(CourseTeacher courseTeacher,Course course);
    public List<Course> getCoursesByTeacher(String email);
    public TeacherCourse getTeacherAndCourse(String courseCode,String session);
    public List<TeacherCourse> getTeacherRunningTheoryCourse(String email);
    public List<TeacherCourse> getTeacherExaminedTheoryCourse(String email);
    public List<TeacherCourse> getTeacherRunningLabCourse(String email);
    public List<TeacherCourse> getTeacherAssistLabCourse(String email);
    public ModelAndView getCourse(ModelAndView modelAndView,User user);
}
