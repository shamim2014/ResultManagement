/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Service;

import WebApp.Model.ExamCommittee;
import WebApp.Model.Teacher;
import java.util.List;

/**
 *
 * @author shamim
 */
public interface ExamCommitteeService 
{
    public void saveExamCommittee(ExamCommittee examCommittee);
    public List<Teacher> getExamCommitteeTeacher(ExamCommittee examCommittee);
    public List<String> getExamCommitteeYear(String email);
    public void update(ExamCommittee examCommittee);
    public ExamCommittee getExamCommitteeYear(String year,String session);
    public ExamCommittee getExamCommittee(String year);
}
