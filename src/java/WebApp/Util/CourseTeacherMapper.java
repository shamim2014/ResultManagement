/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.CourseTeacher;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class CourseTeacherMapper implements  ObjectRowMapper<CourseTeacher>
{

    @Override
    public CourseTeacher mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        CourseTeacher courseTeacher = new CourseTeacher();
        courseTeacher.setEmail(resultSet.getString("email"));
        courseTeacher.setCourseCode(resultSet.getString("course_code"));
        courseTeacher.setSession(resultSet.getString("session"));
        return courseTeacher;
    }
    
}
