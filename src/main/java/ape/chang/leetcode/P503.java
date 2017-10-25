package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P503 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.nextGreaterElements(new int[] {1,2,1}), equalTo(new int[] {2,-1,2}));
	}

	class Solution {
	    public int[] nextGreaterElements(int[] nums) {
	        return null;
	    }
	}
	
}
