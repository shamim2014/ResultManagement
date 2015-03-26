/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.Course;
import WebApp.Model.CourseSemester;
import WebApp.Service.CourseSemesterService;
import WebApp.Service.CourseSemesterServiceImp;
import WebApp.Service.CourseService;
import WebApp.Service.CourseServiceImp;
import WebApp.Util.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class CourseSemesterController implements Controller
{
    private static final String SESSION ="semester";
    private static final String YEAR ="year";
    private static final String NUMBER_COURSE="number_course";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ModelAndView modelAndView=null;
        CourseService courseService = new CourseServiceImp();
        
        
        String requestedUri = request.getRequestURI();
        
        if(requestedUri.contains(Constants.INSERT_COURSE_SEMESTER))
        {
            CourseSemester courseSemester = createCourseSemester(request);
            CourseSemesterService courseSemesterService = new CourseSemesterServiceImp();
            courseSemesterService.save(courseSemester);
            
            courseSemester = courseSemesterService.getCourseSemester(courseSemester.getYear(),courseSemester.getSemester());
            modelAndView = new ModelAndView("courseSemester");
            modelAndView.addObject("courseSemester", courseSemester);
        }
        else if(requestedUri.contains(Constants.VIEW_COURSE_SEMESTER))
        {
            
        }
        else
        {
            List<Course> courses = courseService.getCourseByYearAndSemester("1st", "1st");
            modelAndView = new ModelAndView("insertSemesterInfo");
            modelAndView.addObject("courses",courses);
        }
        return modelAndView;
    }
    private CourseSemester createCourseSemester(HttpServletRequest request)
    {
        CourseSemester courseSemester = new CourseSemester();
        int numberCourse = Integer.parseInt(request.getParameter(NUMBER_COURSE));
        
        courseSemester.setSemester(request.getParameter(SESSION));
        courseSemester.setYear(request.getParameter(YEAR));
        
        for(int i=1;i<=numberCourse;i++)
        {
            courseSemester.setCourseCode(request.getParameter("course_code"+i));
        }
        return courseSemester;
    }
    
}
