/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class TeacherController implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String requestedUri = request.getRequestURI();
        User currentUser=AuthenticationHelper.getCurrentUser(request);
        
        ModelAndView modelAndView = null;
        
        if(requestedUri.contains(Constants.INCOURSE_MARK_DISTIBUTION))
        {
            modelAndView = new ModelAndView("incourseMarkingScope");
            return modelAndView;
        }
        else if(requestedUri.contains(Constants.THEORY_COURSE))
        {
            modelAndView = new ModelAndView("theoryCourse");
            CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
            List<TeacherCourse> teacherCourses = courseTeacherService.getTeacherRunningTheoryCourse(currentUser.getEmail());
                  
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstExaminar",teacherCourses);
            }
            
            teacherCourses = courseTeacherService.getTeacherExaminedTheoryCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondExaminar",teacherCourses);
            }
               
            teacherCourses = courseTeacherService.getTeacherRunningLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstInstructor",teacherCourses);
            }
            
            teacherCourses = courseTeacherService.getTeacherAssistLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondInstructor",teacherCourses);
            }
            
            return modelAndView;
        }
        else if(requestedUri.contains(Constants.LAB_COURSE))
        {
            modelAndView = new ModelAndView("labCourse");
            CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
            List<TeacherCourse> teacherCourses = courseTeacherService.getTeacherRunningTheoryCourse(currentUser.getEmail());
                  
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstExaminar",teacherCourses);
            }
            
            teacherCourses = courseTeacherService.getTeacherExaminedTheoryCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondExaminar",teacherCourses);
            }
               
            teacherCourses = courseTeacherService.getTeacherRunningLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("firstInstructor",teacherCourses);
            }
            
            teacherCourses = courseTeacherService.getTeacherAssistLabCourse(currentUser.getEmail());
            if(teacherCourses!=null)
            {
                modelAndView.addObject("secondInstructor",teacherCourses);
            }
            
            return modelAndView;
        }
        else if(requestedUri.contains("teacherCourse"))
        {
            modelAndView = new ModelAndView("courseShow");
            modelAndView = new ModelAndView("message");
            modelAndView.addObject("message", requestedUri);
            modelAndView.addObject("pagename", request.getParameter("pagename"));
            modelAndView.addObject("course", request.getParameter("course"));
            return modelAndView;
        }
        
        return modelAndView;
    }
    
}
