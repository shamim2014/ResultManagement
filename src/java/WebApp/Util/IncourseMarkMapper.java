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
public class IncourseMarkMapper implements ObjectRowMapper<Incourse>
{

    @Override
    public Incourse mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        Incourse incourse = new Incourse();
        
        incourse.setAssignment(resultSet.getDouble("assignment"));
        incourse.setAttendance(resultSet.getDouble("attendance"));
        incourse.setBatch(resultSet.getString("batch"));
        incourse.setCourseCode(resultSet.getString("course_code"));
        incourse.setDept_Roll(resultSet.getString("dept_roll"));
        incourse.setIncourseExam(resultSet.getDouble("incourse_exam"));
        incourse.setIncourseExam1(resultSet.getDouble("incourse_exam1"));
        incourse.setIncourseExam2(resultSet.getDouble("incourse_exam2"));
        incourse.setIncourseExam3(resultSet.getDouble("incourse_exam3"));
        incourse.setIncourseExam4(resultSet.getDouble("incourse_exam4"));
        incourse.setPresentation(resultSet.getDouble("presentation"));
        incourse.setSession(resultSet.getString("session"));
        incourse.setSuddentTest(resultSet.getDouble("suddent_test"));
        incourse.setTotalObtainMarks(resultSet.getDouble("totalMarks"));
        incourse.setViva(resultSet.getDouble("viva"));
        return incourse;
    }
    
}
