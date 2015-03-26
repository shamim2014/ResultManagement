/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.BatchSemester;
import WebApp.Util.BatchSemesterMapper;
import WebApp.Util.DatabaseTemplate;
import java.util.List;

/**
 *
 * @author shamim
 */
public class BatchSemesterDAOImp implements BatchSemesterDAO
{

    @Override
    public void save(BatchSemester batchSemester) 
    {
        String SQL="insert into BatchSemester(batch,year,semester,current_session) values(?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,batchSemester.getBatch(),batchSemester.getYear(),batchSemester.getSemester(),batchSemester.getSession());
    }
    
    @Override
    public BatchSemester getBatchSemester(String year, String semester, String session) 
    {
        String SQL = "select * from BatchSemester where year= ? and semester=? and current_session=?";
        List<BatchSemester> batchSemesters = DatabaseTemplate.executeQuery(SQL,new Object[]{year,semester,session}, new BatchSemesterMapper());
        
        if(batchSemesters!=null)
            return  batchSemesters.get(0);
        else
            return null;
    }  

    @Override
    public List<BatchSemester> getBatchSemester(String batch) 
    {
        String SQL = "select * from BatchSemester where batch= ?";
        List<BatchSemester> batchSemesters = DatabaseTemplate.executeQuery(SQL,new Object[]{batch}, new BatchSemesterMapper());
        if(batchSemesters!=null && !batchSemesters.isEmpty())
            return batchSemesters;
        return null;
    }

    @Override
    public List<BatchSemester> getBatchSemester() 
    {
        String SQL = "select * from BatchSemester order by batch";
        List<BatchSemester> batchSemesters = DatabaseTemplate.queryForObject(SQL,new BatchSemesterMapper());
        if(batchSemesters!=null && !batchSemesters.isEmpty())
            return batchSemesters;
        return null;
    }

    @Override
    public BatchSemester getBatchSemester(String year, String semester) 
    {
        String SQL = "select * from BatchSemester where year= ? and semester=?";
        List<BatchSemester> batchSemesters = DatabaseTemplate.executeQuery(SQL,new Object[]{year,semester},new BatchSemesterMapper());
        if(batchSemesters!=null && !batchSemesters.isEmpty())
            return batchSemesters.get(0);
        return null;
    }

    @Override
    public BatchSemester getBatch(String courseCode, String session) 
    {
        String SQL = "SELECT batch, year, semester, current_session FROM course NATURAL JOIN batchsemester WHERE course_code = ? AND current_session = ?";
        List<BatchSemester> batchSemesters = DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session},new BatchSemesterMapper());
        
        if(batchSemesters!=null && !batchSemesters.isEmpty())
            return batchSemesters.get(0);
        return null;
    }

    @Override
    public BatchSemester getBatch(String year)
    {
       String SQL = "select * from BatchSemester where year= ?";
        List<BatchSemester> batchSemesters = DatabaseTemplate.executeQuery(SQL,new Object[]{year}, new BatchSemesterMapper());
        if(batchSemesters!=null && !batchSemesters.isEmpty())
            return batchSemesters.get(0);
        return null;
    }
    
}
