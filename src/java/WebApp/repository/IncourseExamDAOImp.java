/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseExam;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.IncourseExamMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseExamDAOImp implements IncourseExamDAO
{
    @Override
    public List<IncourseExam> getIncourses(String courseCode, String session)
    {
        String SQL = "select * from IncourseExam where course_code=? and session=?";
        List<IncourseExam> incourseExams=DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session}, new IncourseExamMapper());
        
        if(incourseExams!=null && !incourseExams.isEmpty())
        {
            return incourseExams;
        }
        return null;
    }
    
    @Override
    public void save(IncourseExam incourseExam) 
    {
        String SQL = "insert into IncourseExam (course_code, session, dept_roll, batch,incourse_exam1,incourse_exam2,incourse_exam3,incourse_exam4) values (?, ?, ?, ?, ?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExam.getCourseCode(),incourseExam.getSession(),incourseExam.getDept_Roll(),incourseExam.getBatch(),incourseExam.getIncourseExam1(),incourseExam.getIncourseExam2(),incourseExam.getIncourseExam3(),incourseExam.getIncourseExam4());
    }
    
    @Override
    public void saveFirstIncourseExam(IncourseExam incourseExam) 
    {
        String SQL = "update IncourseExam set incourse_exam1=? where course_code=? and session=? and dept_roll=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExam.getIncourseExam1(),incourseExam.getCourseCode(),incourseExam.getSession(),incourseExam.getDept_Roll());
    }

    @Override
    public void saveSecondIncourseExam(IncourseExam incourseExam) 
    {
        String SQL = "update IncourseExam set incourse_exam2=? where course_code=? and session=? and dept_roll=?";
        DatabaseTemplate.executeInsertQuery(SQL,incourseExam.getIncourseExam2(),incourseExam.getCourseCode(),incourseExam.getSession(),incourseExam.getDept_Roll());
    }

    @Override
    public void saveThirdIncourseExam(IncourseExam incourseExam) 
    {
       String SQL = "update IncourseExam set incourse_exam3=? where course_code=? and session=? and dept_roll=?";
       DatabaseTemplate.executeInsertQuery(SQL,incourseExam.getIncourseExam3(),incourseExam.getCourseCode(),incourseExam.getSession(),incourseExam.getDept_Roll());
    }

    @Override
    public void saveFourthIncourseExam(IncourseExam incourseExam) 
    {
       String SQL = "update IncourseExam set incourse_exam4=? where course_code=? and session=? and dept_roll=?";
       DatabaseTemplate.executeInsertQuery(SQL,incourseExam.getIncourseExam4(),incourseExam.getCourseCode(),incourseExam.getSession(),incourseExam.getDept_Roll());
    }

    
}
