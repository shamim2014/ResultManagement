/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author shamim
 */
public class StudentTabulationHeader implements Serializable
{
   private int theoryCourse;
   private int labCourse;
   private int semister;
   private List<Course> lab;
   private List<Course> Theory;
   
    public int getTheoryCourse()
    {
        return theoryCourse;
    }

    public void setTheoryCourse(int theoryCourse) {
        this.theoryCourse = theoryCourse;
    }

    public int getLabCourse() {
        return labCourse;
    }

    public void setLabCourse(int labCourse) {
        this.labCourse = labCourse;
    }

    public int getSemister() {
        return semister;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public List<Course> getLab() {
        return lab;
    }

    public void setLab(List<Course> lab) {
        this.lab = lab;
    }

    public List<Course> getTheory() {
        return Theory;
    }

    public void setTheory(List<Course> Theory) {
        this.Theory = Theory;
    }
}
