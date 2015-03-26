/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseExamScale;

/**
 *
 * @author shamim
 */
public interface IncourseExamScaleDAO 
{
    public void save(IncourseExamScale incourseExamScale);
    public void saveFirstIncourseExamScale(IncourseExamScale incourseExamScale);
    public void saveSecondIncourseExamScale(IncourseExamScale incourseExamScale);
    public void saveThirdIncourseExamScale(IncourseExamScale incourseExamScale);
    public void saveFourthIncourseExamScale(IncourseExamScale incourseExamScale);
    public IncourseExamScale getIncourseExamScale(String courseCode,String session);
    public void setMarkingType(String courseCode,String session,int markingType);
    
}
