package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P657 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.judgeCircle("UD"), equalTo(true));
		assertThat(solution.judgeCircle("LL"), equalTo(false));
	}
	
	class Solution {
	    public boolean judgeCircle(String moves) {
	        int u = 0, d = 0, l = 0, r = 0;
	        for (char c : moves.toCharArray()) {
	        	switch (c) {
				case 'U':
					++u;
					break;
				case 'D':
					++d;
					break;
				case 'L':
					++l;
					break;
				case 'R':
					++r;
					break;
				default:
					break;
				}
	        }
	        return u == d && l == r;
	    }
	}

}
