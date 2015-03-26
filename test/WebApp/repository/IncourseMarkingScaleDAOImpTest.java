/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

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
public class IncourseMarkingScaleDAOImpTest {
    
    public IncourseMarkingScaleDAOImpTest() {
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
     * Test of save method, of class IncourseMarkingScaleDAOImp.
     */
  /*  @Test
    public void testSave() 
    {
        System.out.println("save");
        IncourseMarkScale ms = null;
        IncourseMarkingScaleDAOImp instance = new IncourseMarkingScaleDAOImp();
        instance.save(ms);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getIncourseMarkScale method, of class IncourseMarkingScaleDAOImp.
     */
    /* 
    @Test
  public void testGetIncourseMarkScale() 
    {
        System.out.println("getIncourseMarkScale");
        String session = "";
        String courseCode = "";
        IncourseMarkingScaleDAOImp instance = new IncourseMarkingScaleDAOImp();
        IncourseMarkScale expResult = null;
        IncourseMarkScale result = instance.getIncourseMarkScale(session, courseCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getMarkDistribution method, of class IncourseMarkingScaleDAOImp.
     */
    @Test
    public void testGetMarkDistribution() 
    {
        System.out.println("getMarkDistribution");
        String session = "2014-2015";
        String courseCode = "CSE-1102";
        IncourseMarkingScaleDAOImp incourseMarkingScaleDAOImp = new IncourseMarkingScaleDAOImp();
     
        IncourseMarkDistribution incourseMarkDistribution = incourseMarkingScaleDAOImp.getMarkDistribution(session, courseCode);
        assertNotNull(incourseMarkDistribution);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
