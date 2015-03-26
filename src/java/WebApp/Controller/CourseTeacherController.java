/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.CourseTeacher;
import WebApp.Model.TeacherCourse;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class CourseTeacherController implements Controller
{
    private static final String COURSE_NAME = "course_name";
    private static final String COURSE_CODE = "course_code";
    private static final String SESSION = "session";
    private static final String EMAIL = "email";
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView modelAndView =null;
        
        String courseName = request.getParameter(COURSE_NAME);
        String courseCode = request.getParameter(COURSE_CODE);
        String session = request.getParameter(SESSION);
        String email = request.getParameter(EMAIL);
        String requestedUri = request.getRequestURI();
        
        if(requestedUri.contains(Constants.INSERT_COURSE_TEACHER))
        {
            CourseTeacher courseTeacher = createCourseTeacher(courseCode,session,email);
            CourseService courseService = new CourseServiceImp();
            Course course = courseService.getCourseByCourseCode(courseCode);
            
            CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
            courseTeacherService.saveCourseTeacher(courseTeacher,course);
            
            TeacherCourse teacherCourse = courseTeacherService.getTeacherAndCourse(courseCode, session);
            
            modelAndView = new ModelAndView("courseTeacherForm");
            modelAndView.addObject("teacherCourse",teacherCourse);
            
            if(teacherCourse!=null)
            {
                modelAndView.addObject("teacherCourseError","Following Information Successfully Inserted");
            }
            else
            {
                modelAndView.addObject("teacherCourseError","Information does not inserted!");
            }
        }
        return modelAndView;
    }
    
    private CourseTeacher createCourseTeacher(String courseCode,String session,String email)
    {
        CourseTeacher courseTeacher = new CourseTeacher();
        courseTeacher.setCourseCode(courseCode);
        courseTeacher.setSession(session);
        courseTeacher.setEmail(email);
        return courseTeacher;
    }
    
}
