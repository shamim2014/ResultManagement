/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseExamScale;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.IncourseExamScaleMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseExamScaleDAOImp implements IncourseExamScaleDAO
{

    @Override
    public void save(IncourseExamScale incourseExamScale) 
    {
        String SQL = "insert into IncourseExamScale (course_code,session,batch,incourse_exam1,incourse_exam2,incourse_exam3,incourse_exam4,totalIncourse) values (?, ?, ?, ?, ?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExamScale.getCourseCode(),incourseExamScale.getSession(),incourseExamScale.getBatch(),incourseExamScale.getIncourseExam1(),incourseExamScale.getIncourseExam2(),incourseExamScale.getIncourseExam3(),incourseExamScale.getIncourseExam4(),incourseExamScale.getTotalExam());
    }

    @Override
    public IncourseExamScale getIncourseExamScale(String courseCode, String session) 
    {
        String SQL = "select * from IncourseExamScale where course_code=? and session=?";
        List<IncourseExamScale> incourseExamScales=DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session},new IncourseExamScaleMapper());
        
        if(incourseExamScales!=null && !incourseExamScales.isEmpty())
        {
            return incourseExamScales.get(0);
        }
        return null;
    }

    @Override
    public void saveFirstIncourseExamScale(IncourseExamScale incourseExamScale)
    {
        String SQL = "update IncourseExamScale set incourse_exam1=?, totalIncourse=? where course_code=? and session=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExamScale.getIncourseExam1(),incourseExamScale.getTotalExam(),incourseExamScale.getCourseCode(),incourseExamScale.getSession());
    }

    @Override
    public void saveSecondIncourseExamScale(IncourseExamScale incourseExamScale) 
    {
        String SQL = "update IncourseExamScale set incourse_exam2=?, totalIncourse=? where course_code=? and session=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExamScale.getIncourseExam2(),incourseExamScale.getTotalExam(),incourseExamScale.getCourseCode(),incourseExamScale.getSession());
    }

    @Override
    public void saveThirdIncourseExamScale(IncourseExamScale incourseExamScale) 
    {
        String SQL = "update IncourseExamScale set incourse_exam3=?, totalIncourse=?  where course_code=? and session=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExamScale.getIncourseExam3(),incourseExamScale.getTotalExam(),incourseExamScale.getCourseCode(),incourseExamScale.getSession());
    }

    @Override
    public void saveFourthIncourseExamScale(IncourseExamScale incourseExamScale)
    {
        String SQL = "update IncourseExamScale set incourse_exam4=?, totalIncourse=?  where course_code=? and session=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExamScale.getIncourseExam4(),incourseExamScale.getTotalExam(),incourseExamScale.getCourseCode(),incourseExamScale.getSession());
    }

    @Override
    public void setMarkingType(String courseCode, String session, int markingType)
    {
        String SQL = "select * from IncourseExamScale where course_code=? and session=?";
        List<IncourseExamScale> incourseExamScales=DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session},new IncourseExamScaleMapper());
        
        if(incourseExamScales!=null && !incourseExamScales.isEmpty())
        {
            SQL = "update IncourseExamScale set markingType=? where course_code=? and session=?";
            DatabaseTemplate.executeInsertQuery(SQL, new Object[]{markingType,courseCode,session});
        }
        else
        {
          SQL = "insert into IncourseExamScale (markingType,course_code,session) values (?, ?, ?);";
          DatabaseTemplate.executeInsertQuery(SQL, new Object[]{markingType,courseCode,session});
        }
        
    }
    
}
