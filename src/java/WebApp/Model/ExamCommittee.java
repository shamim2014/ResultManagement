
package WebApp.Model;

import java.io.Serializable;

public class ExamCommittee implements Serializable
{
    private String year;
    private String session;
    private String chairmanName;
    private String chairmanEmail;
    private String firstMemberName;
    private String firstMemberEmail;
    private String secondMemberName;
    private String secondMemberEmail;
    
    public ExamCommittee() 
    {
        this.year=this.session=null;
    }

    public String getYear() 
    {
        return year;
    }

    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getSession() 
    {
        return session;
    }

    public void setSession(String session) 
    {
        this.session = session;
    }

    public String getChairmanEmail() 
    {
        return chairmanEmail;
    }

    public void setChairmanEmail(String chairmanEmail) 
    {
        this.chairmanEmail = chairmanEmail;
    }

    public String getChairmanName() 
    {
        return chairmanName;
    }

    public void setChairmanName(String chairmanName)
    {
        this.chairmanName = chairmanName;
    }

    public String getFirstMemberName() 
    {
        return firstMemberName;
    }

    public void setFirstMemberName(String firstMemberName)
    {
        this.firstMemberName = firstMemberName;
    }

    public String getFirstMemberEmail()
    {
        return firstMemberEmail;
    }

    public void setFirstMemberEmail(String firstMemberEmail) 
    {
        this.firstMemberEmail = firstMemberEmail;
    }

    public String getSecondMemberName()
    {
        return secondMemberName;
    }

    public void setSecondMemberName(String secondMemberName)
    {
        this.secondMemberName = secondMemberName;
    }

    public String getSecondMemberEmail()
    {
        return secondMemberEmail;
    }

    public void setSecondMemberEmail(String secondMemberEmail) 
    {
        this.secondMemberEmail = secondMemberEmail;
    }
    
}
