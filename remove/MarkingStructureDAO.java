/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.repository;

import WebApp.Model.MarkingStructure;

/**
 *
 * @author shamim
 */
public interface MarkingStructureDAO 
{
    public void save(MarkingStructure markingStructure);
    public MarkingStructure getMarkingStructure(String courseCode,String session);
}
