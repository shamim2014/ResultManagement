/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shamim
 */
public class CourseSemester implements Serializable
{
    private String year;
    private String semester;
    private int totalCourse;
    private List<String>coureseCodeList;
    
    public CourseSemester()
    {
        totalCourse=0;
        coureseCodeList = new ArrayList<String>();
    }

    public String getYear() 
    {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }
    
    public void setCourseCode(String courseCode)
    {
        if(courseCode!=null)
        {
            this.coureseCodeList.add(courseCode);
            this.totalCourse++;
        }    
    }
    public void setCourseCode(int index, String courseCode)
    {
        if(courseCode!=null)
        {
            this.coureseCodeList.add(index, courseCode);
            this.totalCourse++;
        }
    }
    public String getCourseCode(int index)
    {
        if(!this.coureseCodeList.isEmpty())
        {
            return this.coureseCodeList.get(index);
        } 
        else
            return null;
    }
   
    public int gettotalCourse()
    {
        return this.totalCourse;
    }
}
