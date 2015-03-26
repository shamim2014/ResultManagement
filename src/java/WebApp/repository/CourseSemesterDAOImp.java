/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.CourseMap;
import WebApp.Model.CourseSemester;
import WebApp.Model.CourseYear;
import WebApp.Util.CourseMapMapper;
import WebApp.Util.CourseSemesterMapper;
import WebApp.Util.CourseYearMapper;
import WebApp.Util.DatabaseTemplate;
import java.util.List;

/**
 *
 * @author shamim
 */
public class CourseSemesterDAOImp implements CourseSemesterDAO
{
    public CourseSemester getCourseSemester(String year,String semester)
    {
        String SQL ="select * from CourseSemester where year=? and semester=?";
        List<CourseSemester> courseSemesters = DatabaseTemplate.executeQuery(SQL, new Object[]{year,semester}, new CourseSemesterMapper());
        
        if(courseSemesters.size()!=0)
            return courseSemesters.get(0);
   
        return null;
    }

    @Override
    public void saveCourseSemester(CourseSemester courseSemester) 
    {
        String SQL ="Insert into CourseSemester(year,semester";
        String suffix="values('"+courseSemester.getYear()+"','"+courseSemester.getSemester()+"'";
        
        for(int i=1;i<=courseSemester.gettotalCourse();i++)
        {
            SQL +=","+"course_code"+i;
            suffix +=",'"+courseSemester.getCourseCode(i-1)+"'";
        }
        SQL +=")";
        suffix+=")";
        SQL +=suffix;
        DatabaseTemplate.execute(SQL);
    }

    @Override
    public CourseYear getCourseYear(String courseCode)
    {
        String SQL ="SELECT year, semester,? as course_code FROM CourseSemester WHERE course_code1 = ? OR course_code2 = ? OR course_code3 =? OR course_code4 = ? OR course_code5 = ? OR course_code6 = ? OR course_code7 = ? OR course_code8= ? OR course_code9= ? OR course_code10= ? OR course_code11= ?";
        List<CourseYear> courseYears =DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode,courseCode}, new CourseYearMapper());
        
        if(courseYears!=null && courseYears.size()!=0)
            return courseYears.get(0);
        return null;
    }

    @Override
    public List<CourseMap> getCourseMaps() 
    {
        String SQL = "select * from CourseSemester order by year, semester asc";
        List<CourseMap> courseMaps = DatabaseTemplate.queryForObject(SQL,new CourseMapMapper());
        
        if(courseMaps!=null && !courseMaps.isEmpty())
            return courseMaps;
        return null;
    }
}
