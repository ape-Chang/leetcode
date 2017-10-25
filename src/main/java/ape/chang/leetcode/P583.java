package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P583 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.minDistance("sea", "eat"), equalTo(2));
	}
	
	// longest common sub-sequence problem
	class Solution {
	    public int minDistance(String w1, String w2) {
	    	if (w1.length() == 0) {
	    		return w2.length();
	    	}
	    	if (w2.length() == 0) {
	    		return w1.length();
	    	}
	    	
	        return w1.length() + w2.length() - 2 * lcs(w1, w2);
	    }
	    
	    int lcs(String s, String t) {
	    	int n = s.length(), m = t.length();
	    	int[][] dp = new int[n][m];
	    	dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
	    	for (int i = 1; i < n; ++i) {
	    		dp[i][0] = Math.max(dp[i-1][0], s.charAt(i) == t.charAt(0) ? 1 : 0);
	    	}
	    	
	    	for (int j = 1; j < m; ++j) {
	    		dp[0][j] = Math.max(dp[0][j-1], s.charAt(0) == t.charAt(j) ? 1 : 0);
	    	}
	    	
	    	for (int i = 1; i < n; ++i) {
	    		for (int j = 1; j < m; ++j) {
	    			if (s.charAt(i) == t.charAt(j)) {
	    				// can be simplified?
	    				dp[i][j] = Math.max(dp[i-1][j-1] + 1, Math.max(dp[i-1][j], dp[i][j -1]));
	    			} else {
	    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j -1]);
	    			}
	    		}
	    	}
	    	return dp[n-1][m-1];
	    }
	}

}
