/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Incourse;
import WebApp.Model.IncourseMarkDistribution;
import WebApp.Service.IncourseService;
import WebApp.Service.IncourseServiceImp;
import WebApp.Service.MarkDistributionService;
import WebApp.Service.MarkDistributionServiceImp;
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
public class IncourseController implements Controller
{
    private static final String COURSE_CODE = "course_code";
    private static final String SESSION = "session";
    private static final String DEPT_ROLL="dept_roll";
    private static final String INCOURSE_FINAL ="mark_final";
    private static final String DEPT_ROLL_ ="roll_";
    private static final String EXAM_MARKS_1="exam1_marks_";
    private static final String EXAM_MARKS_2="exam2_marks_";
    private static final String EXAM_MARKS_3="exam3_marks_";
    private static final String EXAM_MARKS_4="exam4_marks_";
    private static final String EXAM_MARKS="exam_marks_";
    private static final String ASSIGNMENT="assignment_";
    private static final String SUDDENT="suddent_";
    private static final String PRESENTATION="presentation_";
    private static final String ATTENDANCE="attendance_";
    private static final String VIVA="viva_";
    private static final String TOTAL_MARKS="total_marks_";
    private static final String STUDENT_NO = "student_no";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ModelAndView modelAndView=null;
        
        String requestedUri = request.getRequestURI();
        
        if(requestedUri.contains(Constants.INCOURSE_FINAL_MARKS_FORM))
        {
            modelAndView = new ModelAndView("insertEachIncourseMarks");
        }
        else if(requestedUri.contains(Constants.INSERT_INCOURSE_FINAL))
        {
            String courseCode = request.getParameter(COURSE_CODE);
            String session = request.getParameter(SESSION);
            String deptRoll = request.getParameter(DEPT_ROLL);
            String incourseFinal = request.getParameter(INCOURSE_FINAL);
            
            IncourseService incourseService = new IncourseServiceImp();
            incourseService.saveFinal(createIncourse(courseCode, session, deptRoll, incourseFinal));
            
            modelAndView = new ModelAndView("insertEachIncourseMarks");
            modelAndView.addObject("message","successfully inserted incourse marks information");
        }
        else if(requestedUri.contains(Constants.INSERT_INCOURSE_TOTAL))
        {
            String courseCode = request.getParameter(COURSE_CODE);
            String session = request.getParameter(SESSION);
            
            MarkDistributionService markDistributionService = new MarkDistributionServiceImp();
             
            IncourseMarkDistribution incourseMarkDistributuion = markDistributionService.getMarkDistribution(session, courseCode);
            IncourseService incourseService = new IncourseServiceImp();
            
            modelAndView = new ModelAndView("sendIncorseFinalMarks");
            modelAndView.addObject("incourseMarkDistributuion", incourseMarkDistributuion);
            List<Incourse> incourses = createIncourse(request);
            if(request.getParameter("update")!=null&& !request.getParameter("update").isEmpty())
                 incourseService.update(incourses);
            else
                incourseService.save(incourses);
            
            modelAndView.addObject("incourses", incourses);
        }
        
        
        return modelAndView;
    }
    private Incourse createIncourse(String courseCode,String session,String deptRoll,String incourseFinal)
    {
        Incourse incourse = new Incourse();
        
        incourse.setCourseCode(courseCode);
        incourse.setSession(session);
        incourse.setDept_Roll(deptRoll);
        incourse.setTotalObtainMarks(Double.parseDouble(incourseFinal));
        
        return incourse;
    }
    private List<Incourse> createIncourse(HttpServletRequest request)
    {
        List<Incourse> incourses = new ArrayList<Incourse>();
        int studentNumber = Integer.parseInt(request.getParameter(STUDENT_NO));
        
        Incourse incourse ;
        for(int i=1;i<=studentNumber;i++)
        {
            incourse= new Incourse();
            
            incourse.setDept_Roll(request.getParameter(DEPT_ROLL_+i));
            
            if(request.getParameter(ASSIGNMENT+i)!=null)
            {
                incourse.setAssignment(Double.parseDouble(request.getParameter(ASSIGNMENT+1)));
            }
            if(request.getParameter(ATTENDANCE+i)!=null)
            {
                incourse.setAttendance(Double.parseDouble(request.getParameter(ATTENDANCE+i)));
            }
            if(request.getParameter(COURSE_CODE)!=null)
            {
                incourse.setCourseCode(request.getParameter(COURSE_CODE));
            }
            if(request.getParameter(EXAM_MARKS+i)!=null)
            {
                incourse.setIncourseExam(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
            }
            if(request.getParameter(EXAM_MARKS_1+i)!=null)
            {
                incourse.setIncourseExam1(Double.parseDouble(request.getParameter(EXAM_MARKS_1+i)));
            }
            if(request.getParameter(EXAM_MARKS_2+i)!=null)
            {
                incourse.setIncourseExam2(Double.parseDouble(request.getParameter(EXAM_MARKS_2+i)));
            }
            if(request.getParameter(EXAM_MARKS_3+i)!=null)
            {
                incourse.setIncourseExam3(Double.parseDouble(request.getParameter(EXAM_MARKS_3+i)));
            }
            if(request.getParameter(EXAM_MARKS_4+i)!=null)
            {
                incourse.setIncourseExam4(Double.parseDouble(request.getParameter(EXAM_MARKS_4+i)));
            }
            if(request.getParameter(EXAM_MARKS+i)!=null)
            {
                incourse.setIncourseFinal(Double.parseDouble(request.getParameter(EXAM_MARKS+i)));
            }
            if(request.getParameter(PRESENTATION+i)!=null)
            {
                incourse.setPresentation(Double.parseDouble(request.getParameter(PRESENTATION+i)));
            }
            if(request.getParameter(SESSION)!=null)
            {
                incourse.setSession(request.getParameter(SESSION));
            }
            if(request.getParameter(SUDDENT+i)!=null)
            {
                incourse.setSuddentTest(Double.parseDouble(request.getParameter(SUDDENT+i)));
            }
            if(request.getParameter(TOTAL_MARKS+i)!=null)
            {
                incourse.setTotalObtainMarks(Double.parseDouble(request.getParameter(TOTAL_MARKS+i)));
            }
            if(request.getParameter(VIVA+i)!=null)
            {
                incourse.setViva(Double.parseDouble(request.getParameter(VIVA+i)));
            }
            
            incourses.add(incourse);
        }
        
        return incourses;
    }
    
}
