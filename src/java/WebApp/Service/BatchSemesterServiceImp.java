/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.repository.BatchSemesterDAO;
import WebApp.repository.BatchSemesterDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class BatchSemesterServiceImp implements BatchSemesterService
{
    private BatchSemesterDAO batchSemesterDAO;
    
    public BatchSemesterServiceImp()
    {
         batchSemesterDAO = new BatchSemesterDAOImp();
    }
    @Override
    public BatchSemester getBatchSemester(String year, String semester, String session) 
    {
        BatchSemester batchSemester = batchSemesterDAO.getBatchSemester(year,semester,session);
        return batchSemester;
    }

    @Override
    public void save(BatchSemester batchSemester) 
    {
        batchSemesterDAO.save(batchSemester);
    }

    @Override
    public List<BatchSemester> getBatchSemester(String batch) 
    {
        return batchSemesterDAO.getBatchSemester(batch);
    }

    @Override
    public List<BatchSemester> getBatchSemester()
    {
        return batchSemesterDAO.getBatchSemester();
    }
    
}
