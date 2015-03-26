/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import java.util.List;


public interface BatchSemesterService 
{
    public void save(BatchSemester batchSemester);
    public BatchSemester getBatchSemester(String year,String semester,String session);
    public List<BatchSemester> getBatchSemester(String batch);
    public List<BatchSemester> getBatchSemester();
}
