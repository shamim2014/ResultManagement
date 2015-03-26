/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import WebApp.Model.BatchSemester;
import WebApp.Service.BatchSemesterService;
import WebApp.Service.BatchSemesterServiceImp;
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
public class BatchController implements Controller
{
    private static final String YEAR ="year";
    private static final String BATCH ="batch";
    private static final String SEMESTER = "semester";
    private static final String SESSION = "session";
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        String requestedUri = request.getRequestURI();
        ModelAndView modelAndView=null;
        
        if(requestedUri.contains(Constants.INSERT_BATCH_INFO))
        {
            String year = request.getParameter(YEAR);
            String semester = request.getParameter(SEMESTER);
            String session = request.getParameter(SESSION);
            String batch = request.getParameter(BATCH);
            
            BatchSemester batchSemester = createBatchSemester(batch, year, semester, session);
            BatchSemesterService batchSemesterService = new BatchSemesterServiceImp();
            batchSemesterService.save(batchSemester);
            List<BatchSemester> batchSemesters = batchSemesterService.getBatchSemester(batch);
            modelAndView = new ModelAndView("viewBatch");
            modelAndView.addObject("batchSemesters", batchSemesters);
        }
       return modelAndView;
    }
     private BatchSemester createBatchSemester(String batch,String year,String semester,String session)
    {
        BatchSemester batchSemester = new BatchSemester();
        
        batchSemester.setBatch(batch);
        batchSemester.setYear(year);
        batchSemester.setSemester(semester);
        batchSemester.setSession(session);
        
        return batchSemester;
    }
    
}
