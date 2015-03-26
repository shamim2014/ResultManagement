
package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.IncourseExam;
import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;
import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Service.IncourseExamService;
import WebApp.Service.IncourseExamServiceImp;
import WebApp.Service.MarkDistributionService;
import WebApp.Service.MarkDistributionServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class MarkDistributionController implements Controller
{
    private static final String ATTENDANCE = "attendance_marks";
    private static final String PRESENTATION = "presentation_marks";
    private static final String EXAM = "exam_marks";
    private static final String VIVA = "viva_marks";
    private static final String ASSIGNMENT = "assignment_marks";
    private static final String SUDDEN_TEST = "sudden_test_marks";
    private final String COURSE_CODE ="course_code";
    private final String SESSION="session";
    private final String MARKING_TYPE="marking_type";

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String requestedUri = request.getRequestURI();
        
        ModelAndView modelAndView = null;
        
        if(requestedUri.contains(Constants.INSERT_INCOURSE_MARK_DISTIBUTION))
        {
             IncourseMarkScale incourseMarkScale = createMarkingScale(request);
             MarkDistributionService markDistributionService = new MarkDistributionServiceImp();
             IncourseExamService incourseExamService = new IncourseExamServiceImp();
             
             IncourseMarkDistribution incourseMarkDistributuion = markDistributionService.getMarkDistribution(incourseMarkScale.getSession(), incourseMarkScale.getCourseCode());
            
             modelAndView = new ModelAndView("sendIncorseFinalMarks");
             if(incourseMarkDistributuion==null)
             {
                 incourseExamService.setMarkingType(incourseMarkScale.getCourseCode(), incourseMarkScale.getSession(), Integer.parseInt(request.getParameter(MARKING_TYPE)));
                 markDistributionService.createMarkDistribution(incourseMarkScale);
                 incourseMarkDistributuion = markDistributionService.getMarkDistribution(incourseMarkScale.getSession(), incourseMarkScale.getCourseCode());
                 modelAndView.addObject("incourseMarkDistributuion", incourseMarkDistributuion);
                 List<IncourseExam> incourseExams = incourseExamService.getIncourseExam(incourseMarkScale.getCourseCode(),incourseMarkScale.getSession(),incourseMarkScale.getIncourseExam());
            
                 modelAndView.addObject("incourseExams",incourseExams);
                 modelAndView = getMenu(modelAndView, request);
                return modelAndView;
             }
             
             modelAndView.addObject("errorMessage", "You can not submitted. You submitted before");             
             
        }
        else if(requestedUri.contains(Constants.INCOURSE_MARK_DISTRIBUTION))
        {
            modelAndView = new ModelAndView("incourseMarkingScope");
            CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
            List<Course> courses = courseTeacherService.getCoursesByTeacher(AuthenticationHelper.getCurrentUser(request).getEmail());
            modelAndView.addObject("courses",courses);
            modelAndView = getMenu(modelAndView, request);
            return modelAndView;
        }
        return modelAndView;
    }
    private IncourseMarkScale createMarkingScale(HttpServletRequest request)
    {
        IncourseMarkScale incourseMarkScale = new IncourseMarkScale();
        incourseMarkScale.setCourseCode(request.getParameter(COURSE_CODE));
        incourseMarkScale.setSession(request.getParameter(SESSION));
        
        if(request.getParameter("exam")!=null)
        {
            incourseMarkScale.setIncourseExam(Double.valueOf(request.getParameter(EXAM)));
        }
        if(request.getParameter("viva")!=null)
        {
            incourseMarkScale.setViva(Double.valueOf(request.getParameter(VIVA)));
        }
        if(request.getParameter("attendance")!=null)
        {
            incourseMarkScale.setAttendance(Double.valueOf(request.getParameter(ATTENDANCE)));
        }
        if(request.getParameter("assignment")!=null)
        {
            incourseMarkScale.setAssignment(Double.valueOf(request.getParameter(ASSIGNMENT)));
        }
        if(request.getParameter("sudden_test")!=null)
        {
            incourseMarkScale.setSuddentTest(Double.valueOf(request.getParameter(SUDDEN_TEST)));
        }
        if(request.getParameter("presentation")!=null)
        {
            incourseMarkScale.setPresentation(Double.valueOf(request.getParameter(PRESENTATION)));
        }
            
        return incourseMarkScale;
    }
    
    private ModelAndView getMenu(ModelAndView modelAndView,HttpServletRequest request)
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
