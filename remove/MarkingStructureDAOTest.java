
package WebApp.repository;

import WebApp.Model.EvaluationMarks;
import WebApp.Model.MarkingStructure;
import WebApp.Util.DatabaseTemplate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author shamim
 */
public class MarkingStructureDAOTest {
    
    private final String courseCode = "4101";
    private final String session = "2013-2014";
    private MarkingStructure markingStructure;
    private MarkingStructureDAO markingStructureDAO;
    
    @Before
    public void setUp()
    {
        markingStructure = new MarkingStructure();
        markingStructure.setCourseCode(courseCode);
        markingStructure.setSession(session);
        EvaluationMarks evaluationMarks = new EvaluationMarks();
        evaluationMarks.setMarkingScale(10);
        markingStructure.setEvaluationMarks(evaluationMarks);
        
        markingStructureDAO = new MarkingStructureDAOImp();
    }
    
    @After
    public void tearDown() 
    {
       DatabaseTemplate.delete("delete from MarkingStructure");
    }

    
   @Test
    public void testSave() 
    {
        System.out.println("save");
        System.out.println(markingStructure.getEvaluationMarks().getClass().getName());
        assertNotNull(markingStructure.getEvaluationMarks());
        markingStructureDAO.save(markingStructure);     
    }
    @Test
    public void testGetMarkingStructure()
    {
        System.out.println("getMarkingStructure");
        markingStructure=markingStructureDAO.getMarkingStructure(courseCode, session);
        assertNotNull(markingStructure);
        System.out.println(markingStructure.getEvaluationMarks().getClass().getName());
    }

}
