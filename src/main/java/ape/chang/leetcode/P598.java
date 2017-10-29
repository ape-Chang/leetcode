package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P598 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.maxCount(3, 3, new int[][] {
			{2, 2},
			{3, 3}
		}), equalTo(4));
	}
	
	class Solution {
	    public int maxCount(int m, int n, int[][] ops) {
	    	for (int[] op : ops) {
	    		if (op[0] != 0 || op[1] != 0) {
	    			m = Math.min(m, op[0]);
	    			n = Math.min(n, op[1]);
	    		}
	    	}
	    	return m * n;
	    }
	}

}
