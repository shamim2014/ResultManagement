/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.TheorySubject;
import WebApp.Util.DatabaseTemplate;

/**
 *
 * @author shamim
 */
public class TheorySubjectDAOImp implements TheorySubjectDAO
{

    @Override
    public void save(TheorySubject theorySubject) 
    {
        String SQL = "insert into TheorySubject(firstExaminerEmail,secondExaminerEmail,course_code,session) values(?,?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,theorySubject.getFirstExaminerEmail(),theorySubject.getSecondExaminerEmail(),theorySubject.getCourseCode(),theorySubject.getSession());
    }

    @Override
    public void saveFirstInstructor(TheorySubject theorySubject)
    {
        String SQL = "insert into TheorySubject(firstExaminerEmail,course_code,session) values(?,?,?)";
        DatabaseTemplate.executeInsertQuery(SQL,theorySubject.getFirstExaminerEmail(),theorySubject.getCourseCode(),theorySubject.getSession());
    }
    
}
