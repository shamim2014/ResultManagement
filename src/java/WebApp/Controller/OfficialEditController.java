/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.ExamCommittee;
import WebApp.Model.Teacher;
import WebApp.Service.ExamCommitteeService;
import WebApp.Service.ExamCommitteeServiceImp;
import WebApp.Service.TeacherService;
import WebApp.Service.TeacherServiceImp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class OfficialEditController implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String requestedUri = request.getRequestURI();
        ModelAndView modelAndView = null;
        
        if(requestedUri.contains("editStudent"))
        {
            modelAndView = new ModelAndView("editStudent");
        }
        else if(requestedUri.contains("editTeacher"))
        {
            modelAndView = new ModelAndView("editTeacher");
            if(request.getParameter("pagename")!=null && request.getParameter("pagename").equalsIgnoreCase("Insert"))
            {
                Teacher teacher = getTeacher(request);
                String email = request.getParameter("teacher_email");
                TeacherService teacherService = new TeacherServiceImp();
                teacherService.updateTeacher(teacher, email);
            }
        }
        else if(requestedUri.contains("editExamCommittee"))
        {
            modelAndView = new ModelAndView("editCommittee");
            if(request.getParameter("pagename")!=null && request.getParameter("pagename").equalsIgnoreCase("Insert"))
            {
                ExamCommittee examCommittee = getExamCommittee(request);
                ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
                TeacherService teacherService = new TeacherServiceImp();
                examCommitteeService.update(examCommittee);
                examCommittee = examCommitteeService.getExamCommitteeYear(examCommittee.getYear(), examCommittee.getSession());
                Teacher teacher = teacherService.getTeacherByEmail(examCommittee.getChairmanEmail());
                
                modelAndView.addObject("chairmanTeacher", teacher);
                teacher = teacherService.getTeacherByEmail(examCommittee.getFirstMemberEmail());
                
                modelAndView.addObject("firstTeacher", teacher);
                teacher = teacherService.getTeacherByEmail(examCommittee.getSecondMemberEmail());
                
                modelAndView.addObject("secondTeacher", teacher);
            }
        }
        else if(requestedUri.contains("editCourse"))
        {
            modelAndView = new ModelAndView("editCourse");
        }
        else if(requestedUri.contains("editCourseTeacher"))
        {
            modelAndView = new ModelAndView("editCourseTeacher");
        }
        else if(requestedUri.contains("editSemesterCourse"))
        {
            modelAndView = new ModelAndView("updateSemesterInfo");
        }
        else
        {
            modelAndView = new ModelAndView("index");
        }
        return modelAndView;
    }
    
    private Teacher getTeacher(HttpServletRequest request)
    {
        Teacher teacher = new Teacher();
        
        if(request.getParameter("email")!=null)
        {
            teacher.setEmail(request.getParameter("email"));
        }
        if(request.getParameter("phone")!=null)
        {
            teacher.setPhone(request.getParameter("phone"));
        }
        if(request.getParameter("name")!=null)
        {
            teacher.setName(request.getParameter("name"));
        }
        if(request.getParameter("designation")!=null)
        {
            teacher.setDesignation(request.getParameter("designation"));
        }
        if(request.getParameter("department")!=null)
        {
            teacher.setDepartment(request.getParameter("department"));
        }
        return teacher;
    }
    private ExamCommittee getExamCommittee(HttpServletRequest request)
    {
        ExamCommittee examCommittee = new ExamCommittee();
        
        if(request.getParameter("session")!=null)
        {
            examCommittee.setSession(request.getParameter("session"));
        }
        if(request.getParameter("year")!=null)
        {
            examCommittee.setYear(request.getParameter("year"));
        }
        if(request.getParameter("chairman_name")!=null && !request.getParameter("chairman_name").equalsIgnoreCase(""))
        {
            examCommittee.setChairmanName(request.getParameter("chairman_name"));
        }
        if(request.getParameter("chairman_id")!=null && !request.getParameter("chairman_id").equalsIgnoreCase(""))
        {
            examCommittee.setChairmanEmail(request.getParameter("chairman_id"));
        }
        if(request.getParameter("1stmem_name")!=null && !request.getParameter("1stmem_name").equalsIgnoreCase(""))
        {
            examCommittee.setFirstMemberName(request.getParameter("1stmem_name"));
        }
        if(request.getParameter("1stmem_id")!=null&& !request.getParameter("1stmem_id").equalsIgnoreCase(""))
        {
            examCommittee.setFirstMemberEmail(request.getParameter("1stmem_id"));
        }
        if(request.getParameter("2ndmem_name")!=null && !request.getParameter("2ndmem_name").equalsIgnoreCase(""))
        {
            examCommittee.setSecondMemberName(request.getParameter("2ndmem_name"));
        }
        if(request.getParameter("2ndmem_id")!=null && !request.getParameter("2ndmem_id").equalsIgnoreCase(""))
        {
            examCommittee.setSecondMemberEmail(request.getParameter("2ndmem_id"));
        }
        
        return examCommittee;
    }
    
}
