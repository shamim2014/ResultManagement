/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.ExamCommittee;
import WebApp.Model.Teacher;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface TeacherDAO 
{
    public void save(Teacher teacher);
    public List<Teacher> getAllTeacher();
    public Teacher getTeacherByEmail(String email);
    public List<Teacher> getExamCommitteeTeacher(ExamCommittee examCommittee);
    public void updateDepartment(String dept,String email);
    public void updateDesignation(String designation,String email);
    public void updateName(String name,String email);
    public void updatePhone(String phonet,String email);
    public void updateEmail(String currentEmail,String email);
}
