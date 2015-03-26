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
public class LabMark implements Serializable
{
    private String courseCode;
    private String session;
    private String dept_Roll;
    private double lab_exam;
    private double viva;
    private double attendance;
    private double assignment;
    private double presentation;
    private double assessment;
    private double report;
    private double project;
    private double totalMarks;
    
    public LabMark()
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

    public double getLab_exam() {
        return lab_exam;
    }

    public void setLab_exam(double lab_exam) {
        this.lab_exam = lab_exam;
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

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    public double getReport() {
        return report;
    }

    public void setReport(double report) {
        this.report = report;
    }

    public double getProject() {
        return project;
    }

    public void setProject(double project) {
        this.project = project;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getDept_Roll() {
        return dept_Roll;
    }

    public void setDept_Roll(String dept_Roll) {
        this.dept_Roll = dept_Roll;
    }
}
