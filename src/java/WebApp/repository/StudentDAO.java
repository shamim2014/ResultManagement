/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Student;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface StudentDAO 
{
    public void saveStudent(Student student);
    public List<Student> getStudentByYearSemesterAndSession(String year, String semester,String session);
    public List<Student> getStudentByBatch(String batch);
    public Student getStudent(String regiSession,String registration);
    public List<Student> getStudents();
    public List<Student> getStudents(String courseCode,String session);
    public void updateExamRoll(String regiSession,String registration,String examRoll);
}
