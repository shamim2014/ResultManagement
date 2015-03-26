package WebApp.Model;

import java.io.Serializable;


public class Login implements Serializable
{
    private String userID,passWord;
    
    public Login()
    {
        
    }
    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID) 
    {
        this.userID = userID;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
    
}
