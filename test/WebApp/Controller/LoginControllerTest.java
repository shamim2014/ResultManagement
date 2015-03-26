/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.*;

/**
 *
 * @author shamim
 */
public class LoginControllerTest 
{
    HttpServletRequest request;
    HttpServletResponse response;
    private static final String USER_ID = "1";
    private static final String PASSWORD_PARAMETER = "official";
    private static final String USER_TYPE = "official";
    
    @Before
    public void setUp()
    {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        
        when(request.getParameter("userId")).thenReturn(USER_ID);
        when(request.getParameter("passWord")).thenReturn(PASSWORD_PARAMETER);
        when(request.getParameter("who")).thenReturn(USER_TYPE);
    }
    
    
    @Test
    public void testHandleRequest() throws Exception 
    {
        System.out.println("handleRequest");
        
        LoginController loginController = new LoginController();
        
        ModelAndView result = loginController.handleRequest(request, response);
        assertNotNull(result);
       
    }
    
}
