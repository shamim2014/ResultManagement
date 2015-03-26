
package WebApp.Model;


public class TheorySubject extends Course
{
    private String session;
    private String firstExaminerEmail,secondExaminerEmail,thirdExaminerEmail;
    
    public TheorySubject()
    {
        
    }
    public String getSession() 
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public String getFirstExaminerEmail() {
        return firstExaminerEmail;
    }

    public void setFirstExaminerEmail(String firstExaminerEmail) {
        this.firstExaminerEmail = firstExaminerEmail;
    }

    public String getSecondExaminerEmail() {
        return secondExaminerEmail;
    }

    public void setSecondExaminerEmail(String secondExaminerEmail) {
        this.secondExaminerEmail = secondExaminerEmail;
    }

    public String getThirdExaminerEmail() {
        return thirdExaminerEmail;
    }

    public void setThirdExaminerEmail(String thirdExaminerEmail) {
        this.thirdExaminerEmail = thirdExaminerEmail;
    }

    }
