package ape.chang.primitives;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntQueueTest {
	
	@Test
	public void test() {
		IntQueue queue = new IntQueue();
		assertTrue(queue.isEmpty());
		for (int i = 0; i < 256; ++i) {
			queue.enqueue(i);
			assertTrue(queue.size() == i+1);
		}
		for (int i = 0; i < 256; ++i) {
			assertTrue(queue.dequeue() == i);
			assertTrue(queue.size() == 255-i);
		}
		for (int i = 0; i < 256; ++i) {
			queue.enqueue(i);
			assertTrue(queue.size() == i+1);
		}
		for (int i = 0; i < 256; ++i) {
			assertTrue(queue.dequeue() == i);
			assertTrue(queue.size() == 255-i);
		}
	}

}
