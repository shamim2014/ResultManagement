/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Student;
import WebApp.Service.StudentService;
import WebApp.Service.StudentServiceImp;
import WebApp.Util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class StudentInfoController implements Controller
{
    private static final String STUDENT_NAME ="student_name";
    private static final String DEPT_ROLL="roll";
    private static final String CURRENT_SESSION = "current_session";
    private static final String GENDER = "sex";
    private static final String BATCH = "batch";
    private static final String EMAIL ="email";
    private static final String PHONE ="phone";
    private static final String REGI_SESSION = "regi_session";
    private static final String REGISTRATION = "registration";
    private static final String HALL ="hall";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
        
        ModelAndView modelAndView = null;
        
        StudentService studentService = new StudentServiceImp();
        String requestedUri = request.getRequestURI();
        if(requestedUri.contains(Constants.INSERT_STUDENT_INFO))
        {
            String studentName = request.getParameter(STUDENT_NAME);
            String roll = request.getParameter(DEPT_ROLL);
            String gender = request.getParameter(GENDER);
            String currentSession = request.getParameter(CURRENT_SESSION);
            String batch = request.getParameter(BATCH);
            String email = request.getParameter(EMAIL);
            String phone = request.getParameter(PHONE);
            String registration = request.getParameter(REGISTRATION);
            String regiSession = request.getParameter(REGI_SESSION);
            String hall =request.getParameter(HALL);
            Student student = createStudent(studentName, roll, gender, currentSession, batch, email, phone,regiSession,registration,hall);
            studentService.saveStudent(student);
            student = studentService.verifyStudent(student);
            modelAndView = new ModelAndView("studentForm");
            
            if(student!=null)
            {
                modelAndView.addObject("errorMessage","successfully inserted student information");
                modelAndView.addObject("student",student);
            }
            else
            {
                modelAndView.addObject("errorMessage","Information does not inserted!");
            }
            
        }
        return modelAndView;
    }
    private Student createStudent(String studentName,String roll,String gender,String currentSession,String batch,String email,String phone,String regiSession,String registration,String hall)
    {
        Student student = new Student();
        
        student.setName(studentName);
        student.setDeptRoll(roll);
        student.setGender(gender);
        student.setSession(currentSession);
        student.setBatch(batch);
        student.setEmail(email);
        student.setPhone(phone);
        student.setRegistration(registration);
        student.setRegistrationSession(regiSession);
        student.setHall(hall);
        
        return student;
    }
    
}
