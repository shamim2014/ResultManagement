/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Incourse;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.IncourseMapper;
import WebApp.Util.IncourseMarkMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseDAOImp implements IncourseDAO
{

    @Override
    public void saveFinal(Incourse incourse) 
    {
        String SQL = "insert into IncourseMark (course_code, session, dept_roll, totalMarks) values (?, ?, ?, ?)";
        DatabaseTemplate.executeInsertQuery(SQL,incourse.getCourseCode(),incourse.getSession(),incourse.getDept_Roll(),incourse.getTotalObtainMarks());
    }

    @Override
    public List<Incourse> getIncourseForAllStudent(String session, String courseCode) 
    {
        String SQL ="select * from IncourseMark where session=? and course_code=? order by dept_roll asc";
        List<Incourse> incourses=DatabaseTemplate.executeQuery(SQL,new Object[]{session,courseCode},new IncourseMapper());
        return incourses;
    }

    @Override
    public List<Incourse> getIncourseForSession(String session, String courseCode)
    {
        String SQL ="select * from IncourseMark natural join IncourseExam where session=? and course_code=?";
        List<Incourse> incourses = DatabaseTemplate.executeQuery(SQL,new Object[]{session,courseCode},new IncourseMarkMapper());
        if(incourses!=null && !incourses.isEmpty())
        {
            return incourses;
        }
        return null;
    }

    @Override
    public void save(Incourse in) 
    {
        String SQL = "insert into IncourseMark (course_code, session, incourse_exam,viva,attendance,assignment,presentation,suddent_test,dept_roll, totalMarks) values (?, ?, ?, ?,?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,in.getCourseCode(),in.getSession(),in.getIncourseExam(),in.getViva(),in.getAttendance(),in.getAssignment(),in.getPresentation(),in.getSuddentTest(),in.getDept_Roll(),in.getTotalObtainMarks());
    }

    @Override
    public void update(Incourse incourse) 
    {
        String SQL ="delete from IncourseMark where course_code=? and session=? and dept_roll=?;";
        DatabaseTemplate.executeInsertQuery(SQL, incourse.getCourseCode(),incourse.getSession(),incourse.getDept_Roll());
        save(incourse);
    }
    
}
