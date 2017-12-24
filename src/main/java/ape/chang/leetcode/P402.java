package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P402 {
	
	Solution solution = new Solution();
	@Test
	public void test() {
		assertThat(solution.removeKdigits("10", 2), equalTo("0"));
		assertThat(solution.removeKdigits("1432219", 3), equalTo("1219"));
		assertThat(solution.removeKdigits("10200", 1), equalTo("200"));
		assertThat(solution.removeKdigits("10", 1), equalTo("0"));
	}
	
	class Solution {
	    public String removeKdigits(String d, int k) {
	    	int n = d.length();
	    	// corner case
	    	if (n == k) {
	    		return "0";
	    	}
	    	 
	    	char[] r = new char[n - k];
	    	// p is the pointer of r, q is the pointer of d
	    	for (int p = 0, q = 0; p < r.length; ++p, ++q) {	    		
	    		r[p] = smallestOfRange(d, q, q+k);
	    		for (; r[p] != d.charAt(q); ++q, --k) {
	    			;
	    		}
	    	}
	    	// change the meaning of k, remove leading zeroes
	    	for (k = 0; k < r.length && r[k] == '0'; ++k)
	    		;
	    	// another corner case
	        return (k == r.length) ? "0" : new String(r, k, r.length-k);
	    }
	    
	    char smallestOfRange(String s, int p, int q) {
	    	char c = s.charAt(p);
	    	for (++p; p <= q; ++p) {
	    		if (c > s.charAt(p)) {
	    			c = s.charAt(p);
	    		}
	    	}
	    	return c;
	    }
	}

}
