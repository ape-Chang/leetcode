package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P419 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.countBattleships(new char[][] {
			"X..X".toCharArray(),
			"...X".toCharArray(),
			"...X".toCharArray()
		}), equalTo(2));
	}
	
	class Solution {
	    public int countBattleships(char[][] board) {
	        int c = 0, m = board.length, n = board[0].length;
	        for (int i = 0; i < m; ++i) {
	        	for (int j = 0; j < n; ++j) {
	        		if (board[i][j] == 'X') {
	        			if ((j == 0 || board[i][j-1] == '.') &&
	        					(i == 0 || board[i-1][j] == '.')) {
	        				++c;
	        			}
	        		}
	        	}
	        }
	        return c;
	    }
	}

}
