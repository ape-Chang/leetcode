package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P477 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.totalHammingDistance(new int[] {4, 14, 2}), equalTo(6));
	}
	
	class Solution {
	    public int totalHammingDistance(int[] a) {
	    	int s = 0;
	    	for (int i = 0; i < Integer.SIZE; ++i) {
	    		int m = 1 << i, o = 0, l = 0;
	    		for (int j = 0; j < a.length; ++j) {
	    			if ((a[j] & m) == 0) {
	    				o++;
	    			} else {
	    				l++;
	    			}
	    		}
	    		s += (o*l);
	    	}
	        return s;
	    }
	}

}
