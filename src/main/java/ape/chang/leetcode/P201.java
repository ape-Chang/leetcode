package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P201 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.rangeBitwiseAnd(5, 7), equalTo(4));
		assertThat(solution.rangeBitwiseAnd(1, 2), equalTo(0));
		assertThat(solution.rangeBitwiseAnd(700000000, 2147483641), equalTo(0));
		assertThat(solution.rangeBitwiseAnd(6, 8), equalTo(0));
		assertThat(solution.rangeBitwiseAnd(10, 12), equalTo(8));
	}
	
	class Solution {
	    public int rangeBitwiseAnd(int m, int n) {
	    	if (lengthOfBits(m) != lengthOfBits(n)) {
	    		return 0;
	    	}
	    	
	    	int k = 0;
	    	for (; (m>>k) != (n>>k); ++k)
	    		;
	    	return (~0 << k) & m;
	    }
	    
	    private int lengthOfBits(int n) {
	    	int k = 0;
	    	for (; n != 0; n >>= 1, ++k) 
	    		;
	    	return k;
	    }
	    
	    public int rangeBitwiseAnd0(int m, int n) {
	    	int k = m;
	    	for (int i = m + 1; i <= n && k != 0; ++i) {
	    		k &= i;
	    	}
	    	return k;
	    }
	}

}
