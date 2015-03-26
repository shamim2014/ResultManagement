/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.CourseSemester;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class CourseSemesterMapper implements ObjectRowMapper<CourseSemester>
{

    @Override
    public CourseSemester mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        CourseSemester courseSemester = new CourseSemester();
        
        courseSemester.setYear(resultSet.getString("year"));
        courseSemester.setSemester(resultSet.getString("semester"));
        courseSemester.setCourseCode(resultSet.getString("course_code1"));
        courseSemester.setCourseCode(resultSet.getString("course_code2"));
        courseSemester.setCourseCode(resultSet.getString("course_code3"));
        courseSemester.setCourseCode(resultSet.getString("course_code4"));
        courseSemester.setCourseCode(resultSet.getString("course_code5"));
        courseSemester.setCourseCode(resultSet.getString("course_code6"));
        courseSemester.setCourseCode(resultSet.getString("course_code7"));
        courseSemester.setCourseCode(resultSet.getString("course_code8"));
        courseSemester.setCourseCode(resultSet.getString("course_code9"));
        courseSemester.setCourseCode(resultSet.getString("course_code10"));
        courseSemester.setCourseCode(resultSet.getString("course_code11"));
        
        return courseSemester;
    }
    
}
