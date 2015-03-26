/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.ExamCommittee;
import WebApp.Model.User;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface ExamCommitteeDAO 
{
    public void saveExamCommittee(ExamCommittee examCommittee,User chairman,User firstMember, User secondMember);
    public ExamCommittee getExamCommitteeTeacher(String year,String session);
    public List<ExamCommittee> getExamCommitteeTeacher(String email);
    public void upadteCommittee(String newEmail,String email);
    public void updateChairman(String email, String year,String session);
    public void updateFirst(String email, String year,String session);
    public void updateSecond(String email, String year,String session);
    
}
