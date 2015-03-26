/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.IncourseExam;
import WebApp.Model.IncourseExamScale;
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
public class IncourseExamServiceImpTest {
    
    public IncourseExamServiceImpTest() {
    }
 
    @Test
    public void testGetIncourseExam_String_String()
    {
        System.out.println("getIncourseExam");
        String courseCode = "CSE-1102";
        String session = "2014-2015";
        IncourseExamServiceImp instance = new IncourseExamServiceImp();
        
        List<IncourseExam> result = instance.getIncourseExam(courseCode, session,30);
       System.out.println(result.get(0).getIncourseFinal());
        System.out.println(result.get(1).getIncourseFinal());
    }

    /**
     * Test of setMarkingType method, of class IncourseExamServiceImp.
     */
   
    
}
