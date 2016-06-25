package taylor.dandy.cs2420.Assignment3;

import java.util.Scanner;

public class LinkedListApp
{
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
	LinkedList<String> list = new LinkedList <>();
        String inValue = "";
        String key = "";
        String element;
        
	list.append("gobi");
	list.append("sahara");
	list.append("atacama");
	list.append("sonoma");
	list.append("kalahari");

        while (!inValue.equals("q"))
        {
            System.out.println("a .. Size");
            System.out.println("b .. Insert");
            System.out.println("c .. Remove");
            System.out.println("d .. Display All Items");
            System.out.println("e .. Clear");
            System.out.println("q .. Quit");
            System.out.print("Your Choice: ");

            inValue = input.next();

            try
            {
                switch (inValue)
                {
                    case "a":
                        System.out.println("Size: " + list.getSize());
                        System.out.println();
                        break;
                    case "b":
                        System.out.print("New Element: ");
                        element = input.next();
                        System.out.print("Key: ");
                        key = input.next();
                        list.insertAfter(key, element);
                        System.out.println(element + " has been inserted after " + key);
                        System.out.println();
                        break;
                    case "c":
                        System.out.print("New Element: ");
                        key = input.next();
                        list.remove(key);
                        System.out.println(key + " has been removed");
                        System.out.println();
                        break;
                    case "d":
                        System.out.println(list.toString());
                        System.out.println();
                        break;
                    case "e":
                        list.clear();
                        System.out.println("The list has been emptied.");
                        System.out.println();
                        break;
                    case "q":
                        System.out.println("Good bye");
                        break;
                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;
                }
                
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("The element " + key + " could not be found.");
                System.out.println();
            }

        }
            
    }

}
