/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.BatchSemester;
import WebApp.Model.StudentTabulation;
import WebApp.Model.StudentTabulationHeader;
import WebApp.Service.TabulationService;
import WebApp.Service.TabulationServiceImp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author shamim
 */
public class TabulationController implements Controller
{
    private static final String YEAR = "year";
    private static final String SEMESTER = "semester";
    private static final String SESSION = "session";
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String realPath = request.getServletContext().getRealPath("/");
        TabulationService tabulationService = new TabulationServiceImp();
       /* String year = request.getParameter(YEAR);
        String semester = request.getParameter(SEMESTER);
        String session = request.getParameter(SESSION);
        //String examYear[] = session.split("-");
        
        */
       /* BatchSemesterService batchSemesterService = new BatchSemesterServiceImp();
        BatchSemester batchSemester = batchSemesterService.getBatchSemester(year, semester, session);
        
        CourseSemesterService courseSemesterService = new CourseSemesterServiceImp();
        CourseSemester courseSemester = courseSemesterService.getCourseSemester(year, semester);
        
        StudentService studentService = new StudentServiceImp();
        List<Student> students = studentService.getStudentByBatch(batchSemester.getBatch());
        
        CourseService courseService = new CourseServiceImp();
        List<Course> courses = courseService.getSemesterCourses(courseSemester);
        TabulationService tabulationService = new TabulationServiceImp();
        tabulationService.createTabulation(batchSemester,courseSemester,students,courses,examYear[1]);
       */
        
        tabulationService.createTabulation(request.getParameter(YEAR));
        ModelAndView modelAndView = new ModelAndView("tabulation");
        StudentTabulationHeader studentTabulationHeader = tabulationService.getStudentTabulationHeader("1st");
        List<StudentTabulation> studentTabulations = tabulationService.getStudentTabulation("1st");
        
        String fileName=tabulationService.createExcel(studentTabulationHeader, studentTabulations,realPath);
        modelAndView.addObject("studentTabulationHeader", studentTabulationHeader);
        modelAndView.addObject("studentTabulations", studentTabulations);
        modelAndView.addObject("downlink", fileName);
        return modelAndView;
    }
    private BatchSemester createSemester(String year,String semester,String session)
    {
        BatchSemester batchSemester = new BatchSemester();
        
        batchSemester.setYear(year);
        batchSemester.setSemester(semester);
        batchSemester.setSession(session);
        
        return batchSemester;
    }
    
}
