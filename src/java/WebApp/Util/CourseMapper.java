/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author shamim
 */
public class CourseMapper implements ObjectRowMapper<Course>
{

    @Override
    public Course mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        Course course = new Course();
        course.setCourseCode(resultSet.getString("course_code"));
        course.setTitle(resultSet.getString("title"));
        course.setCourseType(resultSet.getString("course_type"));
        course.setCredit(resultSet.getDouble("credit"));
        course.setYear(resultSet.getString("year"));
        course.setSemester(resultSet.getString("semester"));
        
        return course;
    }
    
}
