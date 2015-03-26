/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Teacher;
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
public class TeacherInfoController implements Controller
{
    private static final String DESIGNATION ="designation";
    private static final String NAME ="teacher_name";
    private static final String DEPT_NAME="department";
    private static final String EMAIL ="email";
    private static final String PHONE ="cell_num";

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String teacherName = request.getParameter(NAME);
        String department = request.getParameter(DEPT_NAME);
        String email = request.getParameter(EMAIL);
        String phone = request.getParameter(PHONE);
        String designation = request.getParameter(DESIGNATION);
        ModelAndView modelAndView=null;
        
        TeacherService teacherService = new TeacherServiceImp();
        String requestedUri = request.getRequestURI();
        
        if(requestedUri.contains(Constants.INSERT_TEACHER_INFO))
        {
            Teacher teacher = createTeacher(teacherName,designation,department, email, phone);
            teacherService.saveTeacher(teacher);
            teacher = teacherService.getTeacherByEmail(email);
            modelAndView = new ModelAndView("TeacherForm");
            modelAndView.addObject("teacher",teacher);
        }
        
        return modelAndView;
    }
    
    private Teacher createTeacher( String name,String designation,String department, String email, String phone)
    {
        Teacher teacher = new Teacher();
        
        teacher.setDesignation(designation);
        teacher.setName(name);
        teacher.setDepartment(department);
        teacher.setEmail(email);
        teacher.setPhone(phone);
        
        return teacher;
    }
    
}
