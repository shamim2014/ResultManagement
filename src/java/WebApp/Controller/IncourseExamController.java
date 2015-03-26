/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.IncourseExam;
import WebApp.Model.IncourseExamScale;
import WebApp.Model.Student;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Service.IncourseExamService;
import WebApp.Service.IncourseExamServiceImp;
import WebApp.Service.StudentService;
import WebApp.Service.StudentServiceImp;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class IncourseExamController implements Controller
{
    private static final String COURSE_CODE = "course_code";
    private static final String SESSION = "session";
    private static final String INCOURSE_NUMBER = "marking_type";
    private static final String INCOURSE_SCALE = "total_marks";
    private static final String DEPT_ROLL ="roll_";
    private static final String EXAM_MARKS="exam_marks_";
    private static final String STUDENT_NO = "student_no";
    private static final String UPDATE="update";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String courseCode = request.getParameter(COURSE_CODE);
        String session = request.getParameter(SESSION);
        
        CourseTeacherService courseTeacherService = new CourseTeacherServiceImp();
        User currentUser=AuthenticationHelper.getCurrentUser(request);
        ModelAndView modelAndView=null;
        String requestedUri = request.getRequestURI();
        
        if(requestedUri.contains(Constants.INCOURSE_EXAM_FORM))
        {
            modelAndView = new ModelAndView("insertEachIncourseMarks");
            modelAndView=courseTeacherService.getCourse(modelAndView, currentUser);
            StudentService studentService = new StudentServiceImp();
            List<Student> students = studentService.getStudents(courseCode,session);
            modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains(Constants.INCOURSE_EXAM_MARK))
        {
            String incourseNumber = request.getParameter(INCOURSE_NUMBER);
            String incourseScale  = request.getParameter(INCOURSE_SCALE);
            int studentNumber = Integer.parseInt(request.getParameter(STUDENT_NO));
            
            modelAndView = new ModelAndView("insertEachIncourseMarks");
            modelAndView=courseTeacherService.getCourse(modelAndView, currentUser);
            
            IncourseExamScale incourseExamScale = getIncourseExamScale(courseCode,session,incourseNumber,incourseScale);
            
            List<IncourseExam> incourseExams = getIncourseExam(courseCode, session, studentNumber, request);
            
            IncourseExamService incourseExamService = new IncourseExamServiceImp();
            incourseExamService.saveIncourseExam(incourseExams, incourseExamScale);
            
            modelAndView.addObject("incourseExamScale", incourseExamScale);
            modelAndView.addObject("incourseExams", incourseExams);
  
        }
        
        
        
        return modelAndView;    
    }
    private IncourseExamScale getIncourseExamScale(String courseCode,String session,String incourseNumber,String incourseScale)
    {
        IncourseExamScale incourseExamScale = new IncourseExamScale();
        incourseExamScale.setCourseCode(courseCode);
        incourseExamScale.setSession(session);
        
        if(incourseNumber.equals("1"))
        {
            incourseExamScale.setIncourseExam1(Double.parseDouble(incourseScale));
            incourseExamScale.setIncourseExam2(0);
            incourseExamScale.setIncourseExam3(0);
            incourseExamScale.setIncourseExam4(0);
            incourseExamScale.setTotalExam(1);
        }
        else if(incourseNumber.equals("2"))
        {
            incourseExamScale.setIncourseExam2(Double.parseDouble(incourseScale));
            incourseExamScale.setIncourseExam1(0);
            incourseExamScale.setIncourseExam3(0);
            incourseExamScale.setIncourseExam4(0);
            incourseExamScale.setTotalExam(2);
        }
        else if(incourseNumber.equals("3"))
        {
            incourseExamScale.setIncourseExam1(0);
            incourseExamScale.setIncourseExam3(Double.parseDouble(incourseScale));
            incourseExamScale.setIncourseExam2(0);
            incourseExamScale.setIncourseExam4(0);
            incourseExamScale.setTotalExam(3);
        }
        else if(incourseNumber.equals("4"))
        {
            incourseExamScale.setIncourseExam1(0);
            incourseExamScale.setIncourseExam2(0);
            incourseExamScale.setIncourseExam3(0);
            incourseExamScale.setIncourseExam4(Double.parseDouble(incourseScale));
            incourseExamScale.setTotalExam(4);
        }
             
        return incourseExamScale;
    }
    private List<IncourseExam> getIncourseExam(String courseCode,String session,int studentNumber,HttpServletRequest request)
    {
        List<IncourseExam> incourseExams = new ArrayList<IncourseExam>();
        IncourseExam incourseExam;
        String incourseNumber = request.getParameter(INCOURSE_NUMBER);
        
        for(int i=1;i<=studentNumber;i++)
        {
            incourseExam= new IncourseExam();
            incourseExam.setCourseCode(courseCode);
            incourseExam.setSession(session);
            incourseExam.setDept_Roll(request.getParameter(DEPT_ROLL+i));
            
             if(incourseNumber.equals("1"))
            {
                incourseExam.setIncourseExam1(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
                incourseExam.setIncourseExam2(0);
                incourseExam.setIncourseExam3(0);
                incourseExam.setIncourseExam4(0);
            }
            else if(incourseNumber.equals("2"))
            {
                incourseExam.setIncourseExam1(0);
                incourseExam.setIncourseExam2(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
                incourseExam.setIncourseExam3(0);
                incourseExam.setIncourseExam4(0);
            }
            else if(incourseNumber.equals("3"))
            {
                incourseExam.setIncourseExam1(0);
                incourseExam.setIncourseExam2(0);
                incourseExam.setIncourseExam3(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
                incourseExam.setIncourseExam4(0);
            }
            else if(incourseNumber.equals("4"))
            {
                incourseExam.setIncourseExam1(0);
                incourseExam.setIncourseExam2(0);
                incourseExam.setIncourseExam3(0);
                incourseExam.setIncourseExam4(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
            }
            incourseExams.add(incourseExam);
        }
        if(incourseExams.isEmpty())
            return null;
        
        return incourseExams;
    }
}
