/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;
import java.util.Hashtable;

/**
 *
 * @author shamim
 */
public class CourseMap implements Serializable
{
     private String year;
     private String semester;
     private Hashtable<String,String> semesterCourseMap;
     public CourseMap()
     {
         semesterCourseMap = new Hashtable<String,String>();
     }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemesterCourseMap(String courseIndex) 
    {
        return semesterCourseMap.get(courseIndex);
    }

    public void setSemesterCourseMap(String courseIndex,String courseCode) 
    {
        this.semesterCourseMap.put(courseIndex,courseCode);
    }
     
}
