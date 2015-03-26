/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseExam;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface IncourseExamDAO 
{
    public List<IncourseExam> getIncourses(String courseCode,String session);
    public void save(IncourseExam incourseExam);
    public void saveFirstIncourseExam(IncourseExam incourseExam);
    public void saveSecondIncourseExam(IncourseExam incourseExam);
    public void saveThirdIncourseExam(IncourseExam incourseExam);
    public void saveFourthIncourseExam(IncourseExam incourseExam);
}
