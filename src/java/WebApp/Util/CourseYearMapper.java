/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.CourseYear;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class CourseYearMapper implements ObjectRowMapper<CourseYear>
{

    @Override
    public CourseYear mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        CourseYear courseYear = new CourseYear();
        courseYear.setYear(resultSet.getString("year"));
        courseYear.setSemester(resultSet.getString("semester"));
        courseYear.setCourseCode(resultSet.getString("course_code"));
        
        return courseYear;
    }
    
}
