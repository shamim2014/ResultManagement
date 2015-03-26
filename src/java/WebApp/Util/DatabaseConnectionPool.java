/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionPool 
{
    private static final String URL="jdbc:mysql://localhost:3306/resultmanagement";
    private static final String USER_NAME="root";
    private static final String PASSWORD="";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException 
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
        return connection;
    }
}
