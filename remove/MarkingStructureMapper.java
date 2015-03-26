/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.EvaluationMarks;
import WebApp.Model.MarkingStructure;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shamim
 */
public class MarkingStructureMapper implements ObjectRowMapper<MarkingStructure>
{

    @Override
    public MarkingStructure mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        MarkingStructure markingStructure = new MarkingStructure();
        markingStructure.setCourseCode(resultSet.getString("course_code"));
        markingStructure.setSession("session");
        InputStream inputStream = resultSet.getBlob("structure").getBinaryStream();
        try 
        {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            markingStructure.setEvaluationMarks((EvaluationMarks)objectInputStream.readObject());
        } 
        catch (IOException iOException) 
        {
           throw new RuntimeException(iOException);
        } 
        catch (ClassNotFoundException classNotFoundException) 
        {
            throw new RuntimeException(classNotFoundException);
        }
        return  markingStructure;
    }
    
}
