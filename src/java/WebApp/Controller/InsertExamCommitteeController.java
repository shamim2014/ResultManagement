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
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class InsertExamCommitteeController implements Controller
{
    private static final String SESSION ="session";
    private static final String YEAR ="year";
    private static final String CHAIRMAN_NAME ="chairman_name";
    private static final String CHAIRMAN_EMAIL="chairman_email";
    private static final String FIRST_MEMBER_NAME="1stmem_name";
    private static final String FIRST_MEMBER_EMAIL="1stmem_email";
    private static final String SECOND_MEMBER_NAME="2ndmem_name";
    private static final String SECOND_MEMBER_EMAIL="2ndmem_email";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String session = request.getParameter(SESSION);
        String year = request.getParameter(YEAR);
        String chairmanName = request.getParameter(CHAIRMAN_NAME);
        String chairmanEmail =request.getParameter(CHAIRMAN_EMAIL);
        String firstMemberName = request.getParameter(FIRST_MEMBER_NAME);
        String firstMemberEmail = request.getParameter(FIRST_MEMBER_EMAIL);
        String secondMemberName = request.getParameter(SECOND_MEMBER_NAME);
        String secondMemberEmail = request.getParameter(SECOND_MEMBER_EMAIL);
        
        ExamCommitteeService examCommitteeService = new ExamCommitteeServiceImp();
        ExamCommittee examCommittee = createExamCommittee(chairmanName, chairmanEmail, firstMemberName, firstMemberEmail, secondMemberName, secondMemberEmail, session, year);
        examCommitteeService.saveExamCommittee(examCommittee);
        
        List<Teacher> teachers = examCommitteeService.getExamCommitteeTeacher(examCommittee);
        
        ModelAndView modelAndView = new ModelAndView(Constants.MAKE_EXAM_COMMITTEE);
        modelAndView.addObject("examCommittee", examCommittee);
        modelAndView.addObject("teachers", teachers);
        
        return modelAndView;
    }
    private ExamCommittee createExamCommittee(String chairmanName,String chairmanEmail,String firstMemberName,String firstMemberEmail,String secondMemberName,String secondMemberEmail,String session,String year)
    {
        ExamCommittee examCommittee = new ExamCommittee();
        
        examCommittee.setChairmanName(chairmanName);
        examCommittee.setChairmanEmail(chairmanEmail);
        examCommittee.setFirstMemberName(firstMemberName);
        examCommittee.setFirstMemberEmail(firstMemberEmail);
        examCommittee.setSecondMemberName(secondMemberName);
        examCommittee.setSecondMemberEmail(secondMemberEmail);
        examCommittee.setSession(session);
        examCommittee.setYear(year);
        
        return examCommittee;
    }
   
    
}
