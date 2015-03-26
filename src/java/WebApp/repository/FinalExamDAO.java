/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.FinalExamMark;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface FinalExamDAO 
{
    public void save(FinalExamMark finalExamMark);
    public List<FinalExamMark> getFinalMarks(String courseCode,String session,String email);
    public boolean hasFinalMarks(String courseCode,String session,String email);
}
