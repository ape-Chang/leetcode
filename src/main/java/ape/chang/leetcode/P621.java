package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P621 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat(solution.leastInterval(new char[] {'A','A','A','B','B','B'}, 2), equalTo(8));
	}
	
	class Solution {
	    public int leastInterval(char[] tasks, int n) {
	    	return 0;
	    }
	}

}
