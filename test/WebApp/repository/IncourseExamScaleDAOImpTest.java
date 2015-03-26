/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseExamScale;
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
public class IncourseExamScaleDAOImpTest {
    
    public IncourseExamScaleDAOImpTest() {
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
     * Test of save method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        IncourseExamScale incourseExamScale = null;
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        instance.save(incourseExamScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIncourseExamScale method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testGetIncourseExamScale() {
        System.out.println("getIncourseExamScale");
        String courseCode = "";
        String session = "";
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        IncourseExamScale expResult = null;
        IncourseExamScale result = instance.getIncourseExamScale(courseCode, session);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFirstIncourseExamScale method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testSaveFirstIncourseExamScale() {
        System.out.println("saveFirstIncourseExamScale");
        IncourseExamScale incourseExamScale = null;
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        instance.saveFirstIncourseExamScale(incourseExamScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSecondIncourseExamScale method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testSaveSecondIncourseExamScale() {
        System.out.println("saveSecondIncourseExamScale");
        IncourseExamScale incourseExamScale = null;
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        instance.saveSecondIncourseExamScale(incourseExamScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveThirdIncourseExamScale method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testSaveThirdIncourseExamScale() {
        System.out.println("saveThirdIncourseExamScale");
        IncourseExamScale incourseExamScale = null;
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        instance.saveThirdIncourseExamScale(incourseExamScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFourthIncourseExamScale method, of class IncourseExamScaleDAOImp.
     */
    @Test
    public void testSaveFourthIncourseExamScale() {
        System.out.println("saveFourthIncourseExamScale");
        IncourseExamScale incourseExamScale = null;
        IncourseExamScaleDAOImp instance = new IncourseExamScaleDAOImp();
        instance.saveFourthIncourseExamScale(incourseExamScale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
