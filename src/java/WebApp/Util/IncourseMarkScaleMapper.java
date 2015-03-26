/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.IncourseMarkScale;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class IncourseMarkScaleMapper implements ObjectRowMapper<IncourseMarkScale>
{

    @Override
    public IncourseMarkScale mapRowToObject(ResultSet resultSet) throws SQLException
    {
        IncourseMarkScale incourseMarkScale = new IncourseMarkScale();
       
        incourseMarkScale.setSession(resultSet.getString("session"));
        incourseMarkScale.setCourseCode(resultSet.getString("course_code"));
        incourseMarkScale.setAssignment(Double.parseDouble(resultSet.getString("assignment")));
        incourseMarkScale.setAttendance(Double.parseDouble(resultSet.getString("attendance")));
        incourseMarkScale.setIncourseExam(Double.parseDouble(resultSet.getString("incourse_exam")));
        incourseMarkScale.setPresentation(Double.parseDouble(resultSet.getString("presentation")));
        incourseMarkScale.setSuddentTest(Double.parseDouble(resultSet.getString("suddent_test")));
        incourseMarkScale.setTotalMarks(Double.parseDouble(resultSet.getString("totalMarks")));
        incourseMarkScale.setViva(Double.parseDouble(resultSet.getString("viva")));
       
        return incourseMarkScale;
    }
    
}
