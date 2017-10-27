package ape.chang.primitives;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IntStack {
	
	/*
	 * for simplicity, no shrink happens.
	 * 
	 */
	
	// The API
	
	public void push(int x) {
		int k = size++;
		if (size == stack.length) {
			expand();
		}
		stack[k] = x;
	}
	
	public int pop() {
		if (size == 0) {
			throw new EmptyCollectionException();
		}
		return stack[--size];
	}
	
	public int top() {
		return stack[size-1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	// The implementation
	
	int[] stack = new int[16];
	
	int size;
	
	void expand() {
		int[] newStack = new int[(size << 1)];
		System.arraycopy(stack, 0, newStack, 0, size);
		stack = newStack;
	}
	
	//
	
	@Test
	public void test() {
		IntStack stack = new IntStack();
		assertThat(stack.isEmpty(), equalTo(true));
		assertThat(stack.size(), equalTo(0));
		stack.push(1);
		assertThat(stack.isEmpty(), equalTo(false));
		assertThat(stack.top(), equalTo(1));
		for (int i = 0; i < 16; ++i) {
			stack.push(i);
		}
		assertThat(stack.top(), equalTo(15));
		for (int i = 0; i < 16; ++i) {			
			assertThat(stack.pop(), equalTo(15-i));
		}
		assertThat(stack.size(), equalTo(1));
	}
}
