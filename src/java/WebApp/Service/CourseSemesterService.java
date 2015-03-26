/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.CourseSemester;

/**
 *
 * @author shamim
 */
public interface CourseSemesterService 
{
    public void save(CourseSemester courseSemester);
    public CourseSemester getCourseSemester(String year,String semester);
}
