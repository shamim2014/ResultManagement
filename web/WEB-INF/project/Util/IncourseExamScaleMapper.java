/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.IncourseExamScale;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class IncourseExamScaleMapper implements ObjectRowMapper<IncourseExamScale>
{

    @Override
    public IncourseExamScale mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        IncourseExamScale incourseExamScale = new IncourseExamScale();
        
        incourseExamScale.setBatch(resultSet.getString("batch"));
        incourseExamScale.setCourseCode(resultSet.getString("course_code"));
        incourseExamScale.setIncourseExam1(resultSet.getDouble("incourse_exam1"));
        incourseExamScale.setIncourseExam2(resultSet.getDouble("incourse_exam2"));
        incourseExamScale.setIncourseExam3(resultSet.getDouble("incourse_exam3"));
        incourseExamScale.setIncourseExam4(resultSet.getDouble("incourse_exam4"));
        incourseExamScale.setSession(resultSet.getString("session"));
        incourseExamScale.setTotalExam(resultSet.getInt("totalIncourse"));
        incourseExamScale.setMarkingType(resultSet.getInt("markingType"));
        
        return incourseExamScale;
    }
    
}
