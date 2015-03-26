

package WebApp.Model;

import java.io.Serializable;
import java.util.Hashtable;


public class Tabulation implements Serializable
{
    private String registration;
    private String registrationSession;
    private String examRoll;
    private String dept_Roll;
    private String examYear;
    private String year;
    private String semester;
    private String hall;
    private int totalCourse;
    private double totalCredit;
    private double totalPoint; //credit*point
    private double sgpa;
    private double totalMarks;
    private Hashtable<String,Double>coureseCodeToPoint;
   
    public Tabulation()
    {
        totalCourse=0;
        coureseCodeToPoint = new Hashtable<String, Double>();
    }

    public void remove(String courseCode)
    {
        coureseCodeToPoint.remove(courseCode);
    }
    public String getRegistration() 
    {
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
    public int getTotalCourse()
    {
        return totalCourse;
    }
    public void setCoursePoint(String courseCode,double point)
    {
        if(courseCode!=null)
        {
             this.coureseCodeToPoint.put(courseCode,point);
             totalCourse++;
        }   
    }
    public double getCoursePoint(String courseCode)
    {
        //System.out.println(coureseCodeToPoint.isEmpty());
        return coureseCodeToPoint.get(courseCode);
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getDept_Roll() {
        return dept_Roll;
    }

    public void setDept_Roll(String dept_Roll) {
        this.dept_Roll = dept_Roll;
    }

    public double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        this.totalPoint += totalPoint;
    }

    public Hashtable<String,Double> getCoureseCodeToPoint() {
        return coureseCodeToPoint;
    }

    public void setCoureseCodeToPoint(Hashtable<String,Double> coureseCodeToPoint) {
        this.coureseCodeToPoint = coureseCodeToPoint;
    }

    public double getSgpa() {
        return sgpa;
    }

    public void setSgpa(double sgpa) {
        this.sgpa = sgpa;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }
    
}
