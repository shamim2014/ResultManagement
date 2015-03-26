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
public class StudentTabulation implements Serializable
{
     private String nameOfHall;
     private String registration;
     private String registrationSession;
     private String dept_Roll;
     private String examRoll;
     private String name;
     private int courseNo;
     private List<CourseMarks> theory;
     private List<CourseMarks>lab;
     private int semister;
     private double sgpa;
     private double currentWeightedPoint;
     private double prevouseWeightedPoint;
     private double prevouseTotalCredit;
     private double currentTotalMarks;
     private double fourYearWeightedPoint;
     private double threeYearWeightedPoint;
     private double twoYearWeightedPoint;
     private double oneYearWeightedPoint;
     private double fourYearCredit;
     private double threeYearCredit;
     private double twoYearCredit;
     private double oneYearCredit;
     private double cgpa;
     private double result;
     private String remark;
     private double totalCredit;
     private double totalWeightedPoint;
     private double currentTotalCredit;
     
     public StudentTabulation()
     {
         
     }

    public String getNameOfHall() {
        return nameOfHall;
    }

    public void setNameOfHall(String nameOfHall) {
        this.nameOfHall = nameOfHall;
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

    public String getDept_Roll() {
        return dept_Roll;
    }

    public void setDept_Roll(String dept_Roll) {
        this.dept_Roll = dept_Roll;
    }

    public String getExamRoll() {
        return examRoll;
    }

    public void setExamRoll(String examRoll) {
        this.examRoll = examRoll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public List<CourseMarks> getTheory() {
        return theory;
    }

    public void setTheory(List<CourseMarks> theory) {
        this.theory = theory;
    }

    public List<CourseMarks> getLab() {
        return lab;
    }

    public void setLab(List<CourseMarks> lab) {
        this.lab = lab;
    }

    public int getSemister() {
        return semister;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public double getSgpa() {
        return sgpa;
    }

    public void setSgpa(double sgpa) {
        this.sgpa = sgpa;
    }

    public double getCurrentWeightedPoint() {
        return currentWeightedPoint;
    }

    public void setCurrentWeightedPoint(double currentWeightedPoint) {
        this.currentWeightedPoint = currentWeightedPoint;
    }

    public double getPrevouseWeightedPoint() {
        return prevouseWeightedPoint;
    }

    public void setPrevouseWeightedPoint(double prevouseWeightedPoint) {
        this.prevouseWeightedPoint = prevouseWeightedPoint;
    }

    public double getCurrentTotalMarks() {
        return currentTotalMarks;
    }

    public void setCurrentTotalMarks(double currentTotalMarks) {
        this.currentTotalMarks = currentTotalMarks;
    }

    public double getFourYearWeightedPoint() {
        return fourYearWeightedPoint;
    }

    public void setFourYearWeightedPoint(double fourYearWeightedPoint) {
        this.fourYearWeightedPoint = fourYearWeightedPoint;
    }

    public double getThreeYearWeightedPoint() {
        return threeYearWeightedPoint;
    }

    public void setThreeYearWeightedPoint(double threeYearWeightedPoint) {
        this.threeYearWeightedPoint = threeYearWeightedPoint;
    }

    public double getTwoYearWeightedPoint() {
        return twoYearWeightedPoint;
    }

    public void setTwoYearWeightedPoint(double twoYearWeightedPoint) {
        this.twoYearWeightedPoint = twoYearWeightedPoint;
    }

    public double getOneYearWeightedPoint() {
        return oneYearWeightedPoint;
    }

    public void setOneYearWeightedPoint(double oneYearWeightedPoint) {
        this.oneYearWeightedPoint = oneYearWeightedPoint;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public double getTotalWeightedPoint() {
        return totalWeightedPoint;
    }

    public void setTotalWeightedPoint(double totalWeightedPoint) {
        this.totalWeightedPoint = totalWeightedPoint;
    }

    public double getCurrentTotalCredit() {
        return currentTotalCredit;
    }

    public void setCurrentTotalCredit(double currentTotalCredit) {
        this.currentTotalCredit = currentTotalCredit;
    }

    public double getPrevouseTotalCredit() {
        return prevouseTotalCredit;
    }

    public void setPrevouseTotalCredit(double prevouseTotalCredit) {
        this.prevouseTotalCredit = prevouseTotalCredit;
    }

    public double getFourYearCredit() {
        return fourYearCredit;
    }

    public void setFourYearCredit(double fourYearCredit) {
        this.fourYearCredit = fourYearCredit;
    }

    public double getThreeYearCredit() {
        return threeYearCredit;
    }

    public void setThreeYearCredit(double threeYearCredit) {
        this.threeYearCredit = threeYearCredit;
    }

    public double getTwoYearCredit() {
        return twoYearCredit;
    }

    public void setTwoYearCredit(double twoYearCredit) {
        this.twoYearCredit = twoYearCredit;
    }

    public double getOneYearCredit() {
        return oneYearCredit;
    }

    public void setOneYearCredit(double oneYearCredit) {
        this.oneYearCredit = oneYearCredit;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
     
}
