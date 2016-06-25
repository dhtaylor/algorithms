/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bst.BST;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dandy.taylor
 */

public class BSTTest
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void preOrder_Correct()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        String word = "SEARCHEXAMPLE";
        String[] letters = word.split("");
        
        for (int i = 0; i < letters.length; i++)
        {
            searchTree.put(letters[i], i);
        }
        
        String correctOrder = "SEACRHMLPX";
        
        Iterable<String> keys = searchTree.preOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertEquals(newWord, correctOrder);
        
    }

    @Test
    public void preOrder_Empty()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        Iterable<String> keys = searchTree.preOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertTrue(newWord.isEmpty());
    }
    
    @Test
    public void inOrder_Correct()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        String word = "SEARCHEXAMPLE";
        String[] letters = word.split("");
        
        for (int i = 0; i < letters.length; i++)
        {
            searchTree.put(letters[i], i);
        }
        
        String correctOrder = "ACEHLMPRSX";
        
        Iterable<String> keys = searchTree.inOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertEquals(newWord, correctOrder);
        
    }

    @Test
    public void inOrder_Empty()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        Iterable<String> keys = searchTree.inOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertTrue(newWord.isEmpty());
    }
    @Test

    public void postOrder_Correct()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        String word = "SEARCHEXAMPLE";
        String[] letters = word.split("");
        
        for (int i = 0; i < letters.length; i++)
        {
            searchTree.put(letters[i], i);
        }
        
        String correctOrder = "CALPMHREXS";
        
        Iterable<String> keys = searchTree.postOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertEquals(newWord, correctOrder);
        
    }

    @Test
    public void postOrder_Empty()
    {
        BST<String, Integer> searchTree = new BST<>();
        
        Iterable<String> keys = searchTree.postOrder();
        
        String newWord = "";
        
        for (String letter : keys)
        {
            newWord += letter;
        }
        
        assertTrue(newWord.isEmpty());
    }

}
