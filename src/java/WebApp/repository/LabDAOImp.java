/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.Lab;
import WebApp.Model.LabMark;
import WebApp.Model.LabMarkingScale;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.LabMarkMapper;
import WebApp.Util.LabMarkingScaleMapper;
import java.util.List;

/**
 *
 * @author shamim
 */
public class LabDAOImp implements LabDAO
{

    @Override
    public void saveFirstInstructor(Lab lab) 
    {
        String SQL = "insert into Lab(firstExaminerEmail,course_code,session) values(?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,lab.getFirstInstructorEmail(),lab.getCourseCode(),lab.getSession());
    }

    @Override
    public void save(Lab lab)
    {
        String SQL = "insert into Lab(firstExaminerEmail,secondExaminerEmail,course_code,session) values(?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,lab.getFirstInstructorEmail(),lab.getSecondInstructorEmail(),lab.getCourseCode(),lab.getSession());
    }

    @Override
    public void saveLabMarkingScale(LabMarkingScale lab)
    {
        String SQL = "insert into Labmarkingscale(course_code,session,lab_exam,viva,attendance,assignment,presentation,assessment,report,project,totalMarks) values(?,?,?,?,?,?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,lab.getCourseCode(),lab.getSession(),lab.getLab_exam(),lab.getViva(),lab.getAttendance(),lab.getAssignment(),lab.getPresentation(),lab.getAssessment(),lab.getReport(),lab.getProject(),lab.getTotalMarks());
    }

    @Override
    public LabMarkingScale getLabMarkingScale(String courseCode, String session)
    {
        String SQL = "select * from Labmarkingscale where course_code=? and session=?";
        List<LabMarkingScale> labMarkingScales =  DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session},new LabMarkingScaleMapper());
        
        if(labMarkingScales!=null && labMarkingScales.size()!=0)
            return labMarkingScales.get(0);
        return null;
    }

    @Override
    public void saveLabMark(LabMark labMark)
    {
        String SQL ="insert into  Labmarks(course_code,session,dept_roll,lab_exam,viva,attendance,assignment,presentation,assessment,report,project,totalMarks) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,labMark.getCourseCode(),labMark.getSession(),labMark.getDept_Roll(),labMark.getLab_exam(),labMark.getViva(),labMark.getAttendance(),labMark.getAssignment(),labMark.getPresentation(),labMark.getAssessment(),labMark.getReport(),labMark.getProject(),labMark.getTotalMarks());
    }

    @Override
    public List<LabMark> getLabMarks(String courseCode, String session)
    {
        String SQL = "select * from Labmarks where course_code=? and session=?";
        List<LabMark> labMarks=DatabaseTemplate.executeQuery(SQL,new Object[]{courseCode,session}, new LabMarkMapper());
        
        if(labMarks!=null &&!labMarks.isEmpty())
            return labMarks;
        
        return null;
    }
    
}
