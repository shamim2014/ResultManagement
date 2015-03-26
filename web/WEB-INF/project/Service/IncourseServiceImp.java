/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.Incourse;
import WebApp.repository.IncourseDAO;
import WebApp.repository.IncourseDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseServiceImp implements IncourseService
{
    private IncourseDAO incourseDAO;
    
    public IncourseServiceImp()
    {
        incourseDAO = new IncourseDAOImp();
    }
    @Override
    public void saveFinal(Incourse incourse)
    {
        incourseDAO.saveFinal(incourse);
    }

    @Override
    public void distributeMarks(String courseCode, String session) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(List<Incourse> incourses)
    {
        for(Incourse incourse : incourses)
        {
            incourseDAO.save(incourse);
        }
        
    }

    @Override
    public void update(List<Incourse> incourses) 
    {
        for(Incourse incourse : incourses)
           incourseDAO.update(incourse);
    }

    @Override
    public List<Incourse> getIncourse(String courseCode, String session) 
    {
        return incourseDAO.getIncourseForSession(session, courseCode);
    }
    
}
