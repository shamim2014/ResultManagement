/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.User;
import static WebApp.Util.Constants.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author shamim
 */
public class AuthenticationHelper {

    public static void login(HttpServletRequest request, User user)
    {
        request.getSession(true).setAttribute(AUTH_KEY, user);
    }

    public static void logout(HttpServletRequest request) 
    {
        request.getSession(true).removeAttribute(AUTH_KEY);
    }

    public static User getCurrentUser(HttpServletRequest request)
    {
        return (User) request.getSession(true).getAttribute(AUTH_KEY);
    }
}