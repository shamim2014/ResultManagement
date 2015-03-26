/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.TeacherCourse;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface TeacherCourseDAO 
{
    public List<TeacherCourse> getFirstTheoryTeacherCourse(String email);
    public List<TeacherCourse> getSecondTheoryTeacherCourse(String email);
    public List<TeacherCourse> getFirstLabTeacherCourse(String email);
    public List<TeacherCourse> getSecondLabTeacherCourse(String email);
}
