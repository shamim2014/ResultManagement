/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.IncourseMarkDistributionMapper;
import WebApp.Util.IncourseMarkScaleMapper;
import WebApp.Util.ObjectRowMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseMarkingScaleDAOImp implements IncourseMarkingScaleDAO
{

    @Override
    public void save(IncourseMarkScale ms) 
    {
        String SQL = "insert into incoursemarkingscale (course_code, session, incourse_exam, viva,attendance,assignment,presentation,suddent_test,totalMarks) values (?, ?, ?, ?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,ms.getCourseCode(),ms.getSession(),ms.getIncourseExam(),ms.getViva(),ms.getAttendance(),ms.getAssignment(),ms.getPresentation(),ms.getSuddentTest(),40);   
    }  

    @Override
    public IncourseMarkScale getIncourseMarkScale(String session, String courseCode) 
    {
        String SQL ="select * from incoursemarkingscale where session=? and course_code=?";
        List<IncourseMarkScale> incourseMarkScales = DatabaseTemplate.executeQuery(SQL,new Object[]{session,courseCode},new IncourseMarkScaleMapper());
        if(incourseMarkScales!=null && !incourseMarkScales.isEmpty())
        {
            return incourseMarkScales.get(0);
        }
        return null;
    }

    @Override
    public IncourseMarkDistribution getMarkDistribution(String session, String courseCode) 
    {
        String SQL ="select * from incoursemarkingscale natural join IncourseExamScale where session=? and course_code=?";
        List<IncourseMarkDistribution> incourseMarkDistributions = DatabaseTemplate.executeQuery(SQL,new Object[]{session,courseCode},new IncourseMarkDistributionMapper());
        if(incourseMarkDistributions!=null && !incourseMarkDistributions.isEmpty())
        {
            return incourseMarkDistributions.get(0);
        }
        return null;
    }
}
