
package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.Teacher;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Service.TeacherService;
import WebApp.Service.TeacherServiceImp;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertFormController implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String requestedUri = request.getRequestURI();
        
        ModelAndView modelAndView = null;
        if(requestedUri.contains(Constants.COURSE_TEACHER_FORM))
        {
            CourseService courseService = new CourseServiceImp();
            List<Course> courses = courseService.getAllCourses();
            TeacherService teacherService = new TeacherServiceImp();
            List<Teacher> teachers = teacherService.getAllTeacher();
            
            modelAndView = new ModelAndView("courseTeacherForm");
            modelAndView.addObject("courses",courses);
            modelAndView.addObject("teachers",teachers);
            
        }
        else if(requestedUri.contains(Constants.STUDENT_FORM))
        {
            modelAndView = new ModelAndView("studentForm");
        }
        else if(requestedUri.contains(Constants.COURSE_FORM))
        {
            modelAndView = new ModelAndView("courseForm");
        }
        else if(requestedUri.contains(Constants.TEACHER_FORM))
        {
            modelAndView = new ModelAndView("TeacherForm");
        } 
        /*modelAndView = new ModelAndView("message");
        modelAndView.addObject("message", requestedUri);*/
        return modelAndView;
            
     }
    
}
