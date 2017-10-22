package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P650 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.minSteps(3), equalTo(3));
	}

	class Solution {
	    public int minSteps(int n) {
	        return 0;
	    }
	}
	
}
