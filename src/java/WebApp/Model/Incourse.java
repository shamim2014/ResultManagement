/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;

/**
 *
 * @author shamim
 */
public class Incourse  extends IncourseExam implements Serializable 
{
    private double incourseExam;
    private double viva;
    private double attendance;
    private double assignment;
    private double presentation;
    private double suddentTest;
    private double totalObtainMarks;
    
    public Incourse()
    {
        
    }


    public double getIncourseExam() {
        return incourseExam;
    }

    public void setIncourseExam(double incourseExam) {
        this.incourseExam = incourseExam;
    }

    public double getViva() {
        return viva;
    }

    public void setViva(double viva) {
        this.viva = viva;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getPresentation() {
        return presentation;
    }

    public void setPresentation(double presentation) {
        this.presentation = presentation;
    }

    public double getSuddentTest() {
        return suddentTest;
    }

    public void setSuddentTest(double suddentTest) {
        this.suddentTest = suddentTest;
    }

    public double getTotalObtainMarks() {
        return totalObtainMarks;
    }

    public void setTotalObtainMarks(double totalObtainMarks) {
        this.totalObtainMarks = totalObtainMarks;
    }

}
