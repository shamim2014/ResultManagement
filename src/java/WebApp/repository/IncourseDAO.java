/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Incourse;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface IncourseDAO 
{
    public void saveFinal(Incourse incourse);
    public void save(Incourse incourse);
    public List<Incourse> getIncourseForAllStudent(String session,String courseCode);
    public List<Incourse> getIncourseForSession(String session,String courseCode);
    public void update(Incourse incourse);
}
