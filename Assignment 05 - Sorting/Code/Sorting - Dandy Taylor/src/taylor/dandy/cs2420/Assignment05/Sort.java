package taylor.dandy.cs2420.Assignment05;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dandy.taylor
 */
public class Sort
{
    public static <T> void insertionSort(T[] array, Comparator<T> comp)
    {
        int iterations = array.length;
        
        for (int i = 0; i < iterations; i++)
        {
            for (int j = i; j > 0 && comp.compare(array[j], array[j - 1]) < 0; j--)
            {
                T swap = array[j];
                array[j] = array[j - 1];
                array[j - 1] = swap;
            }
        }
        
    }
    
    public static <T> void mergeSort(T[] array, Comparator<T> comp)
    {
        sort(array, 0, array.length - 1, comp);
    }
    
    public static boolean isAnagram(String word1, String word2)
    {
        if (word1.length() != word2.length())
            return false;
        
        char[] word1Array = word1.toLowerCase().toCharArray();
        Character[] word1Characters = new Character[word1Array.length];
        for(int i = 0; i < word1Array.length; i++)
        {
            word1Characters[i] = word1Array[i];
        }
        
        
        char[] word2Array = word2.toLowerCase().toCharArray();
        Character[] word2Characters = new Character[word2Array.length];
        for(int i = 0; i < word2Array.length; i++)
        {
            word2Characters[i] = word2Array[i];
        }
        
        insertionSort(word1Characters, new CharacterComparator());
        insertionSort(word2Characters, new CharacterComparator());
        
        return Arrays.equals(word1Characters, word2Characters);

    }

    private static <T> void sort(T[] array, int lowIndex, int highIndex, Comparator<T> comp)
    {
        if(highIndex <= lowIndex)
            return;
        
        int leftLow = lowIndex;
        int leftHigh = lowIndex + (highIndex - lowIndex) / 2;
        int rightLow = leftHigh + 1;
        int rightHigh = highIndex;
        
        sort(array, leftLow, leftHigh, comp);
        sort(array, rightLow, rightHigh, comp);
        
        // Merge
        T[] tempArray = (T[]) new Object[array.length];
        
        for (int i = lowIndex; i <= highIndex; i++)
        {
            tempArray[i] = array[i];
        }
        
        for (int k = lowIndex; k <= highIndex; k++)
        {
            
            if (leftLow > leftHigh)
            {
                array[k] = tempArray[rightLow++];
            }
            else if (rightLow > rightHigh)
            {
                array[k] = tempArray[leftLow++];
            }
            else if (comp.compare(tempArray[leftLow], tempArray[rightLow]) > 0)
            {
                array[k] = tempArray[rightLow++];
            }
            else
            {
                array[k] = tempArray[leftLow++];
            }

        }

    }

}
