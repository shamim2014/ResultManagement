/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;

/**
 *
 * @author shamim
 */
public interface IncourseMarkingScaleDAO 
{
    public void save(IncourseMarkScale incourseMarkScale);
    public IncourseMarkScale getIncourseMarkScale(String session,String courseCode);
    public IncourseMarkDistribution getMarkDistribution(String session,String courseCode);
    
}
