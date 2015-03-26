/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

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
public class EmailTest 
{
    private  String from;
    private String password;
    private String subject;
    private String[] to;
    private String body;
    private final String USER_NAME = "mail2shamimreza@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private final String PASSWORD = "01620_726566"; // GMail password
    private final String RECIPIENT = "ms.reza007@gmail.com";

    @Before
    public void setUp()
    {
        from = USER_NAME;
        password = PASSWORD;
        to = new String[]{ RECIPIENT };
        subject ="mail testing";
        body ="mail from app";
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of sendMail method, of class Email.
     * @throws java.lang.Exception
     */
    @Test
    public void testSendMailShouldNotThrowException() throws Exception
    {
        System.out.println("sendMail");
        Email email = new Email();
        email.sendMail(from, password, to, subject, body);
    }
    
}
