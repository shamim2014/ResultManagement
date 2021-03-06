/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.TeacherCourse;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class TeacherCourseMapper implements ObjectRowMapper<TeacherCourse>
{

    @Override
    public TeacherCourse mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        TeacherCourse courseTeacher = new TeacherCourse();
        courseTeacher.setEmail(resultSet.getString("email"));
        courseTeacher.setName(resultSet.getString("name"));
        courseTeacher.setDepartment(resultSet.getString("dept_name"));
        courseTeacher.setDesignation(resultSet.getString("designation"));
        courseTeacher.setPhone(resultSet.getString("phone"));
        courseTeacher.setCourseCode(resultSet.getString("course_code"));
        courseTeacher.setSession(resultSet.getString("session"));
        courseTeacher.setTitle(resultSet.getString("title"));
        courseTeacher.setCredit(resultSet.getDouble("credit"));
        courseTeacher.setCourseType(resultSet.getString("course_type"));
        courseTeacher.setYear(resultSet.getString("year"));
        courseTeacher.setSemester(resultSet.getString("semester"));
        return courseTeacher;
    }
    
}
