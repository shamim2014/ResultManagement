/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.ExamCommittee;
import WebApp.Model.Teacher;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.TeacherMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class TeacherDAOImp implements TeacherDAO
{

    @Override
    public void save(Teacher teacher)
    {
        String SQL = "INSERT INTO Teacher (name, dept_name, email, phone,designation) VALUES (?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL, teacher.getName(),teacher.getDepartment(),teacher.getEmail(),teacher.getPhone(),teacher.getDesignation());
    }

    @Override
    public List<Teacher> getAllTeacher() 
    {
        String SQL = "SELECT * FROM Teacher";
        List<Teacher> teachers = DatabaseTemplate.queryForObject(SQL, new TeacherMapper());
        return teachers;
    }

    @Override
    public Teacher getTeacherByEmail(String email) 
    {
        String SQL = "SELECT * FROM Teacher WHERE email='"+email+"';";
        List<Teacher> teachers = DatabaseTemplate.queryForObject(SQL,new TeacherMapper());
        if(teachers!=null && !teachers.isEmpty())
            return teachers.get(0);
        else
            return null;
    }

    @Override
    public List<Teacher> getExamCommitteeTeacher(ExamCommittee examCommittee) 
    {
        String SQL = "SELECT * FROM Teacher WHERE email=? OR email=? OR email=?";
        List<Teacher> teachers = DatabaseTemplate.executeQuery(SQL, new Object[]{examCommittee.getChairmanEmail(),examCommittee.getFirstMemberEmail(),examCommittee.getSecondMemberEmail()}, new TeacherMapper());
        return teachers;
    }

    @Override
    public void updateDepartment(String dept, String email)
    {
        String SQL = "UPDATE Teacher SET dept_name=? WHERE email=?;";
        DatabaseTemplate.executeInsertQuery(SQL, dept,email);
    }

    @Override
    public void updateDesignation(String designation, String email) 
    {
        String SQL = "UPDATE Teacher SET designation=? WHERE email=?;";
        DatabaseTemplate.executeInsertQuery(SQL, designation,email);
    }

    @Override
    public void updateName(String name, String email) 
    {
       String SQL = "UPDATE Teacher SET name=? WHERE email=?;";
        DatabaseTemplate.executeInsertQuery(SQL, name,email);
    }

    @Override
    public void updatePhone(String phone, String email) 
    {
        String SQL = "UPDATE Teacher SET phone=? WHERE email=?;";
        DatabaseTemplate.executeInsertQuery(SQL, phone,email);
    }

    @Override
    public void updateEmail(String currentEmail, String email) 
    {
       String SQL = "UPDATE Teacher SET email=? WHERE email=?;";
       DatabaseTemplate.executeInsertQuery(SQL, currentEmail,email);
    }
    
}
