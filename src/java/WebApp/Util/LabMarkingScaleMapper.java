/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import WebApp.Model.LabMarkingScale;
/**
 *
 * @author shamim
 */
public class LabMarkingScaleMapper implements ObjectRowMapper<LabMarkingScale>
{

    @Override
    public LabMarkingScale mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        LabMarkingScale labMarkingScale = new LabMarkingScale();
        labMarkingScale.setCourseCode(resultSet.getString("course_code"));
        labMarkingScale.setSession(resultSet.getString("session"));
        labMarkingScale.setAssessment(resultSet.getDouble("assessment"));
        labMarkingScale.setAssignment(resultSet.getDouble("assignment"));
        labMarkingScale.setAttendance(resultSet.getDouble("attendance"));
        labMarkingScale.setLab_exam(resultSet.getDouble("lab_exam"));
        labMarkingScale.setPresentation(resultSet.getDouble("presentation"));
        labMarkingScale.setProject(resultSet.getDouble("project"));
        labMarkingScale.setReport(resultSet.getDouble("report"));
        labMarkingScale.setTotalMarks(resultSet.getDouble("totalMarks"));
        labMarkingScale.setViva(resultSet.getDouble("viva"));
        
        return labMarkingScale;
    }
    
}
