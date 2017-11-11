package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P456 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.find132pattern(new int[] {3,1,4,2}), equalTo(true));
		assertThat(solution.find132pattern(new int[] {3,5,0,3,4}), equalTo(true));
	}
	
	class Solution {
	    public boolean find132pattern(int[] a) {
	    	int n = a.length;
	    	int[] p = new int[n];
	    	
	    	for (int i = 0, k = 0; i < n; ++i) {
	    		if (p[k] >= a[i]) {
	    			k = i;
	    		}
	    		p[i] = a[k];
	    	}
	    	
	    	for (int i = 0; i < n; ++i) {
	    		if (a[i] > p[i]) {
	    			for (int j = i+1; j < n; ++j) {
	    				if (a[i] > a[j] && a[j] > p[i]) {
	    					return true;
	    				}
	    			}
	    		}
	    	}
	    	
	    	return false;
	    }
	}

}
