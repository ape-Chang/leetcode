package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P678 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat(true, equalTo(solution.checkValidString("()")));
		assertThat(true, equalTo(solution.checkValidString("(*)")));
		assertThat(true, equalTo(solution.checkValidString("(*))")));
	}
	
	class Solution {
	    public boolean checkValidString(String s) {
	    	char[] a = s.toCharArray();
	    	int n = a.length;
	    	
	    	char[] leftParentheses = new char[n];
	    	char[] rightParentheses = new char[n];
	    	int l, r;
	    	for (int i = 0; i < n; ++i) {
	    		if (a[i] == '(') {
	    			
	    		}
	    	}
	    	return true;
	    }
	}

}
