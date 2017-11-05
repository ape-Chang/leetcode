package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P560 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.subarraySum(new int[] {1,1,1}, 2), equalTo(2));
	}
	
	class Solution {
	    public int subarraySum(int[] a, int k) {
	        int n = a.length, count = 0;
	        int[] dp = new int[n];
	        for (int i = 0; i < n; ++i) {
	        	for (int j = 0; j <= i; ++j) {
	        		if (k == (dp[j] = dp[j] + a[i])) {
	        			++count;
	        		}
	        	}
	        }
	        return count;
	    }
	}

}
