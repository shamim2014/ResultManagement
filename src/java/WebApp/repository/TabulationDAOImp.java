/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.CourseMarks;
import WebApp.Model.CourseSemester;
import WebApp.Model.Tabulation;
import WebApp.Util.CourseMarkMapper;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.TabulationMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class TabulationDAOImp implements TabulationDAO
{

    @Override
    public List<CourseMarks> getTablutionByCourseCode(String courseCode, String session, String batch) 
    {
        String SQL ="Select hall,registration,regi_session,course_code,session,dept_roll,exam_roll,incourseMarks,finalMarks,year,semester From(SELECT hall,registration,regi_session,course_code,session,dept_roll,exam_roll,incourseMarks,finalMarks FROM(SELECT exam_roll,course_code,session,";
        SQL+="avg( totalMarks ) AS finalMarks FROM finalexammarks WHERE course_code =? AND session =? GROUP BY exam_roll) AS T NATURAL JOIN (SELECT dept_roll,exam_roll,totalMarks as incourseMarks, session,";
        SQL+="course_code,regi_session,registration,hall FROM student NATURAL JOIN incoursemark WHERE student.batch =? AND course_code =? ) AS R order by exam_roll)";
        SQL+="as tabulationsheet join batchsemester where batchsemester.batch = ?;";
        List<CourseMarks>courseMarkses = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session,batch,courseCode,batch}, new CourseMarkMapper());
       
        return courseMarkses;
    }

    @Override
    public void saveTabulation(List<Tabulation> tabulations, CourseSemester courseSemester) 
    {
        String [] sqlQuery = new String[tabulations.size()];
        String SQL,suffix;
        for(int j=0;j<tabulations.size();j++)
        {
          SQL ="INSERT INTO tabulation(registration,regi_session,exam_roll,exam_year,year,semester,totalMark,weightedPoint,totalCredit,sgpa";
          suffix = "VALUES('"+tabulations.get(j).getRegistration()+"'";
          suffix += ",'"+tabulations.get(j).getRegistrationSession()+"'";
          suffix += ",'"+tabulations.get(j).getExamRoll()+"'";
          suffix += ",'"+tabulations.get(j).getExamYear()+"'";
          suffix += ",'"+tabulations.get(j).getYear()+"'";
          suffix += ",'"+tabulations.get(j).getSemester()+"'";
          suffix += ","+tabulations.get(j).getTotalMarks();
          suffix += ","+tabulations.get(j).getTotalPoint();
          suffix += ","+tabulations.get(j).getTotalCredit();
          suffix += ","+tabulations.get(j).getSgpa();
          
          for(int i=1;i<=courseSemester.gettotalCourse();i++)
         {
            SQL+=",course_code"+i;
            suffix += ","+tabulations.get(j).getCoursePoint(courseSemester.getCourseCode(i-1));
         }
         SQL+=")";
         SQL+=suffix+")";
         sqlQuery[j]=SQL;
        }
        
        DatabaseTemplate.executeTransaction(sqlQuery);
    }

    @Override
    public List<Tabulation> getTabulationByStudent(String registration, String registrationSession)
    {
        String SQL ="select * from tabulation where registration=? and regi_session=? order by year,semester asc";
        List<Tabulation> tabulations = DatabaseTemplate.executeQuery(SQL,new Object[]{registration,registrationSession},new TabulationMapper());
        if(tabulations!=null&&!tabulations.isEmpty())
            return tabulations;
        return null;
    }

    @Override
    public List<CourseMarks> getTablutionByCourseCodeLab(String courseCode, String session, String batch) 
    {
        String SQL ="Select hall,registration,regi_session,course_code,session,dept_roll,exam_roll, 0 as incourseMarks,totalMarks as finalMarks,year,semester from (select * from (student natural join labmarks) natural join  batchsemester where course_code=? ) as labTotal";
        List<CourseMarks>courseMarkses = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode}, new CourseMarkMapper());
       
        if(courseMarkses!=null&&!courseMarkses.isEmpty())
            return courseMarkses;
        
        return null;
    }

    @Override
    public Tabulation getTabulationByStudent(String registration, String registrationSession, String year, String semester) 
    {
        
        String SQL ="select * from tabulation where registration=? and regi_session=? and year=? and semester=?";
        List<Tabulation> tabulations = DatabaseTemplate.executeQuery(SQL,new Object[]{registration,registrationSession,year,semester},new TabulationMapper());
        if(tabulations!=null&&!tabulations.isEmpty())
            return tabulations.get(0);
        return null;
        
    }

    @Override
    public CourseMarks getTablutionByCourseCodeAndStudent(String courseCode, String session, String batch, String examRoll)
    {
       String SQL ="Select hall,registration,regi_session,course_code,session,dept_roll,exam_roll,incourseMarks,finalMarks,year,semester From(SELECT hall,registration,regi_session,course_code,session,dept_roll,exam_roll,incourseMarks,finalMarks FROM(SELECT exam_roll,course_code,session,";
        SQL+="avg( totalMarks ) AS finalMarks FROM finalexammarks WHERE course_code =? AND session =? GROUP BY exam_roll HAVING exam_roll=?) AS T NATURAL JOIN (SELECT dept_roll,exam_roll,totalMarks as incourseMarks, session,";
        SQL+="course_code,regi_session,registration,hall FROM student NATURAL JOIN incoursemark WHERE student.batch =? AND course_code =? ) AS R order by exam_roll)";
        SQL+="as tabulationsheet join batchsemester where batchsemester.batch = ?;";
        List<CourseMarks>courseMarkses = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session,examRoll,batch,courseCode,batch}, new CourseMarkMapper());
       
        if(courseMarkses!=null && !courseMarkses.isEmpty())
           return courseMarkses.get(0);
        
        return null;
    }

    @Override
    public CourseMarks getTablutionByCourseCodeLabAndStudent(String courseCode, String session, String batch, String examRoll)
    {
        String SQL ="Select hall,registration,regi_session,course_code,session,dept_roll,exam_roll, 0 as incourseMarks,totalMarks as finalMarks,year,semester from (select * from (student natural join labmarks) natural join  batchsemester where course_code=? and exam_roll=? ) as labTotal";
        List<CourseMarks>courseMarkses = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,examRoll}, new CourseMarkMapper());
       
        if(courseMarkses!=null&&!courseMarkses.isEmpty())
            return courseMarkses.get(0);
        
        return null;
        
    }
    
}
