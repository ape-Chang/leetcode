package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class P215 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 2), equalTo(5));
		assertThat(solution.findKthLargest(new int[] {2,1}, 2), equalTo(1));
	}
	
	@Ignore
	@Test
	public void testPartition() {
		assertThat(solution.partition(new int[] {3,2,1,5,6,4}), equalTo(2));
		assertThat(solution.partition(new int[] {2, 1}), equalTo(1));
		assertThat(solution.partition(new int[] {1, 2}), equalTo(0));
		assertThat(solution.partition(new int[] {2, 2, 3}), equalTo(0));
		assertThat(solution.partition(new int[] {2, 2, 1, 3}), equalTo(1));
	}
	
	class Solution {
	    public int findKthLargest(int[] nums, int k) {
	    	int n = nums.length, l = 0, h = n-1;
	    	int[] a = Arrays.copyOf(nums, n);
	    	while (true) {
	    		int p = partition(a, l, h);
	    		if (k-1 == h-p) {
	    			return a[p];
	    		}
	    		
	    		if (h-p >= k) {
	    			l = p+1;
	    		} else {
	    			k = k - (h-p+1);
	    			h = p-1;
	    		}
	    	}
	    }
	    
	    private int partition(int[] a, int l, int h) {
	    	int p = a[l];
	    	while (l < h) {	    		
	    		for (; l < h && a[h] >= p; --h)
	    			;
	    		a[l] = a[h];
	    		for (; l < h && a[l] <  p; ++l)
	    			;
	    		a[h] = a[l];
	    	}
	    	a[l] = p;
	    	return l;
	    }
	    
	    private int partition(int[] a) {
	    	return partition(a, 0, a.length-1);
	    }
	}

}
