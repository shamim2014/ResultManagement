package WebApp.Model;

import java.io.Serializable;

public class Student implements Serializable
{
    private String deptRoll,name,gender,session,batch,examRoll,phone,email,year,semester;
    private String hall;
    private String registration;
    private String registrationSession;
    
    public Student()
    {
        
    }

    public String getDeptRoll()
    {
        return deptRoll;
    }

    public void setDeptRoll(String deptRoll)
    {
        this.deptRoll = deptRoll;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getSession()
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public String getBatch() 
    {
        return batch;
    }

    public void setBatch(String batch)
    {
        this.batch = batch;
    }

    public String getExamRoll()
    {
        return examRoll;
    }

    public void setExamRoll(String examRoll)
    {
        this.examRoll = examRoll;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getSemester() 
    {
        return semester;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
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
    
}
