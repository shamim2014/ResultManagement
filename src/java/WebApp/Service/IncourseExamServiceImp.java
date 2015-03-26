/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.Model.IncourseExam;
import WebApp.Model.IncourseExamScale;
import WebApp.Util.Sorter;
import WebApp.repository.BatchSemesterDAO;
import WebApp.repository.BatchSemesterDAOImp;
import WebApp.repository.IncourseExamDAO;
import WebApp.repository.IncourseExamDAOImp;
import WebApp.repository.IncourseExamScaleDAO;
import WebApp.repository.IncourseExamScaleDAOImp;
import java.util.List;

/**
 *
 * @author shamim
 */
public class IncourseExamServiceImp implements IncourseExamService
{
    private IncourseExamScaleDAO incourseExamScaleDAO;
    private IncourseExamDAO incourseExamDAO;
    
    public IncourseExamServiceImp()
    {
        incourseExamScaleDAO = new IncourseExamScaleDAOImp();
        incourseExamDAO = new IncourseExamDAOImp();
    }
    @Override
    public List<IncourseExam> getIncourseExam() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveIncourseExam(IncourseExam incourseExam)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveIncourseExamScale(IncourseExamScale incourseExamScale) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveIncourseExam(List<IncourseExam> incourseExams, IncourseExamScale incourseExamScale) 
    {
        IncourseExamScale inExamScale =  incourseExamScaleDAO.getIncourseExamScale(incourseExamScale.getCourseCode(),incourseExamScale.getSession());
        BatchSemesterDAO batchSemesterDAO = new BatchSemesterDAOImp();
        
        BatchSemester batchSemester = batchSemesterDAO.getBatch(incourseExamScale.getCourseCode(), incourseExamScale.getSession());
       
        incourseExamScale.setBatch(batchSemester.getBatch());
        if(inExamScale==null)
        {
            incourseExamScaleDAO.save(incourseExamScale);
            
            for(IncourseExam incourseExam : incourseExams)
            {
                incourseExam.setBatch(batchSemester.getBatch());
                incourseExamDAO.save(incourseExam);
            }
        }
        else if(incourseExamScale.getIncourseExam1()!=0.0)
        {
            incourseExamScaleDAO.saveFirstIncourseExamScale(incourseExamScale);
            
            for(IncourseExam incourseExam : incourseExams)
            {
                incourseExam.setBatch(batchSemester.getBatch());
                incourseExamDAO.saveFirstIncourseExam(incourseExam);
            }
        }
        else if(incourseExamScale.getIncourseExam2()!=0.0)
        {
            incourseExamScaleDAO.saveSecondIncourseExamScale(incourseExamScale);
            
            for(IncourseExam incourseExam : incourseExams)
            {
                incourseExam.setBatch(batchSemester.getBatch());
                incourseExamDAO.saveSecondIncourseExam(incourseExam);
            }
        }
        else if(incourseExamScale.getIncourseExam3()!=0.0)
        {
            incourseExamScaleDAO.saveThirdIncourseExamScale(incourseExamScale);
            for(IncourseExam incourseExam : incourseExams)
            {
                incourseExam.setBatch(batchSemester.getBatch());
                incourseExamDAO.saveThirdIncourseExam(incourseExam);
            }
        }
        else if(incourseExamScale.getIncourseExam4()!=0.0)
        {
            incourseExamScaleDAO.saveFirstIncourseExamScale(incourseExamScale);
            for(IncourseExam incourseExam : incourseExams)
            {
                incourseExam.setBatch(batchSemester.getBatch());
                incourseExamDAO.saveFourthIncourseExam(incourseExam);
            }
        }
    }

    @Override
    public List<IncourseExam> getIncourseExam(String courseCode, String session,double scale) 
    {
        List<IncourseExam> incourseExams = incourseExamDAO.getIncourses(courseCode, session);
        IncourseExamScale incourseExamScales = incourseExamScaleDAO.getIncourseExamScale(courseCode, session);
        List<Double> marks;
        double exam1=0,exam2=0,exam3=0,exam4=0;
        
        for(IncourseExam incourseExam:incourseExams)
        {
            if(incourseExamScales.getIncourseExam1()>0.0)
              exam1=incourseExam.getIncourseExam1()/incourseExamScales.getIncourseExam1();
            if(incourseExamScales.getIncourseExam2()>0.0)
              exam2=incourseExam.getIncourseExam2()/incourseExamScales.getIncourseExam2();
            if(incourseExamScales.getIncourseExam3()>0.0)
              exam3=incourseExam.getIncourseExam3()/incourseExamScales.getIncourseExam3();
            if(incourseExamScales.getIncourseExam4()>0.0)
              exam4=incourseExam.getIncourseExam4()/incourseExamScales.getIncourseExam4();
            
            marks = Sorter.sort(exam1,exam2,exam3,exam4);
            
            if(incourseExamScales.getMarkingType()==1)
            {
                incourseExam.setIncourseFinal(marks.get(marks.size()-1)*scale);
            }
            else if(incourseExamScales.getMarkingType()==2)
            {
                incourseExam.setIncourseFinal((marks.get(marks.size()-1)+marks.get(marks.size()-2))*scale/2);
            }
            else if(incourseExamScales.getMarkingType()==3)
            {
                double mark=0;
                for(Double m:marks)
                    mark+=m;
                incourseExam.setIncourseFinal(mark*scale/incourseExamScales.getTotalExam());
            }
            else if(incourseExamScales.getMarkingType()==4)
            {
                incourseExam.setIncourseFinal(0);
            }
        }
        
        return incourseExams;
    }

    @Override
    public void setMarkingType(String courseCode, String session, int markingType) 
    {
        incourseExamScaleDAO.setMarkingType(courseCode, session, markingType);
    }
    
}
