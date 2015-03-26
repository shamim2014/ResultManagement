/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.FinalExamMark;
import WebApp.Model.Student;
import WebApp.Model.User;
import WebApp.Service.FinalExamService;
import WebApp.Service.FinalExamServiceImp;
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
public class FinalExamController implements Controller
{
    private static final String COURSE_CODE = "course_code";
    private static final String SESSION = "session";
    private static final String EXAM_ROLL = "xm_roll";
    private static final String QUESTION_ONE_MARKS = "q1";
    private static final String QUESTION_TWO_MARKS = "q2";
    private static final String QUESTION_THREE_MARKS = "q3";
    private static final String QUESTION_FOUR_MARKS = "q4";
    private static final String QUESTION_FIVE_MARKS = "q5";
    private static final String QUESTION_SIX_MARKS = "q6";
    private static final String STUDENT_NO = "student_no";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ModelAndView modelAndView=null;
        FinalExamService finalExamService;
        
        String requestedUri = request.getRequestURI();
        if(requestedUri.contains(Constants.FINAL_MARKS_FORM))
        {          
            modelAndView = new ModelAndView("finalExamMarksForm");
            StudentService studentService = new StudentServiceImp();
            List<Student> students = studentService.getStudents(request.getParameter(COURSE_CODE),request.getParameter(SESSION));
            modelAndView.addObject("students", students);
        }
        else if(requestedUri.contains(Constants.INSERT_FINAL_EXAM_MARKS))
        {
            modelAndView = new ModelAndView("finalExamMarksForm");
            List<FinalExamMark> finalExamMarks = createFinalExamMark(request);
            finalExamService = new FinalExamServiceImp();
            User currentUser=AuthenticationHelper.getCurrentUser(request);
            
            if(finalExamService.hasFinalMark(request.getParameter(COURSE_CODE), request.getParameter(SESSION),currentUser.getEmail()))
            {
                modelAndView.addObject("errorMessage", "You can not insert.You have uploaded before");
                return modelAndView;
            }
            else 
            {
                 finalExamService.saveFinalMarks(finalExamMarks);
                 modelAndView.addObject("errorMessage", "Inserted");
             }
            
            modelAndView.addObject("finalExamMarks", finalExamMarks);
           
        }
       
        return modelAndView;
    }
    private List<FinalExamMark> createFinalExamMark(HttpServletRequest request)
    {
          User currentUser=AuthenticationHelper.getCurrentUser(request);
          List<FinalExamMark> finalExamMarks = new ArrayList<FinalExamMark>();
          int studentNumber = Integer.parseInt(request.getParameter(STUDENT_NO));
          
          FinalExamMark finalExamMark;
          double mark;
          for(int i=1;i<=studentNumber;i++)
          {
              mark=0;
              finalExamMark = new FinalExamMark();
              
              finalExamMark.setCourseCode(request.getParameter(COURSE_CODE));
              finalExamMark.setSession(request.getParameter(SESSION));
              finalExamMark.setExaminerEmail(currentUser.getEmail());
              
              finalExamMark.setExamRoll(request.getParameter(EXAM_ROLL+i));
              
              if(request.getParameter(QUESTION_ONE_MARKS+i)!=null&&!request.getParameter(QUESTION_ONE_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_ONE_MARKS+i));
                  finalExamMark.setQuestionOneMarks(Double.parseDouble(request.getParameter(QUESTION_ONE_MARKS+i)));
              }
              if(request.getParameter(QUESTION_TWO_MARKS+i)!=null&&!request.getParameter(QUESTION_TWO_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_TWO_MARKS+i));
                  finalExamMark.setQuestionTwoMarks(Double.parseDouble(request.getParameter(QUESTION_TWO_MARKS+i)));
              }
              if(request.getParameter(QUESTION_THREE_MARKS+i)!=null&&!request.getParameter(QUESTION_THREE_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_THREE_MARKS+i));
                  finalExamMark.setQuestionThreeMarks(Double.parseDouble(request.getParameter(QUESTION_THREE_MARKS+i)));
              }
              if(request.getParameter(QUESTION_FOUR_MARKS+i)!=null&&!request.getParameter(QUESTION_FOUR_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_FOUR_MARKS+i));
                  finalExamMark.setQuestionFourMarks(Double.parseDouble(request.getParameter(QUESTION_FOUR_MARKS+i)));
              }
              if(request.getParameter(QUESTION_FIVE_MARKS+i)!=null&&!request.getParameter(QUESTION_FIVE_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_FIVE_MARKS+i));
                  finalExamMark.setQuestionFiveMarks(Double.parseDouble(request.getParameter(QUESTION_FIVE_MARKS+i)));
              }
              if(request.getParameter(QUESTION_SIX_MARKS+i)!=null&&!request.getParameter(QUESTION_SIX_MARKS+i).isEmpty())
              {
                  mark+=Double.parseDouble(request.getParameter(QUESTION_SIX_MARKS+i));
                  finalExamMark.setQuestionSixMarks(Double.parseDouble(request.getParameter(QUESTION_SIX_MARKS+i)));
              }
              finalExamMark.setTotalMarks(mark);
              finalExamMarks.add(finalExamMark);
              mark=0;
          }
          
          return finalExamMarks;
    }
    private FinalExamMark createFinalExamMark(String courseCode,String session,String email,String examRoll,String questionOneMarks,String questionTwoMarks,String questionThreeMarks,String questionFourMarks,String questionFiveMarks,String questionSixMarks)
    {
        FinalExamMark finalExamMark = new FinalExamMark();
        double individualMark;
        double totalMarks =0;
        
        finalExamMark.setCourseCode(courseCode);
        finalExamMark.setSession(session);
        finalExamMark.setExaminerEmail(email);
        finalExamMark.setExamRoll(examRoll);
        
        if(questionOneMarks.isEmpty())
            individualMark=0;
        else
           individualMark = Double.parseDouble(questionOneMarks);
        
        totalMarks+=individualMark;
        finalExamMark.setQuestionOneMarks(individualMark);
       
        if(questionTwoMarks.isEmpty())
            individualMark=0;
        else
            individualMark = Double.parseDouble(questionTwoMarks);
        
        totalMarks+=individualMark;
        finalExamMark.setQuestionTwoMarks(individualMark);
        
        if(questionThreeMarks.isEmpty())
            individualMark=0;
        else
           individualMark = Double.parseDouble(questionThreeMarks);
        totalMarks+=individualMark;
        finalExamMark.setQuestionThreeMarks(individualMark);
        
        if(questionFourMarks.isEmpty())
            individualMark=0;
        else
           individualMark = Double.parseDouble(questionFourMarks);
        totalMarks+=individualMark;
        finalExamMark.setQuestionFourMarks(individualMark);
        
        if(questionFiveMarks.isEmpty())
            individualMark=0;
        else
           individualMark = Double.parseDouble(questionFiveMarks);
        totalMarks+=individualMark;
        finalExamMark.setQuestionFiveMarks(individualMark);
        
        if(questionSixMarks.isEmpty())
            individualMark=0;
        else
           individualMark = Double.parseDouble(questionSixMarks);
        totalMarks+=individualMark;
        finalExamMark.setQuestionSixMarks(individualMark);
        
        finalExamMark.setTotalMarks(totalMarks);
        
        return finalExamMark;
    }
}
