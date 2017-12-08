package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P566 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 1, 4), equalTo(new int[][] {{1, 2, 3, 4}})); 
	}
	
	class Solution {
	    public int[][] matrixReshape(int[][] a, int r, int c) {
	    	int n = a.length, m = a[0].length;
	    	if (r > 0 && c > 0 && m*n == r*c) {
	    		int[][] b = new int[r][c];
	    		for (int i = 0; i < n; ++i) {
	    			for (int j = 0; j < m; ++j) {
	    				int k = i*m + j;
	    				b[k/c][k%c] = a[i][j];
	    			}
	    		}
	    		return b;
	    	} else {
	    		return a;
	    	}
	    }
	}

}
