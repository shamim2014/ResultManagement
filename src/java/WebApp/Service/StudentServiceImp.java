/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.Model.Student;
import WebApp.repository.BatchSemesterDAO;
import WebApp.repository.BatchSemesterDAOImp;
import WebApp.repository.StudentDAO;
import WebApp.repository.StudentDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class StudentServiceImp implements StudentService
{
    private StudentDAO studentDAO;
    private BatchSemesterDAO batchSemesterDAO;
    public StudentServiceImp()
    {
        studentDAO = new StudentDAOImp();
        batchSemesterDAO = new BatchSemesterDAOImp();
    }

    @Override
    public void saveStudent(Student student) 
    {
        studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> getStudentByBatch(String batch) 
    {
        List<Student> students = studentDAO.getStudentByBatch(batch);
        return students;
    }

    @Override
    public Student verifyStudent(Student student) 
    {
        Student currentStudent = studentDAO.getStudent(student.getRegistrationSession(),student.getRegistration());
        if(currentStudent!=null)
        {
            if(!currentStudent.getBatch().equals(student.getBatch())||!currentStudent.getDeptRoll().equals(student.getDeptRoll()))
            {
                return null;
            }
            else if(!currentStudent.getEmail().equals(student.getEmail())||!currentStudent.getGender().equals(student.getGender()))
            {
                return null;
            }
            else if(currentStudent.getExamRoll()!=null&&!currentStudent.getExamRoll().equals(student.getExamRoll()))
            {
                return null;
            }
            else if(!currentStudent.getHall().equals(student.getHall())||!currentStudent.getName().equals(student.getName()))
            {
                return null;
            }
            else if(!currentStudent.getPhone().equals(student.getPhone())||!currentStudent.getSession().equals(student.getSession()))
            {
                return null;
            }
            else if(!currentStudent.getRegistration().equals(student.getRegistration())||!currentStudent.getRegistrationSession().equals(student.getRegistrationSession()))
            {
                return null;
            }
        }
        return currentStudent;
    }

    @Override
    public List<Student> getStudents() 
    {
        List<Student> students = studentDAO.getStudents();
        return students;
    }

    @Override
    public List<Student> getStudents(String courseCode, String session)
    {
        List<Student> students = studentDAO.getStudents(courseCode,session);
        return students;
    }

    @Override
    public List<Student> getStudents(String year)
    {
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        List<Student> students = studentDAO.getStudentByBatch(batchSemester.getBatch());
        if(students!=null && !students.isEmpty())
            return students;
        return null;
    }

    @Override
    public void setExamRoll(List<Student> students)
    {
       for(Student student : students)
       {
          studentDAO.updateExamRoll(student.getRegistrationSession(), student.getRegistration(), student.getExamRoll());
       }
    }
    
}
