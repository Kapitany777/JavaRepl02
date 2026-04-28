package eu.braincluster.javarepl02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyStackTest {

	@Test
	void newStackShouldBeEmpty() {
		MyStack<String> stack = new MyStack<>();

		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void pushShouldAddElement() {
		MyStack<String> stack = new MyStack<>();

		stack.push("alma");

		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("alma", stack.peek());
	}

	@Test
	void popShouldReturnAndRemoveTopElement() {
		MyStack<String> stack = new MyStack<>();
		stack.push("alma");
		stack.push("körte");

		String value = stack.pop();

		assertEquals("körte", value);
		assertEquals(1, stack.size());
		assertEquals("alma", stack.peek());
	}

	@Test
	void popShouldThrowExceptionWhenStackIsEmpty() {
		MyStack<String> stack = new MyStack<>();

		assertThrows(IllegalStateException.class, () -> stack.pop());
	}

	@Test
	void peekShouldThrowExceptionWhenStackIsEmpty() {
		MyStack<String> stack = new MyStack<>();

		assertThrows(IllegalStateException.class, () -> stack.peek());
	}

	@Test
	void clearShouldRemoveAllElements() {
		MyStack<String> stack = new MyStack<>();
		stack.push("alma");
		stack.push("körte");

		stack.clear();

		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void pushShouldAllowNull() {
		MyStack<String> stack = new MyStack<>();

		stack.push(null);

		assertEquals(1, stack.size());
		assertNull(stack.peek());
	}

	@Test
	void stackShouldFollowLifoOrder() {
		MyStack<Integer> stack = new MyStack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
	}
}
