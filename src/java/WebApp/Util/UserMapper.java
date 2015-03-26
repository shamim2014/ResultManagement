/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author shamim
 */
public class UserMapper implements ObjectRowMapper<User>
{
    
    @Override
    public User mapRowToObject(ResultSet resultSet) throws SQLException 
    {
         User user = new User();
         user.setEmail(resultSet.getString("Email"));
         user.setPassWord(resultSet.getString("PassWord"));
         user.setType(resultSet.getString("Type"));
         return user;
    }
    
}
