package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P698 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4), equalTo(true));
		assertThat(solution.canPartitionKSubsets(new int[] {2,2,2,2,3,4,5}, 4), equalTo(false));
	}
	
	class Solution {
	    public boolean canPartitionKSubsets(int[] a, int k) {
	    	int s = 0, m = 0;
	    	for (int i : a) {
	    		s += i;
	    		m = Math.max(m, i);
	    	}
	    	if (s % k != 0) {
	    		return false;
	    	}
	    	if (m > s/k) {
	    		return false;
	    	}
	        return true;
	    }
	}
}
