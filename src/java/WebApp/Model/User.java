
package WebApp.Model;

import java.io.Serializable;


public class User implements Serializable
{
    private String email;
    private String passWord;
    private String type;

    public User()
    {
        
    }
    public User(String email,String passWord, String type)
    {
        this.email=email;
        this.passWord=passWord;
        this.type=type;
    }
    public String getType() 
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
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
