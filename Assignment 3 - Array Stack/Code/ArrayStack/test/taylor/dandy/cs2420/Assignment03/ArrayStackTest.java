package taylor.dandy.cs2420.Assignment03;


import java.util.EmptyStackException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {
	private ArrayStack<Integer> stack;
	private ArrayStack<Integer> emptyStack;

	@Before
	public void setUp() throws Exception {
		stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
                
		emptyStack = new ArrayStack<>();
	}

	@Test
	public void testArrayStack() {
		ArrayStack<Integer> newStack = new ArrayStack<>();
		assertTrue(newStack.isEmpty());
	}

	@Test
	public void testArrayStack_four() {
                ArrayStack<Integer> newStack = new ArrayStack<>(4);
		assertEquals(4, newStack.capacity());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testIsEmpty_empty() {
		assertTrue(emptyStack.isEmpty());
	}

        @Test
        public void testSize()
        {
            assertEquals(2,stack.size());
        }

        @Test
        public void testCapacity()
        {
            assertEquals(8, stack.capacity());
        }
        
        @Test
        public void testCapacity_extend()
        {
            ArrayStack<Integer> newStack = new ArrayStack<>();
            for (int i = 0; i < 10; i++)
            {
                newStack.push(i);
            }
            
            assertEquals(16, newStack.capacity());
            
        }
        
        @Test
        public void testCapacity_shrink()
        {
            ArrayStack<Integer> newStack = new ArrayStack<>();
            int iterations = 10;
            
            for (int i = 0; i < iterations; i++)
            {
                newStack.push(i + 1);
            }
            
            for (int j = 0; j < iterations - 1; j++)
            {
                newStack.pop();
            }
            
            assertEquals(8, newStack.capacity());
            
        }
        
        @Test
	public void testPush() {
		stack.push(3);
		assertEquals(new Integer(3), stack.pop());
	}	

	@Test
	public void testPush_empty() {
		emptyStack.push(1);
		assertEquals(new Integer(1), emptyStack.pop());
	}

	@Test
	public void testPop() {
		assertEquals(new Integer(2), stack.pop());
		assertFalse(stack.isEmpty());
	}	

	@Test
	public void testPop_one() {
		emptyStack.push(1);
		assertEquals(new Integer(1), emptyStack.pop());
		assertTrue(emptyStack.isEmpty());
	}	

	@Test(expected = EmptyStackException.class)
	public void testPop_empty() {
		emptyStack.pop();
	}

        @Test
        public void testClear()
        {
            stack.clear();
            assertEquals(0, stack.size());
            assertEquals(8, stack.capacity());
            assertTrue(stack.isEmpty());
            
        }
        
}
