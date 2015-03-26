package WebApp.Model;

import java.io.Serializable;

public class FinalExamMark implements Serializable
{
     private String courseCode,session,examRoll;
     private String examinerEmail;
     private double questionOneMarks,questionTwoMarks,questionThreeMarks,questionFourMarks,questionFiveMarks,questionSixMarks,totalMarks;
     public FinalExamMark()
     {
         
     }
    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getSession() 
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public String getExamRoll() 
    {
        return examRoll;
    }

    public void setExamRoll(String examRoll) 
    {
        this.examRoll = examRoll;
    }

    public double getQuestionOneMarks()
    {
        return questionOneMarks;
    }

    public void setQuestionOneMarks(double questionOneMarks) 
    {
        this.questionOneMarks = questionOneMarks;
    }

    public double getQuestionTwoMarks() 
    {
        return questionTwoMarks;
    }

    public void setQuestionTwoMarks(double questionTwoMarks)
    {
        this.questionTwoMarks = questionTwoMarks;
    }

    public double getQuestionThreeMarks() 
    {
        return questionThreeMarks;
    }

    public void setQuestionThreeMarks(double questionThreeMarks)
    {
        this.questionThreeMarks = questionThreeMarks;
    }

    public double getQuestionFourMarks()
    {
        return questionFourMarks;
    }

    public void setQuestionFourMarks(double questionFourMarks) 
    {
        this.questionFourMarks = questionFourMarks;
    }

    public double getQuestionFiveMarks()
    {
        return questionFiveMarks;
    }

    public void setQuestionFiveMarks(double questionFiveMarks)
    {
        this.questionFiveMarks = questionFiveMarks;
    }

    public double getQuestionSixMarks() 
    {
        return questionSixMarks;
    }

    public void setQuestionSixMarks(double questionSixMarks) 
    {
        this.questionSixMarks = questionSixMarks;
    }

    public double getTotalMarks()
    {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) 
    {
        this.totalMarks = totalMarks;
    }

    public String getExaminerEmail() {
        return examinerEmail;
    }

    public void setExaminerEmail(String examinerEmail) {
        this.examinerEmail = examinerEmail;
    }
}
