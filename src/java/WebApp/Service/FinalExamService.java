/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.FinalExamMark;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface FinalExamService 
{
    public void saveFinalMarks(FinalExamMark finalExamMark);
    public void saveFinalMarks(List<FinalExamMark> finalExamMarks);
    public boolean hasFinalMark(String courseCode,String session,String email);
    public List<FinalExamMark> gerFinalMarks(String courseCode,String session,String email);
}
