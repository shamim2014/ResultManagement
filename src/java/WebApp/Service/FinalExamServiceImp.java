/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.FinalExamMark;
import WebApp.repository.FinalExamDAO;
import WebApp.repository.FinalExamDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class FinalExamServiceImp implements  FinalExamService
{
    private FinalExamDAO finalExamDAO;
    
    public FinalExamServiceImp()
    {
         finalExamDAO = new FinalExamDAOImp();
    }

    @Override
    public void saveFinalMarks(FinalExamMark finalExamMark)
    {
        finalExamDAO.save(finalExamMark);
    }

    @Override
    public void saveFinalMarks(List<FinalExamMark> finalExamMarks) 
    {
        for(FinalExamMark finalExamMark : finalExamMarks)
        {
            finalExamDAO.save(finalExamMark);
        }
       
    }

    @Override
    public boolean hasFinalMark(String courseCode, String session,String email)
    {
        return finalExamDAO.hasFinalMarks(courseCode, session,email);
    }

    @Override
    public List<FinalExamMark> gerFinalMarks(String courseCode, String session,String email) 
    {
        return finalExamDAO.getFinalMarks(courseCode, session, email);
    }
}
