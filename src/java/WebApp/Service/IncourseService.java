/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Incourse;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface IncourseService 
{
    public void distributeMarks(String courseCode, String session);
    public void saveFinal(Incourse incourse);
    public void save(List<Incourse> incourses);
    public void update(List<Incourse> incourses);
    public List<Incourse> getIncourse(String courseCode, String session);
}
