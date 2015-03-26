package WebApp.Model;

import java.io.Serializable;

public class TeacherEvaluation implements Serializable
{
   private String session,courseCode,classRoll;
   private Object fourtyMarks;
   public TeacherEvaluation()
   {
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

    public String getClassRoll() 
    {
        return classRoll;
    }

    public void setClassRoll(String classRoll)
    {
        this.classRoll = classRoll;
    }

    public Object getFourtyMarks()
    {
        return fourtyMarks;
    }

    public void setFourtyMarks(Object fourtyMarks)
    {
        this.fourtyMarks = fourtyMarks;
    }
}
