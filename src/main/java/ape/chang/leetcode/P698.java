package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P698 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4), equalTo(true));
	}
	
	class Solution {
	    public boolean canPartitionKSubsets(int[] nums, int k) {
	        return false;
	    }
	}
}
