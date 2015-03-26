/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.User;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.UserMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class UserDAOImp implements UserDAO
{

    @Override
    public void saveUser(User user)
    {
        String SQL = "insert into User(Email,PassWord,Type) values(?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,user.getEmail(),user.getPassWord(),user.getType());
    }

    @Override
    public User findUserByEmail(String email) 
    {
        String SQL = "select * from User where email = ?;";
        List<User> user=DatabaseTemplate.executeQuery(SQL,new Object[]{email}, new UserMapper());
        
        if(user!=null&&user.size()!=0)
            return user.get(0);
        
        return null;
    }

    @Override
    public List<User> getUsers() 
    {
        String SQL = "select * from User";
        List<User> users = DatabaseTemplate.queryForObject(SQL,new UserMapper());
         
        if(users!=null&&users.size()!=0)
            return users;
        return null;
    }

    @Override
    public void updateEmail(String newEmail, String email) 
    {
        String SQL = "update User set email = ? where email = ?;";
        DatabaseTemplate.executeInsertQuery(SQL, newEmail,email);
    }

    
}
