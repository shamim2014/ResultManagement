/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.CourseMap;
import WebApp.Model.CourseSemester;
import WebApp.Model.CourseYear;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface CourseSemesterDAO 
{
    public void saveCourseSemester(CourseSemester courseSemester);
    public CourseSemester getCourseSemester(String year,String semester);
    public CourseYear getCourseYear(String courseCode);
    public List<CourseMap> getCourseMaps();
}
