/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.Incourse;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class IncourseMapper implements ObjectRowMapper<Incourse>
{
    @Override
    public Incourse mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        Incourse incourse = new Incourse();
        
        incourse.setDept_Roll(resultSet.getString("dept_roll"));
        incourse.setSession(resultSet.getString("session"));
        incourse.setCourseCode(resultSet.getString("course_code"));
        incourse.setIncourseExam(resultSet.getDouble("incourse_exam"));
        incourse.setViva(resultSet.getDouble("viva"));
        incourse.setAttendance(resultSet.getDouble("attendance"));
        incourse.setAssignment(resultSet.getDouble("assignment"));
        incourse.setPresentation(resultSet.getDouble("presentation"));
        incourse.setSuddentTest(resultSet.getDouble("suddent_test"));
        incourse.setTotalObtainMarks(resultSet.getDouble("totalMarks"));
        
        return incourse;
    }
    
}
