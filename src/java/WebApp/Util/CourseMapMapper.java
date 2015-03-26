/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.CourseMap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class CourseMapMapper implements ObjectRowMapper<CourseMap>
{

    @Override
    public CourseMap mapRowToObject(ResultSet resultSet) throws SQLException 
    {  
        CourseMap courseMap = new CourseMap();
        
        courseMap.setYear(resultSet.getString("year"));
        courseMap.setSemester(resultSet.getString("semester"));
        
        if(resultSet.getString("course_code1")!=null)
           courseMap.setSemesterCourseMap("course_code1", resultSet.getString("course_code1"));
        if(resultSet.getString("course_code2")!=null)
                  courseMap.setSemesterCourseMap("course_code2", resultSet.getString("course_code2"));
        if(resultSet.getString("course_code3")!=null)
              courseMap.setSemesterCourseMap("course_code3", resultSet.getString("course_code3"));
        if(resultSet.getString("course_code4")!=null)
              courseMap.setSemesterCourseMap("course_code4", resultSet.getString("course_code4"));
        if(resultSet.getString("course_code5")!=null)
               courseMap.setSemesterCourseMap("course_code5", resultSet.getString("course_code5"));
        if(resultSet.getString("course_code6")!=null)
               courseMap.setSemesterCourseMap("course_code6", resultSet.getString("course_code6"));
        if(resultSet.getString("course_code7")!=null)
               courseMap.setSemesterCourseMap("course_code7", resultSet.getString("course_code7"));
        if(resultSet.getString("course_code8")!=null)
               courseMap.setSemesterCourseMap("course_code8", resultSet.getString("course_code8"));
        if(resultSet.getString("course_code9")!=null)
               courseMap.setSemesterCourseMap("course_code9", resultSet.getString("course_code9"));
        if(resultSet.getString("course_code10")!=null)
               courseMap.setSemesterCourseMap("course_code10", resultSet.getString("course_code10"));
        if(resultSet.getString("course_code11")!=null)
            courseMap.setSemesterCourseMap("course_code11", resultSet.getString("course_code11"));
        
        return courseMap;
    }
    
}
