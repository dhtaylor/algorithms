package taylor.dandy.cs2420.Assignment04;

/**
 * @author dandy.taylor
 */
public class RecursionTimer
{

    public static void main(String[] args)
    {
        long start = 0;
        long end = 0;

        System.out.println("Iteration, InputValue, ResultValue, ElapsedTime(ms)");
        
        for (int i = 1; i <= 50; i++)
        {
            start = System.currentTimeMillis();
            long result = Recursion.fib1(i);
            end = System.currentTimeMillis();

            System.out.println(i + ", " + (i) + ", " + result + ", " + (end - start));
            
        }
        
        start = 0;
        end = 0;
        
        for (int i = 1; i <= 50; i++)
        {
            start = System.currentTimeMillis();
            long result = Recursion.fib2(i);
            end = System.currentTimeMillis();

            System.out.println(i + ", " + (i) + ", " + result + ", " + (end - start));
            
        }

    }
    

}
