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
public class IncourseMarkScale implements Serializable
{
    private String courseCode;
    private String session;
    private double incourseExam;
    private double viva;
    private double attendance;
    private double assignment;
    private double presentation;
    private double suddentTest;
    private double totalMarks;
    
     public IncourseMarkScale()
     {
         
     }
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }
}
