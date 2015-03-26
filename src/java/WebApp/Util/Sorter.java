/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author shamim
 */
public class Sorter
{
    public static <T extends Comparable<? super T>> List<T> sort(T... data)
    {
        List<T> list = new ArrayList<T>();
        
        for(T datum:data)
        {
            list.add(datum);
        }
        Collections.sort(list);
        return list;
    }
}
