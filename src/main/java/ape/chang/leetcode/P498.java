package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P498 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findDiagonalOrder(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		}), equalTo(new int[] {1,2,4,7,5,3,6,8,9}));
	}
	
	class Solution {
		private static final int UP_RIGHT  = 0;
		private static final int DOWN_LEFT = 1;
	    public int[] findDiagonalOrder(int[][] matrix) {
	    	if (matrix.length == 0) {
	    		return new int[0];
	    	}
	    	
	        int n = matrix.length, m = matrix[0].length;
	        int[] vector = new int[n * m];
	        int x = 0, y = 0, k = 0, p, q, dir = UP_RIGHT;
	        vector[0] = matrix[0][0];
	        while (++k < vector.length) {
	        	switch (dir) {
				case UP_RIGHT:
					p = x-1;
					q = y+1; 
					if (q == m) {
						x = x+1;
						y = m-1;
						dir = DOWN_LEFT;
					} else if (p < 0) {
						y = y+1;
						dir = DOWN_LEFT;
					} else {
						x = p;
						y = q;
					}
					break;
				case DOWN_LEFT:
					p = x+1;
					q = y-1;
					if (p == n) {
						x = n-1;
						y = y+1;
						dir = UP_RIGHT;
					} else if (q < 0) {
						x = x+1;
						dir = UP_RIGHT;
					} else {
						x = p;
						y = q;
					}
					break;

				default:
					break;
				}
	        	vector[k] = matrix[x][y];
	        }
	        return vector;
	    }
	}

}
