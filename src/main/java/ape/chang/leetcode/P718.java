package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P718 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}), equalTo(3));
		assertThat(solution.findLength(new int[] {0,0,0,0,1}, new int[] {1,0,0,0,0}), equalTo(4));
	}
	
	class Solution {
	    public int findLength(int[] A, int[] B) {
	    	int n = A.length, m = B.length;
	        int[][] dp = new int[n][m];
	        for (int i = 0; i < n; ++i) {
	        	dp[i][0] = A[i] == B[0] ? 1 : 0;
	        }
	        for (int i = 0; i < m; ++i) {
	        	dp[0][i] = A[0] == B[i] ? 1 : 0;
	        }
	        for (int i = 1; i < n; ++i) {
	        	for (int j = 1; j < m; ++j) {
	        		dp[i][j] = (A[i] == B[j]) ? dp[i-1][j-1] + 1 : 0;
	        	}
	        }
	        int max = 0;
	        for (int i = 0; i < n; ++i) {
	        	for (int j = 0; j < m; ++j) {
	        		max = Math.max(max, dp[i][j]);
	        	}
	        }
	        return max;
	    }
	}

}
