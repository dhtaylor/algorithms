package taylor.dandy.cs2420.Assignment04;

import java.util.ArrayList;

/**
 * @author dandy.taylor
 */
public class Recursion
{

    /**
     *
     * @param number
     * @return
     * @throws IllegalArgumentException
     */
    public static long fib1(int number) throws IllegalArgumentException
    {
        if(number <= 0)
            throw new IllegalArgumentException();
        
        if(number <= 2)
            return (long)number - 1;
        
        return fib1(number - 1) + fib1(number - 2);
        
    }
    
    /**
     *
     * @param number
     * @return
     */
    public static long fib2(int number)
    {
        if (number < 0)
            throw new IllegalArgumentException();
        
        long[] myArray = new long[number];
        
        return GetFibonacciSequence(number, myArray);
        
    }
    
    /**
     *
     * @param word
     * @return
     */
    public static boolean palindrome1(String word)
    {
        ArrayList<Character> testArray;
        testArray = GetPalindromeArrayListFromCharArray(word.toCharArray());
        
        // Get midpoint of array as only need to test first half of the array
        int midpoint = testArray.size() / 2;
        
        return CheckPalindrome(midpoint, testArray);
        
    }
    
    /**
     *
     * @param word
     * @return
     */
    public static boolean palindrome2(String word)
    {
        ArrayList<Character> testArray = new ArrayList<>();
        testArray = GetPalindromeArrayListFromCharArray(word.toCharArray());
        
        // Get midpoint of array as only need to test first half of the array
        int midpoint = testArray.size() / 2;
        
        for (int i = 0; i < midpoint; i++)
        {
            Character char1 = testArray.get(i);
            Character char2 = testArray.get(testArray.size() - i - 1);
            
            if (!char1.equals(char2))
                return false;
            
        }
        
        return true;

    }

    private static boolean CheckPalindrome(int index, ArrayList<Character> array)
    {
        if (array.size() == 1 || index == 0)
            return true;

        Character char1 = array.get(index - 1);
        Character char2 = array.get(array.size() - index);
        
        if (!char1.equals(char2))
            return false;
        
        return CheckPalindrome(index - 1, array);

    }
    
    private static long GetFibonacciSequence(int number, long[] array) throws IllegalArgumentException
    {
        if (number <= 0)
            throw new IllegalArgumentException();
        
        if(number <= 2)
            return number - 1;
        
        // Set memory location if not already set
        if (array[number - 1] == 0)
            array[number - 1] = GetFibonacciSequence(number - 1, array) + GetFibonacciSequence(number - 2, array);

        return array[number - 1];
        
    }
    
    // This method strips out punctuation and spaces from the string as they are typically ignored for palindromes
    private static ArrayList<Character> GetPalindromeArrayListFromCharArray(char[] array) throws IllegalArgumentException
    {
        if (array.length == 0)
            throw new IllegalArgumentException();
        
        ArrayList<Character> workspace = new ArrayList<>();
        
        // Remove punctuation as it is ignored in palindromes
        for (int i = 0; i < array.length; i++)
        {
            if (Character.isAlphabetic(array[i]))
                workspace.add(Character.toLowerCase(array[i]));
        }
        
        if (workspace.isEmpty())
            throw new IllegalArgumentException();
        
        return workspace;
        
    }
    
}
