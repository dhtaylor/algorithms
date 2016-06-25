/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylor.dandy.cs2420.Assignment05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static taylor.dandy.cs2420.Assignment05.Sort.isAnagram;

/**
 *
 * @author dandy.taylor
 */
public class AnagramTest
{
    public static void main(String args[])
    {

        ArrayList<String> words1;
        ArrayList<String> words2;

        try
        {
            words1 = LoadWordList();
            words2 = new ArrayList<String>(words1);
            
            long startTime = System.currentTimeMillis();
            
            for(int i = 0; i < words1.size(); i++)
            {
                for(int j = 0; j < words2.size(); j++)
                {
                    if (words1.get(i).equals(words2.get(j)))
                        continue;
                    
                    if (isAnagram(words1.get(i), words2.get(j)))
                        System.out.println(words1.get(i) + ", " + words2.get(j));
                }
            }
            
            long endTime = System.currentTimeMillis();
            
            System.out.println("RunTime:: " + (endTime - startTime));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    private static ArrayList<String> LoadWordList()
    {
        ArrayList<String> words = new ArrayList();
        
        try
        {
            java.io.File file = new File("Words.txt");
            
            Scanner input = new Scanner(file);

            while(input.hasNext())
            {
                words.add(input.next().toUpperCase());
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Can't find word file. Check that file is in project root directory.");
            e.printStackTrace();
          
        }
        
        return words;

    }
}
