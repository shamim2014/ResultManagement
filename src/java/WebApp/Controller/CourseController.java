/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class CourseController implements Controller
{
    private static final String COURSE_NAME = "course_name";
    private static final String COURSE_CODE = "course_code";
    private static final String COURSE_YEAR = "course_year";
    private static final String COURSE_SEMESTER = "course_semester";
    private static final String COURSE_CREDIT = "course_credit";
    private static final String COURSE_TYPE="course_type";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String courseName = request.getParameter(COURSE_NAME);
        String courseCode = request.getParameter(COURSE_CODE);
        String courseYear = request.getParameter(COURSE_YEAR);
        String courseSemester = request.getParameter(COURSE_SEMESTER);
        String courseCredit = request.getParameter(COURSE_CREDIT);
        String courseType = request.getParameter(COURSE_TYPE);
        
        ModelAndView modelAndView=null;
        
        CourseService courseService = new CourseServiceImp();
        
        String requestedUri = request.getRequestURI();
        if(requestedUri.contains(Constants.INSERT_COURSE_INFO))
        {
            Course currentCourse = createCourse(courseName, courseCode, courseYear, courseSemester, courseCredit,courseType);
            courseService.saveCourse(currentCourse);
            Course course = courseService.verifyCourse(currentCourse);
            modelAndView = new ModelAndView("courseForm");
            if(course!=null)
            {
                modelAndView.addObject("course",course);
                modelAndView.addObject("courseError","Following Course inserted");
            }
            else
            {
                modelAndView.addObject("courseError","Course info not inserted");
            }
        }
        return modelAndView;
    }
    
    private Course createCourse(String courseName,String courseCode,String courseYear,String courseSemester,String courseCredit,String courseType)
    {
        Course course = new Course();
        
        course.setTitle(courseName);
        course.setCourseCode(courseCode);
        course.setYear(courseYear);
        course.setSemester(courseSemester);
        course.setCredit(Double.parseDouble(courseCredit));
        course.setCourseType(courseType);
        
        return course;
    }
    
}
