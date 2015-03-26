/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Student;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.StudentMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class StudentDAOImp implements StudentDAO
{

    @Override
    public void saveStudent(Student student) 
    {
        String SQL = "INSERT INTO Student (name,dept_roll,session,gender,batch,email,phone,regi_session,registration,hall) VALUES (?,?,?,?,?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,student.getName(),student.getDeptRoll(),student.getSession(),student.getGender(),student.getBatch(),student.getEmail(),student.getPhone(),student.getRegistrationSession(),student.getRegistration(),student.getHall());
    }

    @Override
    public List<Student> getStudentByYearSemesterAndSession(String year, String semester,String session) 
    {
        String SQL = "select * from Student where year= ? and semester = ? and session = ?";
        List<Student> students = DatabaseTemplate.executeQuery(SQL, new Object[]{year,semester,session},new StudentMapper());
        
        return  students;
    }

    @Override
    public List<Student> getStudentByBatch(String batch) 
    {
        String SQL = "select * from Student where batch= ? order by exam_roll;";
        List<Student> students = DatabaseTemplate.executeQuery(SQL, new Object[]{batch},new StudentMapper());
        
        return  students;
    }

    @Override
    public Student getStudent(String regiSession, String registration) 
    {
        String SQL = "select * from Student where regi_session= ? and registration = ?";
        List<Student> students = DatabaseTemplate.executeQuery(SQL, new Object[]{regiSession,registration},new StudentMapper());
        if(students!=null && students.size()!=0)
        {
            return students.get(0);
        }
        return null;      
    }

    @Override
    public List<Student> getStudents() 
    {
        String SQL = "select * from Student order by batch";
        List<Student> students = DatabaseTemplate.queryForObject(SQL,new StudentMapper());
        if(students!=null && students.size()!=0)
        {
            return students;
        }
        return null;    
    }

    @Override
    public List<Student> getStudents(String courseCode, String session) 
    {
        String SQL ="SELECT * FROM student WHERE batch=(SELECT batch FROM course NATURAL JOIN batchsemester WHERE course_code =? AND current_session =?)";
        List<Student> students = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session}, new StudentMapper());
        
        if(students!=null && !students.isEmpty())
        {
            return students;
        }
       return null;
    }

    @Override
    public void updateExamRoll(String regiSession, String registration,String examRoll)
    {
        String SQL="UPDATE student SET exam_roll=? WHERE regi_session= ? and registration = ?";
        DatabaseTemplate.executeInsertQuery(SQL, examRoll,regiSession,registration);
        
    }
    
}
