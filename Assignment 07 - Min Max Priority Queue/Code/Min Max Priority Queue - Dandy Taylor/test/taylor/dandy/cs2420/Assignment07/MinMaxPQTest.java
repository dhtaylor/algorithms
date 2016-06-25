package taylor.dandy.cs2420.Assignment07;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author dandy.taylor
 */
public class MinMaxPQTest
{

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
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
    public void queueIsEmptyOnCreate()
    {
        MinMaxPQ queue = new MinMaxPQ(1);
        assertTrue(queue.isEmpty());
        
    }

    @Test
    public void addElement()
    {
        String testString = "S";
        
        MinMaxPQ queue = new MinMaxPQ(1);
        queue.add(testString);
        
        assertFalse(queue.isEmpty());
    }

    @Test
    public void addNullElement()
    {
        String testString = null;
        
        MinMaxPQ queue = new MinMaxPQ(1);
        
        exception.expect(NullPointerException.class);
        queue.add(testString);

    }

    @Test
    public void min()
    {
        String testStringA = "a";
        String testStringB = "b";
        String testStringC = "c";
        String testStringD = "A";
        
        MinMaxPQ queue = new MinMaxPQ(4);
        
        queue.add(testStringC);
        queue.add(testStringB);
        queue.add(testStringA);
        assertTrue(queue.min() == testStringA);

        queue.add(testStringD);
        assertTrue(queue.min() == testStringD);
    }
    
    @Test
    public void minThrowsException()
    {
        MinMaxPQ queue = new MinMaxPQ(1);

        exception.expect(NoSuchElementException.class);
        queue.min();
    }

    @Test
    public void removeMin()
    {
        String testStringA = "a";
        String testStringB = "b";
        String testStringC = "c";
        
        MinMaxPQ queue = new MinMaxPQ(3);
        
        queue.add(testStringC);
        queue.add(testStringB);
        queue.add(testStringA);
        assertTrue(queue.removeMin() == testStringA);
        assertFalse(queue.isEmpty());
        
        queue.removeMin();
        queue.removeMin();
        
        assertTrue(queue.isEmpty());
        
    }

    @Test
    public void removeMinThrowsException()
    {
        MinMaxPQ queue = new MinMaxPQ(1);

        exception.expect(NoSuchElementException.class);
        queue.removeMin();
    }

    @Test
    public void max()
    {
        String testStringA = "a";
        String testStringB = "b";
        String testStringC = "c";
        String testStringD = "A";
        
        MinMaxPQ queue = new MinMaxPQ(4);
        
        queue.add(testStringC);
        queue.add(testStringB);
        queue.add(testStringA);
        assertTrue(queue.max() == testStringC);

        queue.add(testStringD);
        assertTrue(queue.max() == testStringC);
    }
    
    @Test
    public void maxThrowsException()
    {
        MinMaxPQ queue = new MinMaxPQ(1);

        exception.expect(NoSuchElementException.class);
        queue.max();
    }

    @Test
    public void removeMax()
    {
        String testStringA = "a";
        String testStringB = "b";
        String testStringC = "c";
        
        MinMaxPQ queue = new MinMaxPQ(3);
        
        queue.add(testStringA);
        queue.add(testStringB);
        queue.add(testStringC);
        assertTrue(queue.removeMax() == testStringC);
        assertFalse(queue.isEmpty());
        
        queue.removeMax();
        queue.removeMax();
        assertTrue(queue.isEmpty());
        
    }

    @Test
    public void removeMaxThrowsException()
    {
        MinMaxPQ queue = new MinMaxPQ(1);

        exception.expect(NoSuchElementException.class);
        queue.removeMax();
    }
    
}
