/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.CourseMarks;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class CourseMarkMapper implements ObjectRowMapper<CourseMarks>
{
    @Override
    public CourseMarks mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        CourseMarks courseMarks = new CourseMarks();
        
        courseMarks.setHall(resultSet.getString("hall"));
        courseMarks.setRegistration(resultSet.getString("registration"));
        courseMarks.setRegistrationSession(resultSet.getString("regi_session"));
        courseMarks.setYear(resultSet.getString("year"));
        courseMarks.setSemester(resultSet.getString("semester"));
        courseMarks.setCourseCode(resultSet.getString("course_code"));
        courseMarks.setSession(resultSet.getString("session"));
        courseMarks.setDept_Roll(resultSet.getString("dept_roll"));
        courseMarks.setExamRoll(resultSet.getString("exam_roll"));
        courseMarks.setIncourseMarks(resultSet.getDouble("incourseMarks"));
        courseMarks.setFinalMarks(resultSet.getDouble("finalMarks"));
    
        return courseMarks;
    }   
}
