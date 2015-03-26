package WebApp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class EvaluationMarks implements Serializable
{
    private int numberOfField,markingScale;
    private ArrayList<MarkingField> markingField;
    private double totalMark;
    public EvaluationMarks()
    {
        
    }

    public int getNumberOfField() 
    {
        return numberOfField;
    }

    public void setNumberOfField(int numberOfField) 
    {
        this.numberOfField = numberOfField;
    }

    public ArrayList<MarkingField> getMarkingField() 
    {
        return markingField;
    }

    public void setMarkingField(ArrayList<MarkingField> markingField) 
    {
        this.markingField = markingField;
    }

    public int getMarkingScale() 
    {
        return markingScale;
    }

    public void setMarkingScale(int markingScale) 
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
}
