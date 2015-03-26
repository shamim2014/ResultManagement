/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import WebApp.repository.LabDAO;
import WebApp.repository.LabDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class LabServiceImp implements LabService
{
    private LabDAO labDAO;
    
    public LabServiceImp()
    {
        labDAO = new LabDAOImp();
    }
    @Override
    public void saveMarkingScale(LabMarkingScale lab)
    {
        labDAO.saveLabMarkingScale(lab);
    }

    @Override
    public LabMarkingScale getLabMarkingScale(String courseCode, String session)
    {
        return labDAO.getLabMarkingScale(courseCode,session);     
    }

    @Override
    public void saveLabMark(List<LabMark> labMarks) 
    {
        for(LabMark labMark : labMarks)
        {
            labDAO.saveLabMark(labMark);
        }
    }

    @Override
    public List<LabMark> getLabMark(String courseCode, String session)
    {
        return labDAO.getLabMarks(courseCode, session);
    }
}
