package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P357 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.countNumbersWithUniqueDigits(2), equalTo(91));
		assertThat(solution.countNumbersWithUniqueDigits(1), equalTo(10));
		assertThat(solution.countNumbersWithUniqueDigits(0), equalTo(1));
	}
	
	class Solution {
	    public int countNumbersWithUniqueDigits(int n) {
	    	if (n == 0) {
	    		return 1;
	    	}
	    	
	        int[] c = new int[] {
	        		10, 
	        		9*9, 
	        		9*9*8, 
	        		9*9*8*7, 
	        		9*9*8*7*6, 
	        		9*9*8*7*6*5,
	        		9*9*8*7*6*5*4,
	        		9*9*8*7*6*5*4*3,
	        		9*9*8*7*6*5*4*3*2,
	        		9*9*8*7*6*5*4*3*2*1,
	        };
	        int s = 0;
	        for (int i = 0; i < Math.min(n, c.length); ++i) {
	        	s += c[i];
	        }
	        return s;
	    }
	}

}
