package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P343 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.integerBreak(10), equalTo(36));
		assertThat(solution.integerBreak(2), equalTo(1));
	}
	
	class Solution {
	    public int integerBreak(int n) {
	    	int max = 1;
	    	for (int i = 2; i < n; ++i) {
	    		int[] a = new int[i];
	    		Arrays.fill(a, n/i);
	    		for (int j = 0; j < n%i; ++j) {
	    			a[j]++;
	    		}
	    		int p = 1;
	    		for (int j = 0; j < i; ++j) {
	    			p *= a[j];
	    		}
	    		if (p < max) {
	    			break;
	    		} else {
	    			max = p;
	    		}
	    	}
	    	return max;
	    }
	}

}
