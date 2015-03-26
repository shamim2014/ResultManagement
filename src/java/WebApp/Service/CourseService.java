
package WebApp.Service;

import WebApp.Model.Course;
import WebApp.Model.CourseSemester;
import java.util.List;

public interface CourseService 
{
    public void saveCourse(Course course);
    public List<Course> getSemesterCourses(CourseSemester courseSemester);
    public List<Course> getCourseByYearAndSemester(String year, String semester);
    public Course getCourseByCourseCode(String courseCode);
    public Course verifyCourse(Course course);
    public List<Course> getAllCourses();
}
