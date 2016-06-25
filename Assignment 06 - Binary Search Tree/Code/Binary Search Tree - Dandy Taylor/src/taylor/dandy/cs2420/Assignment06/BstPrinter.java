
package taylor.dandy.cs2420.Assignment06;

import bst.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author dandy.taylor
 */
public class BstPrinter
{

    public static void main(String[] args)
    {
        BST<String, Integer> searchTree = new BST<>();


        Scanner input = new Scanner(System.in);
        
        System.out.print("Please Enter a Word: ");
        String word = input.next();
        
        String[] letters = word.split("");

        for (int i = 0; i < letters.length; i++)
        {
            searchTree.put(letters[i], i);
        }
        
        printBST(searchTree);
        
    }
    
    private static void printBST(BST<String, Integer> tree)
    {
        System.out.println("PreOder Traversal:: " + tree.preOrder());
        System.out.println("InOrder Traversal:: " + tree.inOrder());
        System.out.println("PostOrder Traversal:: " + tree.postOrder());
        System.out.println("LevelOrder Traversal:: " + tree.levelOrder());
        
    }

}
