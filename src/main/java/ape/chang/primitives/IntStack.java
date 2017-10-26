package ape.chang.primitives;

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
	
	// The implementation
	
	int[] stack = new int[16];
	
	int size;
	
	void expand() {
		int[] newStack = new int[(size << 1)];
		System.arraycopy(stack, 0, newStack, 0, size);
		stack = newStack;
	}
	
}
