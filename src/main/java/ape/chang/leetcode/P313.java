package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class P313 {
	
	@Parameter(0)
	public int[] primes;
	@Parameter(1)
	public int n;
	@Parameter(2)
	public int expected;
	
	@Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][] {
			{new int[] {2, 7, 13, 19}, 1, 1},
			{new int[] {2, 7, 13, 19}, 12, 32},
			{new int[] {7,13,17,19,23,29,31,41,47,53}, 55, 0}
		});
	}
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.nthSuperUglyNumber(n, primes), equalTo(expected));
	}
	
	class Solution {
	    public int nthSuperUglyNumber(int n, int[] primes) {
	    	if (n == 1) {
	    		return 1;
	    	}
	    	
	    	int m = primes.length;
	    	IntQueue[] queues = new IntQueue[m];
	    	for (int i = 0; i < m; ++i) {
	    		queues[i] = new IntQueue();
	    		queues[i].offer(primes[i]);
	    	}
	    	
	    	int k = 0;
	    	while (--n > 0) {
	    		int min = Integer.MAX_VALUE, idx = 0;
	    		for (int i = 0; i < m; ++i) {
	    			if (min > queues[i].peek()) {
	    				min = queues[i].peek();
	    				idx = i;
	    			}
	    		}
	    		queues[idx].poll();
	    		for (int i = idx; i < m; ++i) {
	    			queues[i].offer(min * primes[i]);
	    		}
	    		k = min;
	    	}
	        return k;
	    }
	    
	    class IntQueue {
	    	
	    	RuntimeException ex = new EmptyCollectionException();
	    	
	    	int[] queue;
	    	int head, tail, size;
	    	
	    	public IntQueue() {
	    		queue = new int[16];
	    		head = 0;
	    		tail = -1;
	    		size = 0;
			}
	    	
	    	int peek() {
	    		if (size == 0) {
	    			throw ex;
	    		}
	    		
	    		return queue[head];
	    	}
	    	
	    	int poll() {
	    		if (--size < 0) {
	    			throw ex;
	    		}
	    		int e = queue[head];
	    		if (++head == queue.length) {
	    			head = 0;
	    		}
	    		return e;
	    	}
	    	
	    	void offer(int e) {
	    		if (++size == queue.length) {
	    			int[] newQueue = new int[size << 1];
	    			if (head < tail) {
	    				System.arraycopy(queue, head, newQueue, 0, queue.length - 1);
	    			} else {
	    				System.arraycopy(queue, head, newQueue, 0, queue.length - head);
	    				System.arraycopy(queue, 0, newQueue, queue.length - head, tail);
	    			}
	    			head = 0;
	    			tail = queue.length - 1;
	    			queue = newQueue;
	    		}
	    		if (++tail == queue.length) {
	    			tail = 0;
	    		}
	    		queue[tail] = e;
	    	}
	    	
	    }
	    
	    @SuppressWarnings("serial")
		class EmptyCollectionException extends RuntimeException {}
	}

}
