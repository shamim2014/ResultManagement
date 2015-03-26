/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.Model.Course;
import WebApp.Model.CourseMarks;
import WebApp.Model.CourseSemester;
import WebApp.Model.Student;
import WebApp.Model.StudentTabulation;
import WebApp.Model.StudentTabulationHeader;
import WebApp.Model.Tabulation;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface TabulationService
{
  public List<Tabulation> createTabulation(BatchSemester batchSemester,CourseSemester courseSemester,List<Student> students, List<Course> courses,String examYear);
  public Hashtable<String,Hashtable<String,CourseMarks>> getCourseMarks(BatchSemester batchSemester,List<Student> students,List<Course> courses);
  public List<Tabulation> getTabulation(String registration,String registrationSession);
  public List<Tabulation> getTabulation(List<Student> students);
  public List<Tabulation> createTabulation(String year);
  public List<List<Tabulation>> getTabulation(String year);
  public StudentTabulationHeader getStudentTabulationHeader(String year);
  public List<StudentTabulation> getStudentTabulation(String year);
  public String createExcel(StudentTabulationHeader studentTabulationHeader, List<StudentTabulation> studentTabulations,String realPath);
}
