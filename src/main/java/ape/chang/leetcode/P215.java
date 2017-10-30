package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P215 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 2), equalTo(5));
	}
	
	class Solution {
	    public int findKthLargest(int[] nums, int k) {
	    	int n = nums.length;
	        return p(Arrays.copyOf(nums, n), 0, n - 1, k);
	    }
	    
	    private int p(int[] a, int l, int h, int k) {
	    	int p = a[l], i = l, j = h, t;
	    	
	    	for (++i; i <= j && a[i] >= p; ++i)
	    		;
	    	
	    	while (i < j) {
	    		if (a[j] >= p) {
	    			t    = a[j];
	    			a[j] = a[i];
	    			a[i] = t;
	    			++i;
	    		} else {
	    			--j;
	    		}
	    	}
	    	return 0;
	    }
	}

}
