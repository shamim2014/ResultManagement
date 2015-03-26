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
public class IncourseMarkDistribution  implements Serializable
{
    private String courseCode;
    private String session;
    private String batch;
    private double incourseExam1;
    private double incourseExam2;
    private double incourseExam3;
    private double incourseExam4;
    private double incourseExam;
    private double viva;
    private double attendance;
    private double assignment;
    private double presentation;
    private double suddentTest;
    private double totalMarks; //40
    private int markingType; //choice
    private int totalExam; //no. in
    
    
    public IncourseMarkDistribution()
    {
        
    }

    public String getCourseCode() 
    {
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getIncourseExam1() {
        return incourseExam1;
    }

    public void setIncourseExam1(double incourseExam1) {
        this.incourseExam1 = incourseExam1;
    }

    public double getIncourseExam2() {
        return incourseExam2;
    }

    public void setIncourseExam2(double incourseExam2) {
        this.incourseExam2 = incourseExam2;
    }

    public double getIncourseExam3() {
        return incourseExam3;
    }

    public void setIncourseExam3(double incourseExam3) {
        this.incourseExam3 = incourseExam3;
    }

    public double getIncourseExam4() {
        return incourseExam4;
    }

    public void setIncourseExam4(double incourseExam4) {
        this.incourseExam4 = incourseExam4;
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

    public int getTotalExam() {
        return totalExam;
    }

    public void setTotalExam(int totalExam) {
        this.totalExam = totalExam;
    }

    public int getMarkingType() {
        return markingType;
    }

    public void setMarkingType(int markingType) {
        this.markingType = markingType;
    }
    
}
