/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.FinalExamMark;
import WebApp.Model.Student;
import WebApp.Model.User;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Service.FinalExamService;
import WebApp.Service.FinalExamServiceImp;
import WebApp.Service.StudentService;
import WebApp.Service.StudentServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import WebApp.Util.TeacherHeader;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class OfficialViewController implements Controller
{
    private static final String COURSE_CODE = "course_code";
    private static final String SESSION = "session";

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ModelAndView modelAndView=null;
        String requestedUri = request.getRequestURI();
         
        if(requestedUri.contains(Constants.VIEW_COURSES))
        {
           modelAndView = new ModelAndView("viewCourses");
           CourseService courseService = new CourseServiceImp();
           List<Course> courses = courseService.getAllCourses();
           modelAndView.addObject("courses", courses);
        }
        else if(requestedUri.contains(Constants.VIEW_STUDENTS))
        {
           modelAndView = new ModelAndView("viewOfficial");
           StudentService studentService = new StudentServiceImp();
           List<Student> students=null;
           if(request.getParameter("year")!=null)
              students= studentService.getStudents(request.getParameter("year"));
            if(AuthenticationHelper.getCurrentUser(request).getType().equalsIgnoreCase("official"))
            {
                modelAndView = new ModelAndView("viewOfficial");
            }
            else if(AuthenticationHelper.getCurrentUser(request).getType().equalsIgnoreCase("teacher"))
            {
                 modelAndView = new ModelAndView("viewTeacher");
                 modelAndView = TeacherHeader.getMenu(modelAndView, request);
            } 
            else if(AuthenticationHelper.getCurrentUser(request).getType().equalsIgnoreCase("committee"))
            {
                modelAndView = new ModelAndView("viewCommittee");
            }
             modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains("viewFinalmarks"))
        {
            List<FinalExamMark> finalExamMarks;
            FinalExamService finalExamService = new FinalExamServiceImp();
            User currentUser=AuthenticationHelper.getCurrentUser(request);
            
            if(AuthenticationHelper.getCurrentUser(request).getType().equalsIgnoreCase("teacher"))
            {
                 modelAndView = new ModelAndView("viewTeacher");
                 modelAndView = TeacherHeader.getMenu(modelAndView, request);
            } 
            else if(AuthenticationHelper.getCurrentUser(request).getType().equalsIgnoreCase("committee"))
            {
                modelAndView = new ModelAndView("viewCommittee");
                modelAndView = TeacherHeader.getMenu(modelAndView, request);
            }
            finalExamMarks= finalExamService.gerFinalMarks(request.getParameter(COURSE_CODE), request.getParameter(SESSION),currentUser.getEmail());
            modelAndView.addObject("finalExamMarks", finalExamMarks);
        }
        return modelAndView;
    }
    
}
