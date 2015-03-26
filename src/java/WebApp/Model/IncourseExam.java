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
public class IncourseExam implements Serializable
{
    private String courseCode;
    private String session;
    private String batch;
    private String dept_Roll;
    private double incourseExam1;
    private double incourseExam2;
    private double incourseExam3;
    private double incourseExam4;
    private double incourseFinal;
    
    public IncourseExam()
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDept_Roll() {
        return dept_Roll;
    }

    public void setDept_Roll(String dept_Roll) {
        this.dept_Roll = dept_Roll;
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

    public double getIncourseFinal() {
        return incourseFinal;
    }

    public void setIncourseFinal(double incourseFinal) {
        this.incourseFinal = incourseFinal;
    }
    
}
