package WebApp.Model;

import java.io.Serializable;

public class Marking implements Serializable
{
    private String fieldName;
    private boolean present;
    private double markingScale,totalMark;
    public Marking()
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

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
