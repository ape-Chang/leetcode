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
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (size > 0) {			
			for (int p = head, i = 0; i < size; ++i) {
				sb.append(queue[p++]).append(",");
				if (p == queue.length) {
					p = 0;
				}
			}
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof IntQueue)) {
			return false;
		}
		IntQueue q = (IntQueue) o;
		if (size != q.size) {
			return false;
		}
		for (int i = 0, j = head, k = q.head; i < size; ++i) {
			if (queue[j++] != q.queue[k++]) {
				return false;
			}
			if (j == queue.length) {
				j = 0;
			}
			if (k == q.queue.length) {
				k = 0;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int h = 0;
		for (int p = head, i = 0; i < size; ++i) {
			h += Integer.hashCode(queue[p++]);
			if (p == queue.length) {
				p = 0;
			}
		}
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
