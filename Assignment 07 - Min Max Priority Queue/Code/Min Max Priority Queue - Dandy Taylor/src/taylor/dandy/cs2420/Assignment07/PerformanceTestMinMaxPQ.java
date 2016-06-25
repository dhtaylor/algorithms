
package taylor.dandy.cs2420.Assignment07;

/**
 * @author dandy.taylor
 */
public class PerformanceTestMinMaxPQ
{
        
    public static void main(String args[])
    {
        Integer[] numbers;

        // Get Array of 100 Random Numbers
        numbers = GetRandomNumbers();

        // Run Tests
        TestIsEmpty(numbers);
        TestAdd(numbers);
        TestMin(numbers);
        TestRemoveMin(numbers);
        TestMax(numbers);
        TestRemoveMax(numbers);
       
    }
    
    private static Integer[] GetRandomNumbers()
    {
        Integer[] temp = new Integer[100];
        
        for (int i = 0; i < 100; i++)
        {
            temp[i] = (int)(Math.random() * 100);
            
        }
        
        return temp;

    }

    private static void TestIsEmpty(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: IsEmpty Method");
        System.out.println("Iteration\tValue\tIsEmpty Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            queue.add(numbers[i]);
            
            long startTime = System.nanoTime();
            queue.isEmpty();
            long endTime = System.nanoTime();
            
            Print(i+1, numbers[i], startTime, endTime);
        }

        System.out.println();
        
    }

    private static void TestAdd(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: Add Method");
        System.out.println("Iteration\tValue\tAdd Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            long startTime = System.nanoTime();
            queue.add(numbers[i]);
            long endTime = System.nanoTime();
            
            Print(i+1, numbers[i], startTime, endTime);
        }

        System.out.println();
        
    }
    
    private static void TestMin(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: Min Method");
        System.out.println("Iteration\tValue\tMin Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            
            queue.add(numbers[i]);

            Integer tempNumber;
            
            long startTime = System.nanoTime();
            queue.min();
            long endTime = System.nanoTime();
            
            Print(i+1, (int) queue.min(), startTime, endTime);
        }

        System.out.println();
        
    }

    private static void TestRemoveMin(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: RemoveMin Method");
        System.out.println("Iteration\tValue\tRemoveMin Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            queue.add(numbers[i]);

        }

        for (int j = 0; j < numbers.length; j++)
        {
            
            long startTime = System.nanoTime();
            int tempNumber = (int) queue.removeMin();
            long endTime = System.nanoTime();
            
            Print(j+1, tempNumber, startTime, endTime);
    
        }
        
        System.out.println();
        
    }

    private static void TestMax(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: Max Method");
        System.out.println("Iteration\tValue\tMax Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            
            queue.add(numbers[i]);

            Integer tempNumber;
            
            long startTime = System.nanoTime();
            queue.max();
            long endTime = System.nanoTime();
            
            Print(i+1, (int) queue.max(), startTime, endTime);
        }

        System.out.println();
        
    }

    private static void TestRemoveMax(Integer[] numbers)
    {
        MinMaxPQ queue = new MinMaxPQ(numbers.length);
        
        System.out.println("Performance Test: RemoveMax Method");
        System.out.println("Iteration\tValue\tRemoveMax Test Time(ns)");
        
        for (int i = 0; i < numbers.length; i++)
        {
            queue.add(numbers[i]);

        }

        for (int j = 0; j < numbers.length; j++)
        {
            
            long startTime = System.nanoTime();
            int tempNumber = (int) queue.removeMax();
            long endTime = System.nanoTime();
            
            Print(j+1, tempNumber, startTime, endTime);
    
        }
        
        System.out.println();
        
    }

    private static void Print(int iteration, Integer number, long start, long end)
    {
        System.out.println(iteration + "\t" + number + "\t" + (end - start));
        
    }
}
