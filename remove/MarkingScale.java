/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;


public class MarkingScale implements Serializable
{
    private String courseCode;
    private String session;
    private String incourse;
    private Hashtable<String,Double> marks;
    
    public MarkingScale()
    {
        
    }
    
   
}
