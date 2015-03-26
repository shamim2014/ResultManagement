/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Filter;

import WebApp.Model.User;
import WebApp.Util.AuthenticationHelper;
import WebApp.Util.Constants;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shamim
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException 
    {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();
       
        if((session==null||session.getAttribute(Constants.AUTH_KEY)==null)&&requestedUri.contains("/home"))
        {
            ((HttpServletResponse)servletResponse).sendRedirect("index.htm");
        }
        else if((session!=null && session.getAttribute(Constants.AUTH_KEY)!=null)&&(requestedUri.contains("/login")||requestedUri.contains("index.htm")))
        {
            User user=AuthenticationHelper.getCurrentUser((HttpServletRequest) servletRequest);
            ((HttpServletResponse)servletResponse).sendRedirect("home");
        }
        else
        {
           chain.doFilter(servletRequest, servletResponse);
        }
      
    }

    @Override
    public void destroy()
    {
    }
}
