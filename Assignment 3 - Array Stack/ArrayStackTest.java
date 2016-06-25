package arrayStack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

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
	public void testIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testIsEmpty_empty() {
		assertTrue(emptyStack.isEmpty());
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

}
