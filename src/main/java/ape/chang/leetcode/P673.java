package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P673 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findNumberOfLIS(new int[] {1,3,5,4,7}), equalTo(2));
		assertThat(solution.findNumberOfLIS(new int[] {2,2,2,2,2}), equalTo(5));
		assertThat(solution.findNumberOfLIS(new int[] {}), equalTo(0));
		assertThat(solution.findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}), equalTo(3));
		assertThat(solution.findNumberOfLIS(new int[] {3, 1, 2}), equalTo(1));
		assertThat(solution.findNumberOfLIS(new int[] {1, 3, 2}), equalTo(2));
	}
	
	class Solution {
	    public int findNumberOfLIS(int[] nums) {
	    	int n = nums.length;
	    	if (n == 0) {
	    		return 0;
	    	}
	    	
	    	Node[] dp = new Node[n];
	    	for (int i = 0; i < n; ++i) {
	    		dp[i] = new Node();
	    	}
	    	
	    	int max = 1, count = 1;
	    	for (int i = 1; i < n; ++i) {
	    		for (int j = 0; j < i; ++j) {
	    			if (nums[i] > nums[j]) {
	    				if (dp[j].length + 1 > dp[i].length) {
	    					dp[i].length = dp[j].length + 1;
	    					dp[i].pathes = dp[j].pathes;
	    				} else if (dp[j].length + 1 == dp[i].length) {
	    					dp[i].pathes += dp[j].pathes;
	    				}
	    			}
	    		}
	    		
	    		if (dp[i].length > max) {
	    			max = dp[i].length;
	    			count = dp[i].pathes;
	    		} else if (dp[i].length == max) {
	    			count += dp[i].pathes;
	    		}
	    	}
	    	
	    	return count;
	    }
	    
	    class Node {
	    	int length = 1;
	    	int pathes = 1;
	    }
	}

}
