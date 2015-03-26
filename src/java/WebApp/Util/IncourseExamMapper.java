/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.IncourseExam;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class IncourseExamMapper implements ObjectRowMapper<IncourseExam>
{

    @Override
    public IncourseExam mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        IncourseExam incourseExam = new IncourseExam();
        incourseExam.setBatch(resultSet.getString("batch"));
        incourseExam.setCourseCode(resultSet.getString("course_code"));
        incourseExam.setDept_Roll(resultSet.getString("dept_roll"));
        incourseExam.setIncourseExam1(resultSet.getDouble("incourse_exam1"));
        incourseExam.setIncourseExam2(resultSet.getDouble("incourse_exam2"));
        incourseExam.setIncourseExam3(resultSet.getDouble("incourse_exam3"));
        incourseExam.setIncourseExam4(resultSet.getDouble("incourse_exam4"));
        incourseExam.setSession(resultSet.getString("session"));
        
        return incourseExam;
    }
    
}
