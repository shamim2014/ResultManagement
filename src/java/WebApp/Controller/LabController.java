/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import WebApp.Model.Student;
import WebApp.Model.TeacherCourse;
import WebApp.Model.User;
import WebApp.Service.CourseTeacherService;
import WebApp.Service.CourseTeacherServiceImp;
import WebApp.Service.LabService;
import WebApp.Service.LabServiceImp;
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
public class LabController implements Controller 
{
     private static final String COURSE_CODE ="course_code";
     private static final String SESSION="session";
     private static final String LAB_EXAM="lab_exam";
     private static final String LAB_EXAM_MARKS="lab_exam_marks";
     private static final String VIVA="viva";
     private static final String VIVA_MARKS="viva_marks";
     private static final String ATTENDANCE="attendance";
     private static final String ATTENDANCE_MARKS="attendance_marks";
     private static final String ASSIGNMENT ="assignment";
     private static final String ASSIGNMENT_MARKS ="assignment_marks";
     private static final String PRESENTATION="presentation";
     private static final String PRESENTATION_MARKS="presentation_marks";
     private static final String ASSESMENT="assessment";
     private static final String ASSESMENT_MARKS= "assessment_marks";
     private static final String REPORT ="report";
     private static final String REPORT_MARKS ="report_marks";
     private static final String PROJECT="project";
     private static final String PROJECT_MARKS="project_marks";
     private static final String TOTAL="total";
     private static final String TOTAL_MARKS="total_marks";
     private static final String DEPT_ROLL_ ="roll_";
     private static final String STUDENT_NO = "student_no";
     
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String requestedUri = request.getRequestURI();
        LabService labService = new LabServiceImp();
        User currentUser=AuthenticationHelper.getCurrentUser(request);
        
        ModelAndView modelAndView=new ModelAndView("message");
        if(requestedUri.contains(Constants.LAB_FORM))
        {
           modelAndView = new ModelAndView("selectLabScale");
           
        }
        else if(requestedUri.contains(Constants.LAB_SCALE))
        {
           modelAndView = new ModelAndView("insertLabFinal");
           LabMarkingScale labMarkingScale = getLabMarking(request);
           labService.saveMarkingScale(labMarkingScale);
           
           modelAndView.addObject("labMarkingScale", labMarkingScale);
           StudentService studentService = new StudentServiceImp();
            List<Student> students = studentService.getStudents(labMarkingScale.getCourseCode(),labMarkingScale.getSession());
            modelAndView.addObject("students", students);
        }
        
        else if(requestedUri.contains(Constants.INSERT_LAB_MARK))
        {
           modelAndView = new ModelAndView("insertLabFinal");
           LabMarkingScale labMarkingScale = labService.getLabMarkingScale(request.getParameter(COURSE_CODE), request.getParameter(SESSION));
           
           List<LabMark> labMarks = getLabMark(request);
           
           labService.saveLabMark(labMarks);
           
           modelAndView.addObject("labMarkingScale", labMarkingScale);
           modelAndView.addObject("labMarks", labMarks);
        }
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
    
    private List<LabMark> getLabMark(HttpServletRequest request)
    {
        List<LabMark> labMarks = new ArrayList<LabMark>();
        int studentNumber = Integer.parseInt(request.getParameter(STUDENT_NO));
        
        LabMark labMark ;
        for(int i=1;i<=studentNumber;i++)
        {
            labMark= new LabMark();
            
            labMark.setDept_Roll(request.getParameter(DEPT_ROLL_+i));
            
            if(request.getParameter(ASSIGNMENT_MARKS+i)!=null)
            {
                labMark.setAssignment(Double.parseDouble(request.getParameter(ASSIGNMENT_MARKS+1)));
            }
            if(request.getParameter(ATTENDANCE_MARKS+i)!=null)
            {
                labMark.setAttendance(Double.parseDouble(request.getParameter(ATTENDANCE_MARKS+i)));
            }
            if(request.getParameter(COURSE_CODE)!=null)
            {
                labMark.setCourseCode(request.getParameter(COURSE_CODE));
            }
            if(request.getParameter(LAB_EXAM_MARKS+i)!=null)
            {
                labMark.setLab_exam(Double.parseDouble(request.getParameter(LAB_EXAM_MARKS+i)));
            }
            if(request.getParameter(ASSESMENT_MARKS+i)!=null)
            {
                labMark.setAssessment(Double.parseDouble(request.getParameter(ASSESMENT_MARKS+i)));
            }
            if(request.getParameter(PROJECT_MARKS+i)!=null)
            {
                labMark.setProject(Double.parseDouble(request.getParameter(PROJECT_MARKS+i)));
            }
            if(request.getParameter(REPORT_MARKS+i)!=null)
            {
                labMark.setReport(Double.parseDouble(request.getParameter(REPORT_MARKS+i)));
            }
            
            if(request.getParameter(PRESENTATION_MARKS+i)!=null)
            {
                labMark.setPresentation(Double.parseDouble(request.getParameter(PRESENTATION_MARKS+i)));
            }
            if(request.getParameter(SESSION)!=null)
            {
                labMark.setSession(request.getParameter(SESSION));
            }
            
            if(request.getParameter(TOTAL_MARKS+i)!=null)
            {
                labMark.setTotalMarks(Double.parseDouble(request.getParameter(TOTAL_MARKS+i)));
            }
            if(request.getParameter(VIVA_MARKS+i)!=null)
            {
                labMark.setViva(Double.parseDouble(request.getParameter(VIVA_MARKS+i)));
            }
            
            labMarks.add(labMark);
        }
        
        return labMarks;
    }
    private LabMarkingScale getLabMarking(HttpServletRequest request)
    {
         LabMarkingScale labMarkingScale = new LabMarkingScale();
         
         labMarkingScale.setCourseCode(request.getParameter(COURSE_CODE));
         labMarkingScale.setSession(request.getParameter(SESSION));
         
         if(request.getParameter(VIVA)!=null)
         {
             labMarkingScale.setViva(Double.parseDouble(request.getParameter(VIVA_MARKS)));
         }
         if(request.getParameter(ASSESMENT)!=null)
         {
             labMarkingScale.setAssessment(Double.parseDouble(request.getParameter(ASSESMENT_MARKS)));
         }
         if(request.getParameter(ASSIGNMENT)!=null)
         {
             labMarkingScale.setAssignment(Double.parseDouble(request.getParameter(ASSIGNMENT_MARKS)));
         }
         if(request.getParameter(ATTENDANCE)!=null)
         {
             labMarkingScale.setAttendance(Double.parseDouble(request.getParameter(ATTENDANCE_MARKS)));
         }
         if(request.getParameter(LAB_EXAM)!=null)
         {
             labMarkingScale.setLab_exam(Double.parseDouble(request.getParameter(LAB_EXAM_MARKS)));
         }
         if(request.getParameter(PRESENTATION)!=null)
         {
             labMarkingScale.setPresentation(Double.parseDouble(request.getParameter(PRESENTATION_MARKS)));
         }
         if(request.getParameter(PROJECT)!=null)
         {
             labMarkingScale.setProject(Double.parseDouble(request.getParameter(PROJECT_MARKS)));
         }
         if(request.getParameter(REPORT)!=null)
         {
             labMarkingScale.setReport(Double.parseDouble(request.getParameter(REPORT_MARKS)));
         }
         if(request.getParameter(TOTAL)!=null)
         {
             labMarkingScale.setTotalMarks(Double.parseDouble(request.getParameter(TOTAL_MARKS)));
         }
         
         return labMarkingScale;
    }
    
}
