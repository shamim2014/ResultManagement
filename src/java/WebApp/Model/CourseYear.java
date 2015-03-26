/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;

/**
 *
 * @author shamim
 */
public class CourseYear implements Serializable
{
    private String year;
    private String Semester;
    private String courseCode;
    
    public CourseYear()
    {
        
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
        return Semester;
    }

    public void setSemester(String Semester)
    {
        this.Semester = Semester;
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
