
package WebApp.Service;

import WebApp.Model.Course;
import WebApp.Model.CourseSemester;
import WebApp.Util.DatabaseTemplate;
import WebApp.repository.CourseDAO;
import WebApp.repository.CourseDAOImp;
import java.util.List;



public class CourseServiceImp implements CourseService
{
    private CourseDAO courseDAO;
    public CourseServiceImp()
    {
        courseDAO = new CourseDAOImp();
    }
    @Override
    public void saveCourse(Course course) 
    {
        courseDAO.save(course);
    }
    @Override
    public List<Course> getSemesterCourses(CourseSemester courseSemester)
    {
         List<Course> courses = courseDAO.getSemesterCourses(courseSemester);
         return courses;
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) 
    {
       return courseDAO.getCourse(courseCode);
    }

    @Override
    public Course verifyCourse(Course course) 
    {
        Course verifiedCourse = courseDAO.getCourse(course.getCourseCode());
        if(verifiedCourse!=null&&verifiedCourse.getCourseType().equals(course.getCourseType())&&verifiedCourse.getTitle().equals(course.getTitle()))
        {
            if(verifiedCourse.getYear().equals(course.getYear())&&verifiedCourse.getSemester().equals(course.getSemester())&&verifiedCourse.getCredit()==course.getCredit())
            {
                return verifiedCourse;
            }
        }
        
        return null;
    }

    @Override
    public List<Course> getAllCourses() 
    {
        return courseDAO.listCourses();
    }

    @Override
    public List<Course> getCourseByYearAndSemester(String year, String semester) 
    {
        List<Course> courses = courseDAO.getCourseByYearAndSemester(year, semester);
        return courses;
    }
    
}
