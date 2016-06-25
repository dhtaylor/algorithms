/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylor.dandy.cs2420.Assignment05;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author dandy.taylor
 */
public class CharacterComparator implements Comparator<Character>
{

    @Override
    public int compare(Character o1, Character o2)
    {
        Character value1 = o1;
        Character value2 = o2;
        
        if (Objects.equals(value1, value2))
            return 0;
        
        else
            return value1 - value2;
        
    }
    
    
}