/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.Tabulation;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class TabulationMapper implements ObjectRowMapper<Tabulation>{

    @Override
    public Tabulation mapRowToObject(ResultSet resultSet) throws SQLException
    {
        Tabulation tabulation = new Tabulation();
        tabulation.setRegistration(resultSet.getString("registration"));
        tabulation.setRegistrationSession(resultSet.getString("regi_session"));
        tabulation.setExamRoll(resultSet.getString("exam_roll"));
        tabulation.setExamYear(resultSet.getString("exam_year"));
        tabulation.setYear(resultSet.getString("year"));
        tabulation.setSemester(resultSet.getString("semester"));
        
        tabulation.setTotalCredit(resultSet.getDouble("totalCredit"));
        tabulation.setTotalMarks(resultSet.getDouble("totalMark"));
        tabulation.setTotalPoint(resultSet.getDouble("weightedPoint"));
        
        if(resultSet.getString("course_code1")!=null)
           tabulation.setCoursePoint("course_code1",Double.parseDouble(resultSet.getString("course_code1")));
        
        if(resultSet.getString("course_code2")!=null)
                  tabulation.setCoursePoint("course_code2",Double.parseDouble(resultSet.getString("course_code2")));
        if(resultSet.getString("course_code3")!=null)
              tabulation.setCoursePoint("course_code3",Double.parseDouble(resultSet.getString("course_code3")));
        if(resultSet.getString("course_code4")!=null)
              tabulation.setCoursePoint("course_code4",Double.parseDouble(resultSet.getString("course_code4")));
        if(resultSet.getString("course_code5")!=null)
               tabulation.setCoursePoint("course_code5",Double.parseDouble(resultSet.getString("course_code5")));
        if(resultSet.getString("course_code6")!=null)
               tabulation.setCoursePoint("course_code6",Double.parseDouble(resultSet.getString("course_code6")));
        if(resultSet.getString("course_code7")!=null)
               tabulation.setCoursePoint("course_code7",Double.parseDouble(resultSet.getString("course_code8")));
        if(resultSet.getString("course_code8")!=null)
               tabulation.setCoursePoint("course_code8",Double.parseDouble(resultSet.getString("course_code8")));
        if(resultSet.getString("course_code9")!=null)
               tabulation.setCoursePoint("course_code9",Double.parseDouble(resultSet.getString("course_code9")));
        if(resultSet.getString("course_code10")!=null)
               tabulation.setCoursePoint("course_code10",Double.parseDouble(resultSet.getString("course_code10")));
        if(resultSet.getString("course_code11")!=null)
               tabulation.setCoursePoint("course_code11",Double.parseDouble(resultSet.getString("course_code11")));
        
        if(resultSet.getString("sgpa")!=null)
             tabulation.setSgpa(Double.parseDouble(resultSet.getString("sgpa")));
        
        return tabulation;
    }
    
}
