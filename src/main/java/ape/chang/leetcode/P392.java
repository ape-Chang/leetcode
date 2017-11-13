package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P392 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.isSubsequence("abc", "ahbgdc"), equalTo(true));
		assertThat(solution.isSubsequence("axc", "ahbgdc"), equalTo(false));
	}
	
	class Solution {
	    public boolean isSubsequence(String s, String t) {
	        int i = 0, j = 0, n = s.length(), m = t.length();
	        while (i < n && j < m) {
	        	if (s.charAt(i) == t.charAt(j)) {
	        		++i;
	        	}
	        	++j;
	        }
	        return i == n;
	    }
	}

}
