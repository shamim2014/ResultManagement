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
public class UserDAOImpTest {
    
    public UserDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveUser method, of class UserDAOImp.
     */
    /*@Test
    public void testSaveUser() {
        System.out.println("saveUser");
        User user = null;
        UserDAOImp instance = new UserDAOImp();
        instance.saveUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findUserByEmail method, of class UserDAOImp.
     */
    @Test
    public void testFindUserByEmail() 
    {
        System.out.println("findUserByEmail");
        String SQL = "select * from User where email = ?";
        List<User> user=DatabaseTemplate.executeQuery(SQL,new Object[]{"msr@gmail.com"}, new UserMapper());
        assertNotNull(user);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getUsers method, of class UserDAOImp.
     */
     /*@Test
   public void testGetUsers() {
        System.out.println("getUsers");
        UserDAOImp instance = new UserDAOImp();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
