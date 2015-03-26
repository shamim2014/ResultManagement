package WebApp.Controller;
import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Service.ExamCommitteeService;
import WebApp.Service.ExamCommitteeServiceImp;
import WebApp.Service.LoginService;
import WebApp.Service.LoginServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller
{
     
    private static final String EMAIL = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String USER_TYPE = "who";
    
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD_PARAMETER);
        String userType = request.getParameter(USER_TYPE);
        String pageName = request.getParameter("pagename");
        
        LoginService loginService = new LoginServiceImp();
        
        
       ModelAndView modelAndView;
       
       String requestedUri = request.getRequestURI();
       
       if(requestedUri.contains(Constants.LOGIN))
       {
           if(pageName.equalsIgnoreCase(Constants.LOGIN))
           {
              User currentUser = loginService.verifyUser(createUser(email, password, userType));
              
              if(isAuthenticatedUser(currentUser))
              {
                AuthenticationHelper.login(request, currentUser);
                modelAndView = new ModelAndView(currentUser.getType());
                
                if(currentUser.getType().equals(Constants.OFFICIAL))
                {
                    return modelAndView;
                }
               
                  CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
                  List<TeacherCourse> teacherCourses = courseTeacherService.getTeacherRunningTheoryCourse(email);
                  
                  if(teacherCourses!=null)
                  {
                      modelAndView.addObject("firstExaminar",teacherCourses);
                  }
                  teacherCourses = courseTeacherService.getTeacherExaminedTheoryCourse(email);
                  if(teacherCourses!=null)
                  {
                      modelAndView.addObject("secondExaminar",teacherCourses);
                  }
                  teacherCourses = courseTeacherService.getTeacherRunningLabCourse(email);
                  if(teacherCourses!=null)
                  {
                      modelAndView.addObject("firstInstructor",teacherCourses);
                  }
                  teacherCourses = courseTeacherService.getTeacherAssistLabCourse(email);
                  if(teacherCourses!=null)
                  {
                      modelAndView.addObject("secondInstructor",teacherCourses);
                  }
               
                if(currentUser.getType().equals(Constants.COMMITTEE))
                {
                    ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                    List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                    modelAndView.addObject("examYears", examYears);
                }
                    
                return modelAndView;
              }
               else
              {
                modelAndView = new ModelAndView("loginForm");
                modelAndView.addObject("pagename",userType);
                modelAndView.addObject("loginError","Email or Password mismatch");
              }
              
           }
           else
           {
               modelAndView = new ModelAndView("loginForm");
               modelAndView.addObject("pagename",pageName);
               
           }
       }
       else 
       {
           modelAndView = new ModelAndView(AuthenticationHelper.getCurrentUser(request).getType());
       }
        
        return modelAndView;
    }
    private User createUser(String email, String password, String userType)
    {
        User user = new User();
        user.setEmail(email);
        user.setPassWord(password);
        user.setType(userType);
        
        return user;
    }
    private boolean isAuthenticatedUser(User user)
    {
        return user != null;
    }
    
}
