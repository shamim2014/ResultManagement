/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.MarkingStructure;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.MarkingStructureMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class MarkingStructureDAOImp implements MarkingStructureDAO
{

    @Override
    public void save(MarkingStructure markingStructure)
    {
        String SQL = "INSERT INTO MarkingStructure (course_code, session, structure) VALUES (?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL, markingStructure.getCourseCode(),markingStructure.getSession(),markingStructure.getEvaluationMarks());
    }

    @Override
    public MarkingStructure getMarkingStructure(String courseCode, String session) 
    {
        String sql = "select * from MarkingStructure where course_code=? and session=?";
        List<MarkingStructure> markingStructures=DatabaseTemplate.executeQuery(sql,new Object[]{courseCode,session},new MarkingStructureMapper());
        
        if(!markingStructures.isEmpty())
            return markingStructures.get(0);
        return null;
    }
    
}
