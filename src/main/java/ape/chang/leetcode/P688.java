package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P688 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.knightProbability(3, 2, 0, 0), equalTo(0.0625));
	}
	
	class Solution {
	    public double knightProbability(int N, int K, int r, int c) {
	        return 0.0;
	    }
	}

}
