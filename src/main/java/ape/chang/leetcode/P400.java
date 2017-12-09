package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P400 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findNthDigit(1), equalTo(1));
		assertThat(solution.findNthDigit(9), equalTo(9));
		assertThat(solution.findNthDigit(10), equalTo(1));
		assertThat(solution.findNthDigit(11), equalTo(0));
		assertThat(solution.findNthDigit(12), equalTo(1));
		assertThat(solution.findNthDigit(13), equalTo(1));
		assertThat(solution.findNthDigit(14), equalTo(1));
		assertThat(solution.findNthDigit(15), equalTo(2));
		assertThat(solution.findNthDigit(1000000000), equalTo(1));	
	}
	
	class Solution {
	    public int findNthDigit(int n) {
	    	int[] b = new int[] {
	    			9 * 1, 
	    			90 * 2, 
	    			900 * 3, 
	    			9000 * 4, 
	    			90000 * 5, 
	    			900000 * 6, 
	    			9000000 * 7, 
	    			90000000 * 8, 
//	    			900000000 * 9 // overflow
	    	};
	    	int k = 0;
	    	while (k < b.length && n-b[k] >= 0) {
	    		n -= b[k];
	    		k++;
	    	}
	    	
	    	if (n == 0) {
	    		return 9;
	    	}
	    	
	    	n--;
	    	int t = (int) Math.pow(10, k), s = n / (k+1), r = n % (k+1), p = t + s, d = p / t;
	    	while (r-- > 0) {
	    		p = p % t;
	    		t = t / 10;
	    		d = p / t;
	    	}
	    	return d;
	    }
	}

}
