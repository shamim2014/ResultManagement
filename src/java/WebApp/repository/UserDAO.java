/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.User;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface UserDAO
{
    public void saveUser(User user);

    public User findUserByEmail(String email);
    
    public List<User> getUsers();
    public void updateEmail(String newEmail, String email);
    
}
