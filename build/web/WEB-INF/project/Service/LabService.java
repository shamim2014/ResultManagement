/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface LabService 
{
    public void saveMarkingScale(LabMarkingScale lab);
    public LabMarkingScale getLabMarkingScale(String courseCode,String session);
    public void saveLabMark(List<LabMark> labMarks);
    public List<LabMark> getLabMark(String courseCode,String session);
}
