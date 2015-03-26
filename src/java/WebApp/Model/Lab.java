package WebApp.Model;

import java.io.Serializable;

public class Lab implements Serializable
{
    private String FirstInstructorEmail,secondInstructorEmail;
    private String session;
    private String courseCode; 
   public Lab()
   {
       
   }

    public String getFirstInstructorEmail()
    {
        return FirstInstructorEmail;
    }

    public void setFirstInstructorEmail(String FirstInstructorEmail)
    {
        this.FirstInstructorEmail = FirstInstructorEmail;
    }

    public String getSecondInstructorEmail() 
    {
        return secondInstructorEmail;
    }

    public void setSecondInstructorEmail(String secondInstructorEmail) 
    {
        this.secondInstructorEmail = secondInstructorEmail;
    }

    public String getSession() 
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }
}
