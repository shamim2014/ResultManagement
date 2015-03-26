/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.TheorySubject;

/**
 *
 * @author shamim
 */
public interface TheorySubjectDAO 
{
    public void save(TheorySubject theorySubject);
    public void saveFirstInstructor(TheorySubject theorySubject);
}
