/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Student;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface StudentService
{
    public void saveStudent(Student student);
    public List<Student> getStudentByBatch(String batch);
    public Student verifyStudent(Student student);
    public List<Student> getStudents();
    public List<Student> getStudents(String courseCode, String session);
    public List<Student> getStudents(String year);
    public void setExamRoll(List<Student> students);
}
