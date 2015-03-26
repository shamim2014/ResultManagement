/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.FinalExamMark;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author shamim
 */
public class FinalExamMapper implements ObjectRowMapper<FinalExamMark>{

    @Override
    public FinalExamMark mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        FinalExamMark finalExamMark = new FinalExamMark();
        
        finalExamMark.setCourseCode(resultSet.getString("course_code"));
        finalExamMark.setSession(resultSet.getString("session"));
        finalExamMark.setExamRoll(resultSet.getString("exam_roll"));
        finalExamMark.setExaminerEmail(resultSet.getString("Email"));
        finalExamMark.setQuestionOneMarks(resultSet.getDouble("questionOneMarks"));
        finalExamMark.setQuestionTwoMarks(resultSet.getDouble("questionTwoMarks"));
        finalExamMark.setQuestionThreeMarks(resultSet.getDouble("questionThreeMarks"));
        finalExamMark.setQuestionFourMarks(resultSet.getDouble("questionFourMarks"));
        finalExamMark.setQuestionFiveMarks(resultSet.getDouble("questionFiveMarks"));
        finalExamMark.setQuestionSixMarks(resultSet.getDouble("questionSixMarks"));
        finalExamMark.setTotalMarks(resultSet.getDouble("totalMarks"));
        return finalExamMark;
    }
    
}
