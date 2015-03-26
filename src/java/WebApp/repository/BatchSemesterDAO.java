/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.BatchSemester;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface BatchSemesterDAO 
{
    public BatchSemester getBatchSemester(String year,String semester,String session);
    public BatchSemester getBatchSemester(String year,String semester);
    public void save(BatchSemester batchSemester);
    public List<BatchSemester> getBatchSemester(String batch);
    public List<BatchSemester> getBatchSemester();
    public BatchSemester getBatch(String courseCode,String session);
    public BatchSemester getBatch(String year);
}
