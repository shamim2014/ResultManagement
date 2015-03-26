/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.User;

/**
 *
 * @author shamim
 */
public interface LoginService 
{
    public User verifyUser(User user);
}
