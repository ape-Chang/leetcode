package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P300 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}), equalTo(4));
		assertThat(solution.lengthOfLIS(new int[] {}), equalTo(0));
	}
	
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	    	int n = nums.length;
	    	if (n == 0) {
	    		return 0;
	    	}
	    	
	    	int[] dp = new int[n];
	    	for (int i = 0; i < n; ++i) {
	    		dp[i] = 1;
	    	}
	    	int max = 1;
	    	for (int i = 1; i < n; ++i) {
	    		for (int j = 0; j < i; ++j) {
	    			if (nums[i] > nums[j]) {
	    				dp[i] = Math.max(dp[i], dp[j] + 1);
	    			}
	    		}
	    		max = Math.max(max, dp[i]);
	    	}
	        return max;
	    }
	}

}
