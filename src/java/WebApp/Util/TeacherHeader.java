/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shamim
 */
public class TeacherHeader 
{
    public static ModelAndView getMenu(ModelAndView modelAndView,HttpServletRequest request)
    {
                 User currentUser=AuthenticationHelper.getCurrentUser(request);
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
    
}
