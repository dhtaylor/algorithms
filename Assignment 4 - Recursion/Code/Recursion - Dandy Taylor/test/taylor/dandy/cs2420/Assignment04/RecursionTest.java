package taylor.dandy.cs2420.Assignment04;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

import static taylor.dandy.cs2420.Assignment04.Recursion.fib1;
import static taylor.dandy.cs2420.Assignment04.Recursion.fib2;
import static taylor.dandy.cs2420.Assignment04.Recursion.palindrome1;
import static taylor.dandy.cs2420.Assignment04.Recursion.palindrome2;

/**
 *
 * @author dandy.taylor
 */
public class RecursionTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    public RecursionTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void fib1_NegativeThrowsIllegalArgumentException()
    {
        int myInt = -10;
        
        exception.expect(IllegalArgumentException.class);
        long myLong = fib1(myInt);
    }

    @Test
    public void fib1_SequenceIsAccurate()
    {
        int myInt = 10;
        long fibNumber = fib1(myInt);
        long fibNumberMinus1 = fib1(myInt - 1);
        long fibNumberMinus2 = fib1(myInt - 2);
        
        assertEquals(fibNumber, fibNumberMinus1 + fibNumberMinus2);
        assertEquals(fibNumber, 34);
        
    }
    
    @Test
    public void fib1_ZeroThrowsIllegalArgumentException()
    {
        int myInt = 0;
        
        exception.expect(IllegalArgumentException.class);
        long myLong = fib1(myInt);
    }

    @Test
    public void fib2_NegativeThrowsIllegalArgumentException()
    {
        int myInt = -10;

        exception.expect(IllegalArgumentException.class);
        long myLong = fib2(myInt);
    }

    @Test
    public void fib2_SequenceIsAccurate()
    {
        int myInt = 10;
        long fibNumber = fib2(myInt);
        long fibNumberMinus1 = fib2(myInt - 1);
        long fibNumberMinus2 = fib2(myInt - 2);
        
        assertEquals(fibNumber, fibNumberMinus1 + fibNumberMinus2);
        assertEquals(fibNumber, 34);
        
    }

    @Test
    public void fib2_ZeroThrowsIllegalArgumentException()
    {
        int myInt = 0;

        exception.expect(IllegalArgumentException.class);
        long myLong = fib2(myInt);
    }

    @Test
    public void palindrome1_IgnorePunctuation()
    {
        assertTrue(palindrome1("Rise to vote, sir"));
    }
    
    @Test
    public void palindrome1_IsFalse()
    {
        assertFalse(palindrome1("motorcycle"));
        
    }
    
    @Test
    public void palindrome1_IsTrue()
    {
        assertTrue(palindrome1("racecar"));
        
    }
    
    @Test
    public void palindrome1_SingleLetterPalindrome()
    {
        assertTrue(palindrome1("a"));
    }
    
    @Test
    public void palindrome1_ThrowsExceptionWithEmptyString()
    {
        exception.expect(IllegalArgumentException.class);
        palindrome1("");
    }
    
    @Test
    public void palindrome1_ThrowsExceptionWithPunctuationString()
    {
        exception.expect(IllegalArgumentException.class);
        palindrome1("!'%");
    }

    @Test
    public void palindrome2_IgnorePunctuation()
    {
        assertTrue(palindrome2("Rise to vote, sir"));
    }
    
    @Test
    public void palindrome2_IsFalse()
    {
        assertFalse(palindrome2("motorcycle"));
        
    }

    @Test
    public void palindrome2_IsTrue()
    {
        assertTrue(palindrome2("racecar"));
        
    }
    
    @Test
    public void palindrome2_SingleLetterPalindrome()
    {
        assertTrue(palindrome2("a"));
    }
    
    @Test
    public void palindrome2_ThrowsExceptionWithEmptyString()
    {
        exception.expect(IllegalArgumentException.class);
        palindrome2("");
    }
    
    @Test
    public void palindrome2_ThrowsExceptionWithPunctuationString()
    {
        exception.expect(IllegalArgumentException.class);
        palindrome2("!'%");
    }

}
