
package WebApp.Controller;

import WebApp.Util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class IncourseMarkingController implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView modelAndView = null;
        
        String requestedUri = request.getRequestURI();
        if(requestedUri.contains(Constants.INCOURSE_MARK_DISTRIBUTION))
        {
            modelAndView = new ModelAndView("insertEachIncourseMarks");
        }
        return modelAndView;
    }
    
}
