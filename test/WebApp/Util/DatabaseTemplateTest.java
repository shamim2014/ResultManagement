/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.User;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author shamim
 */
public class DatabaseTemplateTest 
{  
    @After
    public void tearDown() 
    {
        //DatabaseTemplate.delete("delete from User where email!=1");
    }

   /* @Test
    public void testExecute_ShouldNotThrowException() throws Exception
    {
        DatabaseTemplate.execute("select * from User where email='msr@gmail.com'");
    }
*/
   
    /*@Test
    public void testExecuteTransaction_ShouldNotThrowException() 
    {
        System.out.println("executeTransaction");
        String examCommitteeSql ="insert into ExamCommittee (chairmanId,firstMemberId,secondMemberId,year,session) values ("+5+","+10+","+15+", '2nd', '2013-2014')";
        String firstUserSql ="insert into User ( ID,PassWord,Type) values ("+5+",'"+5+"', 'committee')";
        
        DatabaseTemplate.executeTransaction(examCommitteeSql,firstUserSql);
       
    }*/

    @Test
    public void testExecuteQueryShouldReturnOneUser() throws Exception
    {
        System.out.println("executeQuery");
        String SQL = "select * from User where email = ?";
        String email ="msr@gmail.com";
        List<User> userList=DatabaseTemplate.executeQuery(SQL,new Object[]{email}, new UserMapper());
        assertNotNull(userList);
        
        assertNotNull(userList.get(0));
    }

 
  /*  @Test
    public void testQueryForObject_ShouldReturnOneUser()
    {
        System.out.println("queryForObject");
        String SQL = "select * from User where ID = 1";
        List<User> userList=DatabaseTemplate.queryForObject(SQL, new UserMapper());
        
        assertNotNull(userList);
        assertNotNull(userList.get(0));
    }*/
    /**
     * Test of executeInsertQuery method, of class DatabaseTemplate.
     * @throws java.lang.Exception
     */
   /* @Test
    public void testExecuteInsertQuery_ShouldNotThrowException() throws Exception 
    {
        System.out.println("executeInsertQuery");
        String query = "insert into User ( ID,PassWord,Type) values (?, ?, ?)";
  
        DatabaseTemplate.executeInsertQuery(query,5,"5","committee");
    }*/
    /*@Test
    public void testTransaction_ShouldNotThrowException()
    {
        System.out.println("Transaction");
        String query = "insert into User ( ID,PassWord,Type) values (?, ?, ?)";
        DatabaseTemplate.setTransaction();
        int i;
        for(i=11;i<20;i++)
        DatabaseTemplate.executeTransactionQuery(query,i,""+i,"committee");
        
        if(i==20)
            DatabaseTemplate.commit();
            
        
    }*/
}
