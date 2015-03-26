/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.CourseSemester;
import WebApp.repository.CourseSemesterDAO;
import WebApp.repository.CourseSemesterDAOImp;

/**
 *
 * @author shamim
 */
public class CourseSemesterServiceImp implements CourseSemesterService
{
    private CourseSemesterDAO courseSemesterDAO;
    
    public CourseSemesterServiceImp()
    {
        courseSemesterDAO = new CourseSemesterDAOImp();
    }
    @Override
    public CourseSemester getCourseSemester(String year, String semester) 
    {
        CourseSemester courseSemester =courseSemesterDAO.getCourseSemester(year, semester);
        return courseSemester;
    }

    @Override
    public void save(CourseSemester courseSemester)
    {
        courseSemesterDAO.saveCourseSemester(courseSemester);
    }
    
}
