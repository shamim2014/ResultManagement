/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.FinalExamMark;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.FinalExamMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class FinalExamDAOImp implements FinalExamDAO
{

    @Override
    public void save(FinalExamMark finalExamMark) 
    {
        String SQL = "insert into FinalExamMarks (course_code,session,exam_roll,Email,questionOneMarks,questionTwoMarks,questionThreeMarks,questionFourMarks,questionFiveMarks,questionSixMarks,totalMarks) values (?,?,?,?,?,?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,finalExamMark.getCourseCode(),finalExamMark.getSession(),finalExamMark.getExamRoll(),finalExamMark.getExaminerEmail(),finalExamMark.getQuestionOneMarks(),finalExamMark.getQuestionTwoMarks(),finalExamMark.getQuestionThreeMarks(),finalExamMark.getQuestionFourMarks(),finalExamMark.getQuestionFiveMarks(),finalExamMark.getQuestionSixMarks(),finalExamMark.getTotalMarks());
    }

    @Override
    public List<FinalExamMark> getFinalMarks(String courseCode, String session,String email) 
    {
        String SQL = "select * from FinalExamMarks where course_code=? and session=? and Email=?;";
        List<FinalExamMark> finalExamMarks=DatabaseTemplate.executeQuery(SQL, new Object[]{courseCode,session,email}, new FinalExamMapper());
        if(finalExamMarks!=null && !finalExamMarks.isEmpty())
            return finalExamMarks;
        return null;
    }

    @Override
    public boolean hasFinalMarks(String courseCode, String session,String email) 
    {
        String SQL = "select * from FinalExamMarks where course_code=? and session=? and Email=?;";
        List<FinalExamMark> finalExamMarks=DatabaseTemplate.executeQuery(SQL, new Object[]{courseCode,session,email}, new FinalExamMapper());
        if(finalExamMarks!=null && !finalExamMarks.isEmpty())
            return true;
        return false;
    }
    
  
}
