package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

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
	    	char[] b = new char[s.length()];
	    	int q = -1;
	    	for (char c : s.toCharArray()) {
	    		if (c == ')' && q >= 0 && b[q] == '(') {
	    			q--;
	    		} else {
	    			b[++q] = c;
	    		}
	    	}
	    	
	    	if (q == -1) {
	    		return true;
	    	} else {
	    		int p = 0;
	    		while (p < q && b[p] == '(' && b[q] == ')') {
	    			p++;
	    			q--;
	    		}
	    		
	    		if (p == q) {
	    			return b[p] == '*';
	    		} 
	    		
	    		if (p > q){
	    			return true;
	    		}
	    		
	    		// p < q
	    		b = Arrays.copyOfRange(b, p, q+1);
	    		
	    	}
	    	
	    	return true;
	    }
	}

}
