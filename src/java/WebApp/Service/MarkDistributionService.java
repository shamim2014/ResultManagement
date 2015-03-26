/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;
import java.util.ArrayList;

/**
 *
 * @author shamim
 */
public interface MarkDistributionService 
{
    //public void createMarkingScope(String courseCode,String session,ArrayList<String> markingFields);
    public void createMarkDistribution(IncourseMarkScale incourseMarkScale);
    public IncourseMarkDistribution getMarkDistribution(String session, String courseCode);
}
