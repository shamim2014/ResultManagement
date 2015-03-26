/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.ExamCommittee;
import WebApp.Model.FinalExamMark;
import WebApp.Model.Incourse;
import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import WebApp.Model.Student;
import WebApp.Model.Teacher;
import WebApp.Model.User;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Service.ExamCommitteeService;
import WebApp.Service.ExamCommitteeServiceImp;
import WebApp.Service.FinalExamService;
import WebApp.Service.FinalExamServiceImp;
import WebApp.Service.IncourseService;
import WebApp.Service.IncourseServiceImp;
import WebApp.Service.LabService;
import WebApp.Service.LabServiceImp;
import WebApp.Service.MarkDistributionService;
import WebApp.Service.MarkDistributionServiceImp;
import WebApp.Service.StudentService;
import WebApp.Service.StudentServiceImp;
import WebApp.Service.TeacherService;
import WebApp.Service.TeacherServiceImp;
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
 * @author Mithun
 */
public class ViewController implements Controller
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
           User currentUser=AuthenticationHelper.getCurrentUser(request);
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
                modelAndView = TeacherHeader.getMenu(modelAndView, request);
                ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                 modelAndView.addObject("examYears", examYears);
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
                ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                 modelAndView.addObject("examYears", examYears);
            }
            finalExamMarks= finalExamService.gerFinalMarks(request.getParameter(COURSE_CODE), request.getParameter(SESSION),currentUser.getEmail());
            modelAndView.addObject("finalExamMarks", finalExamMarks);
        }
        else if(requestedUri.contains("viewIncourseMarks"))
        {
            String courseCode = request.getParameter(COURSE_CODE);
            String session = request.getParameter(SESSION);
            MarkDistributionService markDistributionService = new MarkDistributionServiceImp();
            
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
                ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                 modelAndView.addObject("examYears", examYears);
            }
            IncourseMarkDistribution incourseMarkDistributuion = markDistributionService.getMarkDistribution(session, courseCode);
            IncourseService incourseService = new IncourseServiceImp();
            List<Incourse> incourses =incourseService.getIncourse(courseCode, session);
            modelAndView.addObject("incourseMarkDistributuion", incourseMarkDistributuion);
            modelAndView.addObject("incourses", incourses);
            
        }
        else if(requestedUri.contains("viewExamCommittee"))
        {
            ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
            ExamCommittee examCommittee = examCommitteeService.getExamCommittee(request.getParameter("year"));
            TeacherService teacherService = new TeacherServiceImp();
             User currentUser=AuthenticationHelper.getCurrentUser(request);
             
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
                modelAndView = TeacherHeader.getMenu(modelAndView, request);
               
                List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                 modelAndView.addObject("examYears", examYears);
            }
            if(examCommittee==null)
                return modelAndView;
            
            Teacher teacher = teacherService.getTeacherByEmail(examCommittee.getChairmanEmail());
                
            modelAndView.addObject("chairmanTeacher", teacher);
            teacher = teacherService.getTeacherByEmail(examCommittee.getFirstMemberEmail());
                
            modelAndView.addObject("firstTeacher", teacher);
            teacher = teacherService.getTeacherByEmail(examCommittee.getSecondMemberEmail());
             modelAndView.addObject("secondTeacher", teacher);
            
        }
        else if(requestedUri.contains("LabMarkView"))
        {
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
                ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                List<String> examYears=examCommitteeService.getExamCommitteeYear(currentUser.getEmail());
                    
                 modelAndView.addObject("examYears", examYears);
            }
             LabService labService = new LabServiceImp();
             LabMarkingScale labMarkingScale = labService.getLabMarkingScale(request.getParameter(COURSE_CODE), request.getParameter(SESSION));
             List<LabMark> labMarks=labService.getLabMark(request.getParameter(COURSE_CODE), request.getParameter(SESSION));
             modelAndView.addObject("labMarkingScale", labMarkingScale);
             modelAndView.addObject("labMarks", labMarks);
             modelAndView.addObject("courseType", "courseType");
        }
        return modelAndView;
    }
    
    
}
