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
public class MarkingStructure implements Serializable
{
    private String courseCode;
    private String session;
    private EvaluationMarks evaluationMarks;
   
    public MarkingStructure()
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

    public EvaluationMarks getEvaluationMarks() 
    {
        return evaluationMarks;
    }

    public void setEvaluationMarks(EvaluationMarks evaluationMarks)
    {
        this.evaluationMarks = evaluationMarks;
    }
}
