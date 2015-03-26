
package WebApp.Model;

import java.io.Serializable;

public class Term implements Serializable
{
    private String year,semester;
    private int semesterCredit; 
    
    public Term()
    {
        this.semester=this.year=null;
        this.semesterCredit=0;
    }

    public String getYear() 
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getSemester() 
    {
        return semester;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public int getSemesterCredit()
    {
        return semesterCredit;
    }

    public void setSemesterCredit(int semesterCredit)
    {
        this.semesterCredit = semesterCredit;
    }
}
