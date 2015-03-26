/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Course;
import WebApp.Model.CourseSemester;
import WebApp.Util.CourseMapper;
import WebApp.Util.DatabaseTemplate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shamim
 */
public class CourseDAOImp implements CourseDAO
{

    @Override
    public void save(Course course)
    {
        
        String SQL = "insert into course (course_code, title, course_type, credit,year,semester) values (?, ?, ?, ?, ?,?)";
        DatabaseTemplate.executeInsertQuery(SQL, course.getCourseCode(),course.getTitle(),course.getCourseType(),course.getCredit(),course.getYear(),course.getSemester());
    }

    @Override
    public Course getCourse(String courseCode)
    {
        String SQL = "select * from Course where course_code= ?";
        List<Course>courses = DatabaseTemplate.executeQuery(SQL, new Object[]{courseCode}, new CourseMapper());
        if(courses!=null && !courses.isEmpty())
            return courses.get(0);
        return null;
    }
    
    @Override
    public List<Course> getSemesterCourses(CourseSemester courseSemester) 
    {
        List<Course>courses = new LinkedList<Course>();
        
        for(int i=0;i<courseSemester.gettotalCourse();i++)
        {
           courses.add(getCourse(courseSemester.getCourseCode(i)));
        }
        return courses;
    }
    @Override
    public List<Course> listCourses() 
    {
        String SQL = "select * from Course";
        List<Course>courses = DatabaseTemplate.queryForObject(SQL,new CourseMapper());
        return courses;
    }

    @Override
    public void delete(String courseCode) 
    {
        String SQL ="delete from Course where course_code ='"+courseCode+"'";
        DatabaseTemplate.delete(SQL);
    }

    @Override
    public void update(String courseCode, String title) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  

    @Override
    public Course getCourseByTitle(String title)
    {
        String SQL = "select * from Course where title= ?";
        List<Course>courses = DatabaseTemplate.executeQuery(SQL, new Object[]{title}, new CourseMapper());
        if(courses!=null&&courses.size()!=0)
            return courses.get(0);
        return null;
    }

    @Override
    public List<Course> getCourseByYearAndSemester(String year, String semester) 
    {
        String SQL = "select * from Course where year= ? and semester =?";
        List<Course>courses = DatabaseTemplate.executeQuery(SQL,new Object[]{year,semester},new CourseMapper());
        return courses;
    }
}
