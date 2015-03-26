/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.IncourseMarkDistribution;
import WebApp.Model.IncourseMarkScale;
import WebApp.repository.IncourseMarkingScaleDAO;
import WebApp.repository.IncourseMarkingScaleDAOImp;

/**
 *
 * @author shamim
 */
public class MarkDistributionServiceImp implements MarkDistributionService
{
    private IncourseMarkingScaleDAO incourseMarkingScaleDAO;
    
    public MarkDistributionServiceImp()
    {
        incourseMarkingScaleDAO = new IncourseMarkingScaleDAOImp();
    }
    /*@Override
    public void createMarkingScope(String courseCode,String session,ArrayList<String> markingFieldNames)
    {
        ArrayList<MarkingField> markingFields = new ArrayList<MarkingField>();
        MarkingField markingField;
        
        for(int i=0;i<markingFields.size();i++)
        {
            markingField = new MarkingField();
            markingField.setFieldName(markingFieldNames.get(i));
            markingFields.add(markingField);
        }
        EvaluationMarks evaluationMarks = new EvaluationMarks();
        evaluationMarks.setMarkingField(markingFields);
        evaluationMarks.setNumberOfField(markingFields.size());
   
        CourseDAO courseDAO = new CourseDAOImp();
        Course course = courseDAO.getCourse(courseCode);
        
        StudentDAO studentDAO = new StudentDAOImp();
        //List<Student> students= studentDAO.getStudentByYearSemesterAndSession(course.getYear(), course.getSemester(), session);
          
       // List<Incourse> incourses = createIncourseEntry(courseCode, students, evaluationMarks);
    }
    private List<Incourse> createIncourseEntry(String courseCode,List<Student> students,EvaluationMarks evaluationMarks)
    {
        List<Incourse> incourses = new ArrayList<Incourse>();
        Iterator iterator = students.iterator();
        Student student;
        Incourse incourse;
        
        while(iterator.hasNext())
        {
            incourse= new  Incourse();
            student =(Student) iterator.next();
            incourse.setCourseCode(courseCode);
            incourse.setDeptRoll(student.getDeptRoll());
            incourse.setSession(student.getSession());
            //incourse.setEvaluationMarks(evaluationMarks);
        }
        return incourses;
    }
    private MarkingStructure createMarkingStructure(String courseCode,String session,EvaluationMarks evaluationMarks)
    {
        MarkingStructure markingStructure = new MarkingStructure();
        
        markingStructure.setCourseCode(courseCode);
        markingStructure.setSession(session);
        markingStructure.setEvaluationMarks(evaluationMarks);
        
        return markingStructure;
    }
*/
    @Override
    public void createMarkDistribution(IncourseMarkScale incourseMarkScale) 
    {
        incourseMarkingScaleDAO.save(incourseMarkScale);   
    }

    @Override
    public IncourseMarkDistribution getMarkDistribution(String session, String courseCode)
    {
        IncourseMarkDistribution incourseMarkDistribution=incourseMarkingScaleDAO.getMarkDistribution(session,courseCode);
        if(incourseMarkDistribution!=null)
            return incourseMarkDistribution;
        return null;
    }
    
}
