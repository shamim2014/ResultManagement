/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;
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
public class MarkDistributionServiceImpTest {
    
    public MarkDistributionServiceImpTest() {
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
     * Test of createMarkDistribution method, of class MarkDistributionServiceImp.
     */
   /* @Test
    public void testCreateMarkDistribution() {
        System.out.println("createMarkDistribution");
        IncourseMarkScale incourseMarkScale = null;
        MarkDistributionServiceImp instance = new MarkDistributionServiceImp();
        instance.createMarkDistribution(incourseMarkScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getMarkDistribution method, of class MarkDistributionServiceImp.
     */
    @Test
    public void testGetMarkDistribution() 
    {
        System.out.println("getMarkDistribution");
        String session = "2014-2015";
        String courseCode = "CSE-1102";
        MarkDistributionServiceImp markDistributionServiceImp = new MarkDistributionServiceImp();
        IncourseMarkDistribution result = markDistributionServiceImp.getMarkDistribution(session, courseCode);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
