package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P540 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}), equalTo(2));
		assertThat(solution.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}), equalTo(10));
	}
	
	class Solution {
	    public int singleNonDuplicate(int[] a) {
	        int l = 0, h = a.length-1, m;
	        while (l < h) {
	        	m = (l+h) / 2;
	        	if (a[m] != a[m-1] && a[m] != a[m+1]) {
	        		return a[m];
	        	} 
	        	if (a[m] != a[m-1]) {
	        		if (((m-l) & 0x1) == 1) {
	        			h = m-1;
	        		} else {
	        			l = m;
	        		}
	        	} else {
	        		if (((h-m) & 0x1) == 1) {
	        			l = m+1;
	        		} else {
	        			h = m;
	        		}
	        	}
	        }
	        return a[l];
	    }
	}

}
