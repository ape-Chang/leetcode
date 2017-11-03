package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class P713 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100), equalTo(8));
		assertThat(solution.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0), equalTo(0));
	}
	
	class Solution {
	    public int numSubarrayProductLessThanK(int[] A, int k) {
	    	Queue<Integer> queue = new LinkedList<Integer>();
	    	int count = 0;
	    	for (int i = 0; i < A.length; ++i) {
	    		if (A[i] >= k) {
	    			queue.clear();
	    		} else if (A[i] == 1) { // treat 1 specially
	    			queue.offer(1);
	    			count += queue.size();
	    		} else {	    			
	    			int n = queue.size();
	    			while (n-- > 0) {
	    				Integer t = queue.poll();
	    				if (t * A[i] < k) {
	    					queue.offer(t * A[i]);
	    				}
	    			}
	    			queue.offer(A[i]);
	    			count += queue.size();
	    		}
	    		
	    	}
	        return count;
	    }
	}

}
