/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.ExamCommittee;
import WebApp.Model.User;
import WebApp.Util.DatabaseTemplate;
import WebApp.Util.ExamCommitteeMapper;
import java.util.List;
import WebApp.Util.PasswordGenerator;

/**
 *
 * @author shamim
 */
public class ExamCommitteeDAOImp implements ExamCommitteeDAO
{   
    @Override
    public void saveExamCommittee(ExamCommittee examCommittee,User chairman,User firstMember, User secondMember) 
    {
        String committeeSQL="insert into ExamCommittee (chairmanEmail,firstMemberEmail,secondMemberEmail,year,session) values ('"+examCommittee.getChairmanEmail()+"','"+examCommittee.getFirstMemberEmail()+"','"+examCommittee.getSecondMemberEmail()+"', '"+examCommittee.getYear()+"', '"+examCommittee.getSession()+"')";
       
        UserDAO userDAO= new UserDAOImp();
        User user=userDAO.findUserByEmail(examCommittee.getChairmanEmail());
        String chairmanSQL =setUserSQL(user, chairman);
        
        user = userDAO.findUserByEmail(examCommittee.getFirstMemberEmail());
        String firstMemberSQL =setUserSQL(user,firstMember);
        
        user = userDAO.findUserByEmail(examCommittee.getSecondMemberEmail());
        String secondMemberSQL =setUserSQL(user, secondMember);
        DatabaseTemplate.executeTransaction(committeeSQL,chairmanSQL,firstMemberSQL,secondMemberSQL);
    }
    private String setUserSQL(User userFromDB,User userToInsert)
    {
        String SQL=null;
        
        if(userFromDB==null)
        {
           userToInsert.setPassWord(PasswordGenerator.getPassword());
           SQL="insert into User ( Email,PassWord,Type) values ('"+userToInsert.getEmail()+"', '"+userToInsert.getPassWord()+"', "+"'committee')"; 
           userToInsert.setType("committee");
        }
        else
        {
           SQL="update User set Type='committee' where Email='"+userToInsert.getEmail()+"'";
           userToInsert.setType("committee");
        }
        return SQL;
    }

    @Override
    public ExamCommittee getExamCommitteeTeacher(String year, String session)
    {
        String SQL = "SELECT * FROM ExamCommittee WHERE year=? AND session=?";
        List<ExamCommittee> examCommittees = DatabaseTemplate.executeQuery(SQL,new Object[]{year,session}, new ExamCommitteeMapper());
        
        if(examCommittees!=null && !examCommittees.isEmpty())
            return examCommittees.get(0);
        return null;
    }

    @Override
    public List<ExamCommittee> getExamCommitteeTeacher(String email)
    {
        String SQL = "SELECT * FROM ExamCommittee WHERE (chairmanEmail=? OR firstMemberEmail=? OR secondMemberEmail=?) AND session=(SELECT DISTINCT(current_session) FROM batchsemester)";
        List<ExamCommittee> examCommittees = DatabaseTemplate.executeQuery(SQL,new Object[]{email,email,email}, new ExamCommitteeMapper());
        
        if(examCommittees!=null && !examCommittees.isEmpty())
            return examCommittees;
        return null;
    }

    @Override
    public void upadteCommittee(String newEmail, String email) 
    {
        String SQL = "UPDATE ExamCommittee SET chairmanEmail=? WHERE chairmanEmail=?;";
        DatabaseTemplate.executeInsertQuery(SQL, newEmail,email);
        
        SQL = "UPDATE ExamCommittee SET firstMemberEmail=? WHERE firstMemberEmail=?;";
        DatabaseTemplate.executeInsertQuery(SQL, newEmail,email);
        
        SQL = "UPDATE ExamCommittee SET secondMemberEmail=? WHERE secondMemberEmail=?;";
        DatabaseTemplate.executeInsertQuery(SQL, newEmail,email);
    }

    @Override
    public void updateChairman(String email, String year, String session)
    {
        String SQL = "UPDATE ExamCommittee SET chairmanEmail=? WHERE year=? AND session=?;";
        DatabaseTemplate.executeInsertQuery(SQL,email,year,session);
    }

    @Override
    public void updateFirst(String email, String year, String session) 
    {
        String SQL = "UPDATE ExamCommittee SET firstMemberEmail=? WHERE year=? AND session=?;";
        DatabaseTemplate.executeInsertQuery(SQL,email,year,session);
    }

    @Override
    public void updateSecond(String email, String year, String session) 
    {
        String SQL = "UPDATE ExamCommittee SET secondMemberEmail=? WHERE year=? AND session=?;";
        DatabaseTemplate.executeInsertQuery(SQL,email,year,session);
    }

    
    
}
