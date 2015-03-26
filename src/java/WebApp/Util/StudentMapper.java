/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class StudentMapper implements ObjectRowMapper<Student>
{

    @Override
    public Student mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        Student student = new Student();
        student.setName(resultSet.getString("name"));
        student.setDeptRoll(resultSet.getString("dept_roll"));
        student.setGender(resultSet.getString("gender"));
        student.setSession(resultSet.getString("session"));
        student.setBatch(resultSet.getString("batch"));
        student.setExamRoll(resultSet.getString("exam_roll"));
        student.setEmail(resultSet.getString("email"));
        student.setPhone(resultSet.getString("phone"));
        student.setHall(resultSet.getString("hall"));
        student.setRegistration(resultSet.getString("registration"));
        student.setRegistrationSession(resultSet.getString("regi_session"));
        
        return student;
    }
    
}
