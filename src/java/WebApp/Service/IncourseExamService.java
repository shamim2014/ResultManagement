/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.IncourseExam;
import WebApp.Model.IncourseExamScale;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface IncourseExamService 
{
    public List<IncourseExam> getIncourseExam();
    public List<IncourseExam> getIncourseExam(String courseCode, String session,double scale);
    public void saveIncourseExam(IncourseExam incourseExam);
    public void saveIncourseExam(List<IncourseExam> incourseExams, IncourseExamScale incourseExamScale);
    public void saveIncourseExamScale(IncourseExamScale incourseExamScale);
    public void setMarkingType(String courseCode, String session, int markingType);
}
