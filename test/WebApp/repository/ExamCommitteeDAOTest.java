/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.ExamCommittee;
import WebApp.Model.User;
import WebApp.Util.DatabaseTemplate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author shamim
 */
public class ExamCommitteeDAOTest 
{
    private User examCommitteeChairman;
    private User firstMember;
    private User secondMember;
    private ExamCommittee examCommittee;
    private final String year="2nd";
    private final String session="2013-2014";
    private final int chairmanId=5;
    private final int firstMemberId=10;
    private final int secondMemberId=20;
    
    @Before
    public void setUp() 
    {
       /* examCommittee = new ExamCommittee();
        examCommittee.setChairmanId(chairmanId);
        examCommittee.setFirstMemberId(firstMemberId);
        examCommittee.setSecondMemberId(secondMemberId);
        examCommittee.setSession(session);
        examCommittee.setYear(year);
        
        examCommitteeChairman = new User();
        examCommitteeChairman.setId(chairmanId);
        
        firstMember = new User();
        firstMember.setId(firstMemberId);
       
        secondMember = new User();
        secondMember.setId(secondMemberId);*/
    }
    
    
    @After
    public void tearDown() 
    {
       /* DatabaseTemplate.delete("delete from ExamCommittee");
        DatabaseTemplate.delete("delete from User where ID!=1");*/
    }
    /**
     * Test of saveExamCommittee method, of class ExamCommitteeDAO.
     */
    @Test
    public void testSaveExamCommittee() 
    {
        System.out.println("saveExamCommittee");
        
        /*ExamCommitteeDAO examCommitteeDAO = new ExamCommitteeDAOImp();
        examCommitteeDAO.saveExamCommittee(examCommittee, examCommitteeChairman, firstMember, secondMember);
        UserDAO userDAO = new UserDAOImp();
        User chairman=userDAO.findUserById(chairmanId);
        assertNotNull(chairman);

        User member = userDAO.findUserById(firstMemberId);
        assertNotNull(member);
        
        member =userDAO.findUserById(secondMemberId);
        assertNotNull(member);*/
        
    }
  
    
}
