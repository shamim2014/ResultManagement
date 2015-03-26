/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.LabMark;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class LabMarkMapper implements ObjectRowMapper<LabMark>
{

    @Override
    public LabMark mapRowToObject(ResultSet resultSet) throws SQLException
    {
        LabMark labMark = new LabMark();
        
        labMark.setAssessment(resultSet.getDouble("assessment"));
        labMark.setAssignment(resultSet.getDouble("assignment"));
        labMark.setAttendance(resultSet.getDouble("attendance"));
        labMark.setCourseCode(resultSet.getString("course_code"));
        labMark.setDept_Roll(resultSet.getString("dept_roll"));
        labMark.setLab_exam(resultSet.getDouble("lab_exam"));
        labMark.setPresentation(resultSet.getDouble("presentation"));
        labMark.setProject(resultSet.getDouble("project"));
        labMark.setReport(resultSet.getDouble("report"));
        labMark.setSession(resultSet.getString("session"));
        labMark.setTotalMarks(resultSet.getDouble("totalMarks"));
        labMark.setViva(resultSet.getDouble("viva"));
        
        return labMark;
    }
    
}
