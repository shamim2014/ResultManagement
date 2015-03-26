

package WebApp.Controller;

import WebApp.Util.DatabaseTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.web.servlet.ModelAndView;


public class InsertExamCommitteeControllerTest 
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private static final String SESSION ="session";
    private static final String YEAR ="year";
    private static final String CHAIRMAN_NAME ="chairman_name";
    private static final String CHAIRMAN_ID="chairman_id";
    private static final String FIRST_MEMBER_NAME="1stmem_name";
    private static final String FIRST_MEMBER_ID="1stmem_id";
    private static final String SECOND_MEMBER_NAME="2ndmem_name";
    private static final String SECOND_MEMBER_ID="2ndmem_id";
    
        
    @Before
    public void setUp() 
    {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        
        when(request.getParameter(SESSION)).thenReturn("2013-2014");
        when(request.getParameter(YEAR)).thenReturn("2nd");
        when(request.getParameter(CHAIRMAN_NAME)).thenReturn("mmr");
        when(request.getParameter(CHAIRMAN_ID)).thenReturn("2");
        when(request.getParameter(FIRST_MEMBER_NAME)).thenReturn("ssk");
        when(request.getParameter(FIRST_MEMBER_ID)).thenReturn("3");
        when(request.getParameter(SECOND_MEMBER_NAME)).thenReturn("TTK");
        when(request.getParameter(SECOND_MEMBER_ID)).thenReturn("4");
    }
    
    @After
    public void tearDown() 
    {
        DatabaseTemplate.delete("delete from User where ID!=1");
        DatabaseTemplate.delete("delete from ExamCommittee");
    }

    /**
     * Test of handleRequest method, of class InsertExamCommitteeController.
     */
    @Test
    public void testHandleRequest() throws Exception 
    {
        System.out.println("handleRequest");
        
        InsertExamCommitteeController insertExamCommitteeController = new InsertExamCommitteeController();
        ModelAndView modelAndView = insertExamCommitteeController.handleRequest(request, response);
        assertNotNull(modelAndView);
    }
    
}
