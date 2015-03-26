/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.User;
import WebApp.repository.UserDAO;
import WebApp.repository.UserDAOImp;


public class LoginServiceImp implements LoginService
{
    private UserDAO userDAO;
    
    public LoginServiceImp()
    {
       userDAO = new UserDAOImp();
    }
    public LoginServiceImp(UserDAO userDAO)
    {
        this.userDAO=userDAO;
    }
    @Override
    public User verifyUser(User user) 
    {
       User verifiedUser = userDAO.findUserByEmail(user.getEmail());
       
       if(verifiedUser!=null && verifiedUser.getPassWord().equals(user.getPassWord())&&verifiedUser.getType().equalsIgnoreCase(user.getType()))
       {
           return verifiedUser;
       }
       return null;
    }
    
    
}
