package WebApp.Model;

import java.io.Serializable;

public class Teacher implements Serializable
{
    private String designation;
    private String department;
    private String name;
    private String email;
    private String phone;
    
    public Teacher()
    {
    }
    public String getDesignation() 
    {
        return designation;
    }

    public void setDesignation(String designation) 
    {
        this.designation = designation;
    }

    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }
       
}
