package linear.and.binary.search.dandy.taylor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dandy.taylor
 */

public class SearchApp
{
    public static void main(String args[])
    {
        ArrayList<String> words = new ArrayList();
        String[] randomWords = new String[15];
        Integer[] randomNumbers = new Integer[15];

        try
        {
            words = LoadWordList();
            randomWords = GetRandomWords(15, 42, words);
            randomNumbers = GetRandomNumbers(15, 100, 10, 42);
            
            TestLinearSearchWithIntegers(randomNumbers);
            TestLinearSearchWithStrings(randomWords);

            randomWords = GetRandomWords(15, 86, words);
            randomNumbers = GetRandomNumbers(15, 100, 10, 86);

            TestBinarySearchWithIntegers(randomNumbers);
            TestBinarySearchWithStrings(randomWords);
            
            PrintWordList(words);

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
            java.io.File file = new File("ThreeLetterWords.txt");
            
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

    private static Integer[] GetRandomNumbers(int size, int max, int min, int seed)
    {
        Integer[] numbers = new Integer[size];
        Random rand = new Random(seed);


        for(int i = 0; i < size; i++)
        {
            Integer matchIndex;
            Integer number;
            
            do
            {
                number = rand.nextInt(max - min) + min;
                matchIndex = Search.Linear(number, numbers);
            
            }
            while (matchIndex > -1);
            numbers[i] = number;

        }

        return numbers;
    }

    private static String[] GetRandomWords(int size, int seed, ArrayList words)
    {
        String[] randomWords = new String[size];
        Integer[] randomNumbers = GetRandomNumbers(size, words.size(), 0, seed);
        
        for (int i = 0; i < randomNumbers.length; i++)
        {
            randomWords[i] = (String)words.get(randomNumbers[i]);
        }
        
        return randomWords;
    }

    private static void TestLinearSearchWithIntegers(Integer[] numbers)
    {
        Integer[] fiveNumbers = new Integer[5];
        Integer[] tenNumbers = new Integer[10];
        Integer[] fifteenNumbers = new Integer[15];
        Integer[] randomNumbers = new Integer[15];
        Integer[] oneRandomNumber = new Integer[15];
        
        Integer searchKey = -1;
        Integer fiveNumbersResult = -1;
        Integer tenNumbersResult = -1;
        Integer fifteenNumbersResult = -1;
        
        // Try to randomize a bit further the numbers populating each array.
        int fiveNumbersIndex = 0;
        int tenNumbersIndex = 9;

        for (int i = 0; i < numbers.length; i++)
        {
            int modResult = i % 3;
            if (modResult == 0)
            {
                fiveNumbers[fiveNumbersIndex] = numbers[i]; // Multiples of 3 go into array of 5
                fiveNumbersIndex++;
            }
            else
            {
                tenNumbers[tenNumbersIndex] = numbers[i]; // All other numbers in reverse order populate array of 10.
                tenNumbersIndex--;
            }
        }
        
        // One more random pass on numbers going into final array.
        randomNumbers = GetRandomNumbers(15, 15, 0, -1);
        
        for (int j = 0; j < randomNumbers.length; j++)
        {
            fifteenNumbers[j] = numbers[randomNumbers[j]];
            
        }
        
        // Get one random number to select an element from array of 10 for searching
        oneRandomNumber = GetRandomNumbers(1, 10, 0, -1);
        
        searchKey = tenNumbers[oneRandomNumber[0]];
        
        // Perform Searches
        fiveNumbersResult = Search.Linear(searchKey, fiveNumbers);
        tenNumbersResult = Search.Linear(searchKey, tenNumbers);
        fifteenNumbersResult = Search.Linear(searchKey, fifteenNumbers);
        
        // Print Results
        System.out.println("Test linear search with integer arrays:");
        System.out.println(Arrays.toString(fiveNumbers) + " Key: " + searchKey + " Index: " + fiveNumbersResult);
        System.out.println(Arrays.toString(tenNumbers) + " Key: " + searchKey + " Index: " + tenNumbersResult);
        System.out.println(Arrays.toString(fifteenNumbers) + " Key: " + searchKey + " Index: " + fifteenNumbersResult);
        System.out.println();
    }
    
   private static void TestBinarySearchWithIntegers(Integer[] numbers)
    {
        Integer[] fiveNumbers = new Integer[5];
        Integer[] tenNumbers = new Integer[10];
        Integer[] fifteenNumbers = new Integer[15];
        Integer[] randomNumbers = new Integer[15];
        Integer[] oneRandomNumber = new Integer[15];
        
        Integer searchKey = -1;
        Integer fiveNumbersResult = -1;
        Integer tenNumbersResult = -1;
        Integer fifteenNumbersResult = -1;
        
        // Try to randomize a bit further the numbers populating each array.
        int fiveNumbersIndex = 0;
        int tenNumbersIndex = 9;

        for (int i = 0; i < numbers.length; i++)
        {
            int modResult = i % 3;
            if (modResult == 0)
            {
                fiveNumbers[fiveNumbersIndex] = numbers[i]; // Multiples of 3 go into array of 5
                fiveNumbersIndex++;
            }
            else
            {
                tenNumbers[tenNumbersIndex] = numbers[i]; // All other numbers in reverse order populate array of 10.
                tenNumbersIndex--;
            }
        }
        
        // One more random pass on numbers going into final array.
        randomNumbers = GetRandomNumbers(15, 15, 0, -1);
        
        for (int j = 0; j < randomNumbers.length; j++)
        {
            fifteenNumbers[j] = numbers[randomNumbers[j]];
            
        }
        
        // Get one random number to select an element from array of 10 for searching
        oneRandomNumber = GetRandomNumbers(1, 10, 0, -1);
        
        searchKey = tenNumbers[oneRandomNumber[0]];
        
        // Perform Searches
        fiveNumbersResult = Search.Binary(searchKey, fiveNumbers);
        tenNumbersResult = Search.Binary(searchKey, tenNumbers);
        fifteenNumbersResult = Search.Binary(searchKey, fifteenNumbers);
        
        // Print Results
        System.out.println("Test binary search with integer arrays:");
        System.out.println(Arrays.toString(fiveNumbers) + " Key: " + searchKey + " Index: " + fiveNumbersResult);
        System.out.println(Arrays.toString(tenNumbers) + " Key: " + searchKey + " Index: " + tenNumbersResult);
        System.out.println(Arrays.toString(fifteenNumbers) + " Key: " + searchKey + " Index: " + fifteenNumbersResult);
        System.out.println();
    }

   private static void TestLinearSearchWithStrings(String[] words)
    {
        String[] fiveWords = new String[5];
        String[] tenWords = new String[10];
        String[] fifteenWords = new String[15];
        Integer[] randomNumbers = new Integer[15];
        Integer[] oneRandomNumber = new Integer[15];
        
        String searchKey;
        Integer fiveWordsResult = -1;
        Integer tenWordsResult = -1;
        Integer fifteenWordsResult = -1;
        
        // Try to randomize a bit further the numbers populating each array.
        int fiveWordsIndex = 0;
        int tenWordsIndex = 9;

        for (int i = 0; i < words.length; i++)
        {
            int modResult = i % 3;
            if (modResult == 0)
            {
                fiveWords[fiveWordsIndex] = words[i]; // Multiples of 3 go into array of 5
                fiveWordsIndex++;
            }
            else
            {
                tenWords[tenWordsIndex] = words[i]; // All other numbers in reverse order populate array of 10.
                tenWordsIndex--;
            }
        }
        
        // One more random pass on numbers going into final array.
        randomNumbers = GetRandomNumbers(15, 15, 0, -1);
        
        for (int j = 0; j < randomNumbers.length; j++)
        {
            fifteenWords[j] = words[randomNumbers[j]];
            
        }
        
        // Get one random number to select an element from array of 10 for searching
        oneRandomNumber = GetRandomNumbers(1, 10, 0, -1);
        
        searchKey = tenWords[oneRandomNumber[0]];
        
        // Perform Searches
        fiveWordsResult = Search.Linear(searchKey, fiveWords);
        tenWordsResult = Search.Linear(searchKey, tenWords);
        fifteenWordsResult = Search.Linear(searchKey, fifteenWords);
        
        // Print Results
        System.out.println("Test linear search with word arrays:");
        System.out.println(Arrays.toString(fiveWords) + " Key: " + searchKey + " Index: " + fiveWordsResult);
        System.out.println(Arrays.toString(tenWords) + " Key: " + searchKey + " Index: " + tenWordsResult);
        System.out.println(Arrays.toString(fifteenWords) + " Key: " + searchKey + " Index: " + fifteenWordsResult);
        System.out.println();
    }

   private static void TestBinarySearchWithStrings(String[] words)
    {
        String[] fiveWords = new String[5];
        String[] tenWords = new String[10];
        String[] fifteenWords = new String[15];
        Integer[] randomNumbers = new Integer[15];
        Integer[] oneRandomNumber = new Integer[15];
        
        String searchKey;
        Integer fiveWordsResult = -1;
        Integer tenWordsResult = -1;
        Integer fifteenWordsResult = -1;
        
        // Try to randomize a bit further the numbers populating each array.
        int fiveWordsIndex = 0;
        int tenWordsIndex = 9;

        for (int i = 0; i < words.length; i++)
        {
            int modResult = i % 3;
            if (modResult == 0)
            {
                fiveWords[fiveWordsIndex] = words[i]; // Multiples of 3 go into array of 5
                fiveWordsIndex++;
            }
            else
            {
                tenWords[tenWordsIndex] = words[i]; // All other numbers in reverse order populate array of 10.
                tenWordsIndex--;
            }
        }
        
        // One more random pass on numbers going into final array.
        randomNumbers = GetRandomNumbers(15, 15, 0, -1);
        
        for (int j = 0; j < randomNumbers.length; j++)
        {
            fifteenWords[j] = words[randomNumbers[j]];
            
        }
        
        // Get one random number to select an element from array of 10 for searching
        oneRandomNumber = GetRandomNumbers(1, 10, 0, -1);
        
        searchKey = tenWords[oneRandomNumber[0]];

        // Perform Searches
        fiveWordsResult = Search.Binary(searchKey, fiveWords);
        tenWordsResult = Search.Binary(searchKey, tenWords);
        fifteenWordsResult = Search.Binary(searchKey, fifteenWords);
        
        // Print Results
        System.out.println("Test binary search with word arrays:");
        System.out.println(Arrays.toString(fiveWords) + " Key: " + searchKey + " Index: " + fiveWordsResult);
        System.out.println(Arrays.toString(tenWords) + " Key: " + searchKey + " Index: " + tenWordsResult);
        System.out.println(Arrays.toString(fifteenWords) + " Key: " + searchKey + " Index: " + fifteenWordsResult);
        System.out.println();
    }

   private static void PrintWordList(ArrayList words)
   {
       String outLine = new String();
       
       for (int i = 0; i < words.size(); i++)
       {
           if (outLine.equals(""))
           {
               outLine += words.get(i);
           }
           else
           {
               outLine = outLine + " " + words.get(i);
           }
           
           int modResult = ((i + 1) % 20);
           
           if (modResult == 0)
           {
               System.out.println(outLine);
               outLine = "";
           }
       }
       
       System.out.println(outLine);
       
   }
}
