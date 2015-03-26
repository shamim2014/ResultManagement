/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Course;
import WebApp.Model.CourseTeacher;
import WebApp.Model.Lab;
import WebApp.Model.TeacherCourse;
import WebApp.Model.TheorySubject;
import WebApp.Model.User;
import WebApp.Util.Constants;
import WebApp.Util.PasswordGenerator;
import WebApp.repository.CourseTeacherDAO;
import WebApp.repository.CourseTeacherDAOImp;
import WebApp.repository.LabDAO;
import WebApp.repository.LabDAOImp;
import WebApp.repository.TeacherCourseDAO;
import WebApp.repository.TeacherCourseDAOImp;
import WebApp.repository.TheorySubjectDAO;
import WebApp.repository.TheorySubjectDAOImp;
import WebApp.repository.UserDAO;
import WebApp.repository.UserDAOImp;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shamim
 */
public class CourseTeacherServiceImp implements CourseTeacherService
{
    private CourseTeacherDAO courseTeacherDAO;
    private LabDAO labDAO;
    private TheorySubjectDAO theorySubjectDAO;
    private UserDAO userDAO;
    private TeacherCourseDAO teacherCourseDAO;
    
    public CourseTeacherServiceImp()
    {
        courseTeacherDAO = new CourseTeacherDAOImp();
        labDAO = new LabDAOImp();
        theorySubjectDAO = new TheorySubjectDAOImp();
        userDAO = new UserDAOImp();
        teacherCourseDAO = new TeacherCourseDAOImp();
    }
    @Override
    public void saveCourseTeacher(CourseTeacher courseTeacher, Course course)
    {
       courseTeacherDAO.saveCourseTeacher(courseTeacher);
       
       if(course.getCourseType().equalsIgnoreCase(Constants.COURSE_TYPE_LAB))
       {
            Lab lab = new Lab();
            lab.setFirstInstructorEmail(courseTeacher.getEmail());
            lab.setSession(courseTeacher.getSession());
            lab.setCourseCode(courseTeacher.getCourseCode());
            labDAO.saveFirstInstructor(lab);
       }
       else
       {
           TheorySubject theorySubject = new TheorySubject();
           theorySubject.setCourseCode(courseTeacher.getCourseCode());
           theorySubject.setCourseType(Constants.COURSE_TYPE_THEORY);
           theorySubject.setFirstExaminerEmail(courseTeacher.getEmail());
           theorySubject.setSession(courseTeacher.getSession());
           theorySubjectDAO.saveFirstInstructor(theorySubject);
       }
       User user = userDAO.findUserByEmail(courseTeacher.getEmail());
       if(user==null)
       {
           user = new User();
           user.setEmail(courseTeacher.getEmail());
           user.setPassWord(PasswordGenerator.getPassword());
           user.setType("teacher");
           userDAO.saveUser(user);
       }
       
    }
    
    @Override
    public List<Course> getCoursesByTeacher(String email) 
    {
        List<Course> courseTeacher = courseTeacherDAO.getCourseByTeacher(email);
        return courseTeacher;
    }

    @Override
    public TeacherCourse getTeacherAndCourse(String courseCode, String session) 
    {
        TeacherCourse teacherCourse = courseTeacherDAO.getTeacherAndCourse(courseCode, session);
        return teacherCourse;
    }

    @Override
    public List<TeacherCourse> getTeacherRunningTheoryCourse(String email) 
    {
        List<TeacherCourse> teacherCourses = teacherCourseDAO.getFirstTheoryTeacherCourse(email);
        return teacherCourses;
    }


    @Override
    public List<TeacherCourse> getTeacherExaminedTheoryCourse(String email)
    {
        List<TeacherCourse> teacherCourses = teacherCourseDAO.getSecondTheoryTeacherCourse(email);
        return teacherCourses;   
    }

    @Override
    public List<TeacherCourse> getTeacherRunningLabCourse(String email) 
    {
        List<TeacherCourse> teacherCourses = teacherCourseDAO.getFirstLabTeacherCourse(email);
        return teacherCourses;
    }

    @Override
    public List<TeacherCourse> getTeacherAssistLabCourse(String email) 
    {
        List<TeacherCourse> teacherCourses = teacherCourseDAO.getSecondLabTeacherCourse(email);
        return teacherCourses;
    }

    @Override
    public ModelAndView getCourse(ModelAndView modelAndView, User currentUser)
    {
          
            List<TeacherCourse> teacherCourses = getTeacherRunningTheoryCourse(currentUser.getEmail());
                  
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstExaminar",teacherCourses);
            }
            
            teacherCourses = getTeacherExaminedTheoryCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondExaminar",teacherCourses);
            }
               
            teacherCourses = getTeacherRunningLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstInstructor",teacherCourses);
            }
            
            teacherCourses = getTeacherAssistLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondInstructor",teacherCourses);
            }
            
            return modelAndView;    
    }

    
}
