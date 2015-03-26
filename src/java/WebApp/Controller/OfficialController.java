/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.BatchSemester;
import WebApp.Model.Student;
import WebApp.Model.Teacher;
import WebApp.Service.BatchSemesterService;
import WebApp.Service.BatchSemesterServiceImp;
import WebApp.Service.StudentService;
import WebApp.Service.StudentServiceImp;
import WebApp.Service.TeacherService;
import WebApp.Service.TeacherServiceImp;
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
public class OfficialController implements Controller
{
    private static final String Dept_ROLL = "xm_roll";
    private static final String QUESTION_ONE_MARKS = "q1";
    private static final String QUESTION_TWO_MARKS = "q2";
    private static final String QUESTION_THREE_MARKS = "q3";
    private static final String QUESTION_FOUR_MARKS = "q4";
    private static final String QUESTION_FIVE_MARKS = "q5";
    private static final String EXAM_ROLL = "q6";
    private static final String STUDENT_NO = "student_no";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String requestedUri = request.getRequestURI();
        ModelAndView modelAndView=null;
        
        StudentService studentService = new StudentServiceImp();
        
        if(requestedUri.contains(Constants.MAKE_EXAM_COMMITTEE))
        {
            TeacherService teacherService = new TeacherServiceImp();
            List<Teacher> teachers = teacherService.getAllTeacher();
            modelAndView = new ModelAndView(Constants.MAKE_EXAM_COMMITTEE);
            modelAndView.addObject("teachers", teachers);
            return modelAndView;
        }
        else if(requestedUri.contains(Constants.BATCH_FORM))
        {
             modelAndView = new ModelAndView("batchForm");
             return modelAndView;
        }
        
        modelAndView = new ModelAndView("examRoll");
        if(requestedUri.contains("1styearexamroll"))
        {
            List<Student> students = studentService.getStudents("1st");
            if(students!=null)
                modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains("2ndyearexamroll"))
        {
            List<Student> students = studentService.getStudents("2nd");
             if(students!=null)
                modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains("3rdyearexamroll"))
        {
            List<Student> students = studentService.getStudents("3rd");
            if(students!=null)
                modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains("4thyearexamroll"))
        {
            List<Student> students = studentService.getStudents("4th");
            if(students!=null)
                modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains("InsertExamRoll"))
        {
            List<Student> students = createStudent(request);
            studentService.setExamRoll(null);
        }
        else 
            modelAndView = new ModelAndView("index");
       
        return modelAndView;
    }
    
    private List<Student> createStudent(HttpServletRequest request)
    {
        List<Student> students = new ArrayList<Student>();
        
        int studentNumber = Integer.parseInt(request.getParameter(STUDENT_NO));
       
        Student student;
        for(int i=1;i<=studentNumber;i++)
        {
              student = new Student();
              
              
              student.setDeptRoll(request.getParameter(Dept_ROLL+i));
              
              if(request.getParameter(QUESTION_ONE_MARKS+i)!=null)
              {
                  student.setRegistration(request.getParameter(QUESTION_ONE_MARKS+i));
                  
              }
              if(request.getParameter(QUESTION_TWO_MARKS+i)!=null)
              {
                  student.setRegistrationSession(request.getParameter(QUESTION_TWO_MARKS+i));
              }
              if(request.getParameter(QUESTION_THREE_MARKS+i)!=null)
              {
                  student.setName(request.getParameter(QUESTION_THREE_MARKS+i));
                          
              }
              if(request.getParameter(QUESTION_FOUR_MARKS+i)!=null)
              {
                   student.setBatch(request.getParameter(QUESTION_FOUR_MARKS+i));
              }
              if(request.getParameter(QUESTION_FIVE_MARKS+i)!=null)
              {
                  student.setEmail(request.getParameter(QUESTION_FIVE_MARKS+i));
              }
              if(request.getParameter(EXAM_ROLL+i)!=null)
              {
                  student.setExamRoll(request.getParameter(EXAM_ROLL+i));
              }
              students.add(student);
          }
          
        return students;
    }
    
}
