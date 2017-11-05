package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P523 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6), equalTo(true));
		assertThat(solution.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 6), equalTo(true));
		assertThat(solution.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 0), equalTo(false));
	}
	
	class Solution {
	    public boolean checkSubarraySum(int[] a, int k) {
	    	int n = a.length;
	        int[] dp = new int[n];
	        for (int i = 0; i < n; ++i) {
	        	for (int j = 0; j <= i; ++j) {
	        		dp[j] = dp[j] + a[i];
	        		if ((k == 0 ? dp[j] == 0 : dp[j]%k == 0) && j < i) {
	        			return true;
	        		}
	        	}
	        }
	        return false;
	    }
	}

}
