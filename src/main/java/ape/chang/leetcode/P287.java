package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P287 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findDuplicate(new int[] {1, 2, 3, 3}), equalTo(3));
		assertThat(solution.findDuplicate(new int[] {1, 2, 2, 2}), equalTo(2));
		assertThat(solution.findDuplicate(new int[] {2, 2, 2, 2}), equalTo(2));
		assertThat(solution.findDuplicate(new int[] {1, 3, 4, 2, 1}), equalTo(1));
		assertThat(solution.findDuplicate(new int[] {1, 4, 4, 2, 4}), equalTo(4));
	}
	
	class Solution {
		/*
		 * My solution, O(nlgn)
		 */
	    public int findDuplicate(int[] nums) {
	    	int n = nums.length, l = 1, h = n-1, m = (l + h) / 2;
	    	while (true) {
	    		int cl = 0, ch = 0, cm = 0;
	    		for (int k : nums) {
	    			if (k < m && k >= l) {
	    				++cl;
	    			}
	    			if (k > m && k <= h) {
	    				++ch;
	    			} 
	    			if (k == m) {
	    				++cm;
	    			}
	    		}
	    		
	    		int dl = m - l, dh = h -m;
	    		if (cm > 1) {
	    			return m;
	    		} 
	    		if (cl > dl) {
	    			h = m-1;
	    		} 
	    		if (ch > dh) {
	    			l = m+1;
	    		}
	    		m = (l + h) / 2;
	    	}
	    }
	}

}
