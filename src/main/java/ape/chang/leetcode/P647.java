package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P647 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.countSubstrings("abc"), equalTo(3));
		assertThat(solution.countSubstrings("aaa"), equalTo(6));
	}
	
	
	class Solution {
	    public int countSubstrings(String s) {
	    	return doCountSubstrings1(s);
	    }
	    
	    int doCountSubstrings1(String s) {
	    	int n = s.length(), count = 0;
	    	boolean[] dp = new boolean[n];
	    	for (int i = n-1; i >= 0; --i) {
	    		for (int j = n-1; j >= i; --j) {
	    			if (dp[j] = (s.charAt(i) == s.charAt(j) && (i+1 >= j-1 ? true : dp[j-1]))) {
	    				++count;
	    			}
	    		}
	    	}
	    	return count;
	    }
	    
	    int doCountSubstrings0(String s) {
	    	int n = s.length(), count = 0;
	    	boolean[][] dp = new boolean[n][n];
	    	for (int i = n-1; i >= 0; --i) {
	    		for (int j = n-1; j >= i; --j) {
	    			if (dp[i][j] = (s.charAt(i) == s.charAt(j) && (i+1 >= j-1 ? true : dp[i+1][j-1]))) {
	    				++count;
	    			}
	    		}
	    	}
	    	return count;
	    }
	}

}
