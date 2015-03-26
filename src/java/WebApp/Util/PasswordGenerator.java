/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import java.util.Random;

/**
 *
 * @author shamim
 */
public class PasswordGenerator 
{
    public static String getPassword()
    {
        Random random = new Random(100000);
        return String.valueOf(random.nextInt(Integer.MAX_VALUE));  
    }
}
