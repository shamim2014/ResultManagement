/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.IncourseMarkDistribution;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class IncourseMarkDistributionMapper implements ObjectRowMapper<IncourseMarkDistribution>
{

    @Override
    public IncourseMarkDistribution mapRowToObject(ResultSet resultSet) throws SQLException 
    {
         IncourseMarkDistribution incourseMarkDistribution = new IncourseMarkDistribution();
         
         incourseMarkDistribution.setAssignment(resultSet.getDouble("assignment"));
         incourseMarkDistribution.setAttendance(resultSet.getDouble("attendance"));
         incourseMarkDistribution.setBatch(resultSet.getString("batch"));
         incourseMarkDistribution.setCourseCode(resultSet.getString("course_code"));
         incourseMarkDistribution.setIncourseExam(resultSet.getDouble("incourse_exam"));
         incourseMarkDistribution.setIncourseExam1(resultSet.getDouble("incourse_exam1"));
         incourseMarkDistribution.setIncourseExam2(resultSet.getDouble("incourse_exam2"));
         incourseMarkDistribution.setIncourseExam3(resultSet.getDouble("incourse_exam3"));
         incourseMarkDistribution.setIncourseExam4(resultSet.getDouble("incourse_exam4"));
         incourseMarkDistribution.setPresentation(resultSet.getDouble("presentation"));
         incourseMarkDistribution.setSession(resultSet.getString("session"));
         incourseMarkDistribution.setSuddentTest(resultSet.getDouble("suddent_test"));
         incourseMarkDistribution.setTotalExam(resultSet.getInt("totalIncourse"));
         incourseMarkDistribution.setTotalMarks(resultSet.getDouble("totalMarks"));
         incourseMarkDistribution.setViva(resultSet.getDouble("viva"));
         incourseMarkDistribution.setMarkingType(resultSet.getInt("markingType"));
         return incourseMarkDistribution;
    }
    
}
