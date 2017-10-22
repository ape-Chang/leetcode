package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P650 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.minSteps(1), equalTo(0));
		assertThat(solution.minSteps(3), equalTo(3));
		assertThat(solution.minSteps(4), equalTo(4));
	}
	
	@Test
	public void testLog2() {
		assertThat(solution.log2(1), equalTo(0));
		assertThat(solution.log2(2), equalTo(1));
		assertThat(solution.log2(3), equalTo(2));
		assertThat(solution.log2(10), equalTo(4));
	}
	
	@Test
	public void testFactorize() {
		assertThat(solution.factorize(2), equalTo(new int[] {2}));
		assertThat(solution.factorize(7), equalTo(new int[] {7}));
		assertThat(solution.factorize(9), equalTo(new int[] {3, 3}));
		assertThat(solution.factorize(20), equalTo(new int[] {2, 2, 5}));
	}

	class Solution {
	    public int minSteps(int n) {
	    	if (n == 1) {
	    		return 0;
	    	}
	    	
	    	int steps = 0;
	    	int[] factors = factorize(n);
	    	for (int factor : factors) {
	    		steps += (factor-1);
	    		steps += 1;
	    	}
	        return steps;
	    }
	    
	    int[] factorize(int n) {
	    	int[] f = new int[log2(n)];
	    	int k = 0;
	    	for (int d = 2; d <= n; ++d) {
	    		if (n % d == 0) {
	    			f[k++] = d;
	    			n = n / d;
	    			while (n % d == 0) {
	    				f[k++] = d;
	    				n = n / d;
	    			}
	    		}
	    	}
	    	return Arrays.copyOfRange(f, 0, k);
	    }
	    
	    /*
	     * 2^k >= n > 2^(k-1)
	     */
	    int log2(int n) {
	    	int k = 0;
	    	while (n > (1 << k)) {
	    		++k;
	    	}
	    	return k;
	    }
	}
	
}
