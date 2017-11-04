package ape.chang.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class P717 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertTrue(solution.isOneBitCharacter(new int[] {1, 0, 0}));
		assertTrue(!solution.isOneBitCharacter(new int[] {1, 1, 1, 0}));
	}
	
	class Solution {
	    public boolean isOneBitCharacter(int[] bits) {
	        int n = bits.length, i = 0, s = 0;
	        if (bits[n-1] == 1) {
	        	return false;
	        } else {
	        	while (true) {
	        		s = (bits[i] == 0) ? 1 : 2;
	        		if (i + s == n) {
	        			return (s == 1);
	        		}
	        		i += s;
	        	}
	        }
	    }
	}

}
