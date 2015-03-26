package WebApp.Model;

import java.io.Serializable;
 
public class CourseTeacher implements Serializable
{
    private String email;
    private String courseCode;
    private String session;
    
    public CourseTeacher()
    {
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getSession()
    {
        return session;
    }

    public void setSession(String session) 
    {
        this.session = session;
    }
}
