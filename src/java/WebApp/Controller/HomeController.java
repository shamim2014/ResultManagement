
package WebApp.Controller;

import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Service.ExamCommitteeService;
import WebApp.Service.ExamCommitteeServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
       User currentUser=AuthenticationHelper.getCurrentUser(request);
        ModelAndView modelAndView=null;
        
         if(currentUser==null)
         {
             modelAndView = new ModelAndView("index");
             modelAndView.addObject("errorMessage", "Login please");
             return modelAndView;
         }
            
        modelAndView= new ModelAndView(currentUser.getType());;
       
       if(currentUser!=null &&currentUser.getType().equals(Constants.OFFICIAL))
           return modelAndView;
       
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
       
         if(currentUser!=null &&currentUser.getType().equals(Constants.COMMITTEE))
         {
             ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
             List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
             modelAndView.addObject("examYears", examYears);
                    
         }
         
                    
        return modelAndView;
        
    }
    
}
