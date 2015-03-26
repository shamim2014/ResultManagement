/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.BatchSemester;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class BatchSemesterMapper implements ObjectRowMapper<BatchSemester>{

    @Override
    public BatchSemester mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        BatchSemester batchSemester = new BatchSemester();
        
        batchSemester.setBatch(resultSet.getString("batch"));
        batchSemester.setYear(resultSet.getString("year"));
        batchSemester.setSemester(resultSet.getString("semester"));
        batchSemester.setSession(resultSet.getString("current_session"));
        
        return batchSemester;    
    }
    
}
