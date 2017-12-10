package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P665 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.checkPossibility(new int[] {4, 2, 3}), equalTo(true));
		assertThat(solution.checkPossibility(new int[] {4, 2, 1}), equalTo(false));
		assertThat(solution.checkPossibility(new int[] {2,3,3,2,4}), equalTo(true));
	}
	
	class Solution {
	    public boolean checkPossibility(int[] a) {
	        int k = 0, p = 0, q = 0;
	        for (int i = 1; i < a.length; ++i) {
	        	if (a[i] < a[i-1]) {
	        		++k;
	        		p = i-1;
	        		q = i;
	        	}
	        }
	        if (k == 0) {
	        	return true;
	        }
	        if (k > 1) {
	        	return false;
	        }
	        
	        return p == 0 || q == a.length-1 || a[p-1] <= a[p+1] || a[q-1] <= a[q+1];
	    }
	}

}
