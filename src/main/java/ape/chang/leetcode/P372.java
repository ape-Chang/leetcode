package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P372 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.superPow(2, new int[] {3}), equalTo(8));
		assertThat(solution.superPow(2, new int[] {1, 0}), equalTo(1024));
	}
	
	class Solution {
	    public int superPow(int a, int[] b) {
	        int p = 1;
	        for (int k : b) {
	        	p = (pow(p, 10) * pow(a, k)) % 1337;
	        }
	        return p;
	    }
	    
	    int pow(int b, int p) {
	    	if (b == 0) {
	    		return 0;
	    	}
	    	
	    	if (p == 0) {
	    		return 1;
	    	}
	    	
	    	if (b > 1337) {
	    		return pow(b%1337, p);
	    	}
	    	
	    	int s = pow(b, p/2) % 1337, t = (s*s) % 1337;
	    	if (p%2 == 0) {
	    		return t;
	    	} else {
	    		return (t * b) % 1337;
	    	}
	    }
	}

}
