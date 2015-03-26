/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shamim
 */
public class DatabaseConnectionPoolTest 
{
    @Test
    public void testGetConnection() throws Exception 
    {
        System.out.println("getConnection");
        Connection result = DatabaseConnectionPool.getConnection();
        assertNotNull(result);
    }
    
}
