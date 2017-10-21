package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P611 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat(solution.triangleNumber(new int[] {2,2,3,4}), equalTo(3));
	}

	class Solution {
	    public int triangleNumber(int[] a) {
	    	Arrays.sort(a);
	    	int n = a.length, count = 0;
	    	for (int i = 0; i < n; ++i) {
	    		for (int j = i+2; j < n; ++j) {
	    			for (int k = i+1; k < j; ++k) {
	    				if (a[i] + a[k] > a[j]) {
	    					count++;
	    				}
	    			}
	    		}
	    	}
	    	return count;
	    }
	}
	
}
