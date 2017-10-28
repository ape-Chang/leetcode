package ape.chang.primitives;

public class IntQueue {
	
	// FIFO The API
	
	public IntQueue() {
		queue = new int[16];
	}
	
	public void enqueue(int x) {
		queue[tail] = x;
		if (head == -1) {
			head = 0;
		}
		if (++tail == queue.length) {
			tail = 0;
		}
		if (++size == queue.length) {
			expand();
		}
	}
	
	public int dequeue() {
		if (size <= 0) {
			throw new IllegalStateException();
		}
		
		--size;
		int x = queue[head];
		if (++head == queue.length) {
			head = 0;
		}
		return x;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	// The implementation
	
	int[] queue;
	int size;
	int head = -1; // first slot containing element, included
	int tail =  0; // next available slot, excluded
	
	void expand() {
		int[] newQueue = new int[(queue.length << 1)];
		if (head == 0) {
			System.arraycopy(queue, 0, newQueue, 0, queue.length);
		} else {
			System.arraycopy(queue, head, newQueue, 0, queue.length - head);
			System.arraycopy(queue, 0, newQueue, queue.length - head, tail);
		}
		// 
		queue = newQueue;
		head = 0; 
		tail = size;
	}

}
