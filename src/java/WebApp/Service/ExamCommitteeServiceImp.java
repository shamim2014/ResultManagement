/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.BatchSemester;
import WebApp.Model.ExamCommittee;
import WebApp.Model.Teacher;
import WebApp.Model.User;
import WebApp.Util.Email;
import WebApp.Util.Mail;
import WebApp.repository.BatchSemesterDAO;
import WebApp.repository.BatchSemesterDAOImp;
import WebApp.repository.ExamCommitteeDAO;
import WebApp.repository.ExamCommitteeDAOImp;
import WebApp.repository.TeacherDAO;
import WebApp.repository.TeacherDAOImp;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shamim
 */
public class ExamCommitteeServiceImp implements ExamCommitteeService
{
    private ExamCommitteeDAO examCommitteeDAO;
    
    public ExamCommitteeServiceImp()
    {
        examCommitteeDAO = new ExamCommitteeDAOImp();
    }
    @Override
    public void saveExamCommittee(ExamCommittee examCommittee) 
    {
        User chairman = new User();
        User firstMember = new User();
        User secondMember = new User();
        chairman.setEmail(examCommittee.getChairmanEmail());
        firstMember.setEmail(examCommittee.getFirstMemberEmail());
        secondMember.setEmail(examCommittee.getSecondMemberEmail());
        examCommitteeDAO.saveExamCommittee(examCommittee,chairman,firstMember,secondMember);
        
    }
    
    private void sendEmail(ExamCommittee examCommittee,User chairman,User firstMember,User secondMember)
    {
       String emailSubject =""+examCommittee.getYear()+" year, "+examCommittee.getSession()+" session Examination committee";
       TeacherDAO teacherDAO = new TeacherDAOImp();
       Teacher teacher = teacherDAO.getTeacherByEmail(examCommittee.getChairmanEmail());
       String chairmanBody ="Dear "+teacher.getName()+"\n\n";
       chairmanBody +="You have selected as chairman of "+examCommittee.getYear()+" year, "+examCommittee.getSession()+" session Examination committee";
       
       if(chairman.getPassWord()==null)
       {
           chairmanBody +="and your user name/email is "+examCommittee.getChairmanEmail();
       }
       else
       {
           chairmanBody +=", your user name/email is "+examCommittee.getChairmanEmail()+"and password is "+chairman.getPassWord()+".";
       }
      
       teacher = teacherDAO.getTeacherByEmail(examCommittee.getFirstMemberEmail());
       String memberOneBody ="Dear "+teacher.getName()+"\n\n";
       memberOneBody +="You have selected as member of "+examCommittee.getYear()+" year, "+examCommittee.getSession()+" session Examination committee";
       
       if(firstMember.getPassWord()==null)
       {
           chairmanBody +="and your user name/email is "+examCommittee.getFirstMemberEmail();
       }
       else
       {
           chairmanBody +=", your user name/email is "+examCommittee.getFirstMemberEmail()+"and password is "+firstMember.getPassWord()+".";
       }
       teacher = teacherDAO.getTeacherByEmail(examCommittee.getSecondMemberEmail());
       
       String member2Body ="Dear "+teacher.getName()+"\n\n";
       member2Body +="You have selected as member of "+examCommittee.getYear()+" year, "+examCommittee.getSession()+" session Examination committee";
       
       if(secondMember.getPassWord()==null)
       {
           member2Body +="and your user name/email is "+examCommittee.getSecondMemberEmail();
       }
       else
       {
           member2Body +=", your user name/email is "+examCommittee.getSecondMemberEmail()+"and password is "+secondMember.getPassWord()+".";
       }
    }

    @Override
    public List<Teacher> getExamCommitteeTeacher(ExamCommittee examCommittee)
    {
        TeacherDAO teacherDAO = new TeacherDAOImp();
        List<Teacher> teachers = teacherDAO.getExamCommitteeTeacher(examCommittee);
        return teachers;
    }

    @Override
    public List<String> getExamCommitteeYear(String email) 
    {
        List<ExamCommittee> examCommittees = examCommitteeDAO.getExamCommitteeTeacher(email);
        
        if(examCommittees!=null)
        {
            List<String> examYear= new ArrayList<String>();
            
            for(ExamCommittee examCommittee : examCommittees)
            {
                examYear.add(examCommittee.getYear());
            }
            return examYear;
        }
        return null;
    }

    @Override
    public void update(ExamCommittee examCommittee)
    {
       if(examCommittee.getChairmanEmail()!=null)
           examCommitteeDAO.updateChairman(examCommittee.getChairmanEmail(), examCommittee.getYear(), examCommittee.getSession());
       if(examCommittee.getFirstMemberEmail()!=null)
           examCommitteeDAO.updateFirst(examCommittee.getFirstMemberEmail(), examCommittee.getYear(), examCommittee.getSession());
       if(examCommittee.getSecondMemberEmail()!=null)
           examCommitteeDAO.updateSecond(examCommittee.getSecondMemberEmail(), examCommittee.getYear(), examCommittee.getSession());
    }

    @Override
    public ExamCommittee getExamCommitteeYear(String year, String session) 
    {
        return examCommitteeDAO.getExamCommitteeTeacher(year, session);
    }

    @Override
    public ExamCommittee getExamCommittee(String year) 
    {
        BatchSemesterDAO batchSemesterDAO = new BatchSemesterDAOImp();
        BatchSemester batchSemester = batchSemesterDAO.getBatch(year);
        return examCommitteeDAO.getExamCommitteeTeacher(year,batchSemester.getSession());
    }
    
}
