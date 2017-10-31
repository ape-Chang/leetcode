package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P233 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.countDigitOne(13), equalTo(6));
	}
	
	class Solution {
	    public int countDigitOne(int n) {
	        return 0;
	    }
	}

}
