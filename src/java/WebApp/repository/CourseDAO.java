package WebApp.repository;

import WebApp.Model.Course;
import WebApp.Model.CourseSemester;
import java.util.List;
import javax.sql.DataSource;


public interface CourseDAO
{   
    public void save(Course course);
    
    public Course getCourse(String courseCode);
    public Course getCourseByTitle(String title);
    public List<Course> listCourses();
    
    public List<Course> getSemesterCourses(CourseSemester courseSemester);
    
    public void delete(String courseCode);
    
    public void update(String courseCode,String title);
    public List<Course> getCourseByYearAndSemester(String year,String semester);
}
