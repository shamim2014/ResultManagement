/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Teacher;
import WebApp.repository.ExamCommitteeDAO;
import WebApp.repository.ExamCommitteeDAOImp;
import WebApp.repository.TeacherDAO;
import WebApp.repository.TeacherDAOImp;
import WebApp.repository.UserDAO;
import WebApp.repository.UserDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class TeacherServiceImp implements TeacherService
{
    private TeacherDAO teacherDAO;
    private ExamCommitteeDAO examCommitteeDAO;
    private UserDAO userDAO;
    public TeacherServiceImp()
    {
        teacherDAO = new TeacherDAOImp();
        examCommitteeDAO = new ExamCommitteeDAOImp();
        userDAO = new UserDAOImp();
    }
    @Override
    public void saveTeacher(Teacher teacher) 
    {
        teacherDAO.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() 
    {
        return teacherDAO.getAllTeacher();
    }

    @Override
    public Teacher getTeacherByEmail(String email) 
    {
        Teacher teacher = teacherDAO.getTeacherByEmail(email);
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher, String email)
    {
        if(teacher.getDepartment()!=null)
            teacherDAO.updateDepartment(teacher.getDepartment(), email);
        if(teacher.getDesignation()!=null)
           teacherDAO.updateDesignation(teacher.getDesignation(), email);
        if(teacher.getName()!=null)
            teacherDAO.updateName(teacher.getName(), email);
        if(teacher.getPhone()!=null)
            teacherDAO.updatePhone(teacher.getPhone(), email);
        if(teacher.getEmail()!=null)
        {
            teacherDAO.updateEmail(teacher.getEmail(), email);
            examCommitteeDAO.upadteCommittee(teacher.getEmail(), email);
            userDAO.updateEmail(teacher.getEmail(), email);
        }
    }
    
}
