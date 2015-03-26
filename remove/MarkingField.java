package WebApp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MarkingField implements Serializable
{
    private String fieldName;
    private double markingScale,totalMark;
    private int evaluationTimes;
    private ArrayList<Marking> marking;
    public MarkingField()
    {
        
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public double getMarkingScale() 
    {
        return markingScale;
    }

    public void setMarkingScale(double markingScale)
    {
        this.markingScale = markingScale;
    }

    public double getTotalMark()
    {
        return totalMark;
    }

    public void setTotalMark(double totalMark) 
    {
        this.totalMark = totalMark;
    }

    public int getEvaluationTimes()
    {
        return evaluationTimes;
    }

    public void setEvaluationTimes(int evaluationTimes) 
    {
        this.evaluationTimes = evaluationTimes;
    }

    public ArrayList<Marking> getMarking()
    {
        return marking;
    }

    public void setMarking(ArrayList<Marking> marking) 
    {
        this.marking = marking;
    }
}
