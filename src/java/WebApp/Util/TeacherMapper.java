/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class TeacherMapper implements ObjectRowMapper<Teacher>
{

    @Override
    public Teacher mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        Teacher teacher = new Teacher();
        teacher.setName(resultSet.getString("name"));
        teacher.setDesignation(resultSet.getString("designation"));
        teacher.setDepartment(resultSet.getString("dept_name"));
        teacher.setEmail(resultSet.getString("email"));
        teacher.setPhone(resultSet.getString("phone"));
        
        return teacher;
    }
    
}
