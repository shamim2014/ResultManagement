/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Lab;
import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface LabDAO 
{
    public void save(Lab lab);
    public void saveFirstInstructor(Lab lab);
    public void saveLabMarkingScale(LabMarkingScale lab);
    public LabMarkingScale getLabMarkingScale(String courseCode, String session);
    public void saveLabMark(LabMark labMark);
    public List<LabMark> getLabMarks(String courseCode, String session);
}
