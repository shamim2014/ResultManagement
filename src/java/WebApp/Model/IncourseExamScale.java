/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

/**
 *
 * @author shamim
 */
public class IncourseExamScale 
{
    private String courseCode;
    private String session;
    private String batch;
    private double incourseExam1;
    private double incourseExam2;
    private double incourseExam3;
    private double incourseExam4;
    private int markingType;
    private int totalExam;
    
   public IncourseExamScale()
   {
       totalExam=0;
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
