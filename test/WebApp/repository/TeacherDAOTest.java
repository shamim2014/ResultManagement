/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Teacher;
import WebApp.Util.DatabaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shamim
 */
public class TeacherDAOTest 
{
    private Teacher teacher;
    private TeacherDAO teacherDAO;
    private final String NAME ="demo";
    private final String DEPARTMENT ="cse";
    private final String EMAIL ="mail@gmail.com";
    private final String PHONE ="01718";
    
    @Before
    public void setUp() 
    {
        teacher = new Teacher();
        
        teacher.setName(NAME);
        teacher.setDepartment(DEPARTMENT);
        teacher.setEmail(EMAIL);
        teacher.setPhone(PHONE);
        
        teacherDAO = new TeacherDAOImp();
    }
    
    @After
    public void tearDown() 
    {
        DatabaseTemplate.delete("delete from Teacher");
    }

    /**
     * Test of save method, of class TeacherDAOImp.
     */
    @Test
    public void testSave_ShouldNotThrowException() throws Exception 
    {
        System.out.println("save");
        teacherDAO.save(teacher);
    }
    
}
