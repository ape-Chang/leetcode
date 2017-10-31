package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P674 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findLengthOfLCIS(new int[] {2, 2, 2, 2}), equalTo(1));
		assertThat(solution.findLengthOfLCIS(new int[] {1,3,5,4,7}), equalTo(3));
		assertThat(solution.findLengthOfLCIS(new int[] {1}), equalTo(1));
		assertThat(solution.findLengthOfLCIS(new int[] {}), equalTo(0));
	}
	
	class Solution {
	    public int findLengthOfLCIS(int[] a) {
	    	if (a.length == 0) {
	    		return 0;
	    	}
	    	
	        int max = 1;
	        for (int p = 0, q = p+1; q < a.length; p = q, q = p+1) {
	        	for (; q < a.length && a[q-1] < a[q]; ++q)
	        		;
	        	max = Math.max(max, q-p);
	        }
	        return max;
	    }
	}

}
