/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author shamim
 */
public class CourseMarks implements Serializable
{
    private String registration;
    private String registrationSession;
    private String examRoll;
    private String dept_Roll;
    private String courseCode;
    private String session;
    private String examYear;
    private String year;
    private String semester;
    private String hall;
    private double incourseMarks;
    private double finalMarks;
    private double totalMarks;
    
    public CourseMarks()
    {
        
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getRegistrationSession() {
        return registrationSession;
    }

    public void setRegistrationSession(String registrationSession) {
        this.registrationSession = registrationSession;
    }

    public String getExamRoll() {
        return examRoll;
    }

    public void setExamRoll(String examRoll) {
        this.examRoll = examRoll;
    }

    public String getDept_Roll() {
        return dept_Roll;
    }

    public void setDept_Roll(String dept_Roll) {
        this.dept_Roll = dept_Roll;
    }

    public String getExamYear() {
        return examYear;
    }

    public void setExamYear(String examYear) {
        this.examYear = examYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public double getTotalMarks() 
    {
        totalMarks=incourseMarks+finalMarks;
        return totalMarks;
    }

    public double getIncourseMarks() {
        return incourseMarks;
    }

    public void setIncourseMarks(double incourseMarks) {
        this.incourseMarks = incourseMarks;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(double finalMarks) {
        this.finalMarks = finalMarks;
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
}
