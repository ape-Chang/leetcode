package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ape.chang.primitives.IntDAG;

public class P646 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findLongestChain(new int[][] {
			{1,2}, 
			{2,3}, 
			{3,4}
		}), equalTo(2));
	}
	
	class Solution {
	    public int findLongestChain(int[][] pairs) {
	    	int n = pairs.length;
	    	IntDAG dag = new IntDAG(n);
	    	for (int i = 0; i < n; ++i) {
	    		for (int j = 0; j < n; ++j) {
	    			if (pairs[i][1] < pairs[j][0]) {
	    				dag.addEdge(i, j);
	    			}
	    		}
	    	}
	    	
	        return dag.maxDistance();
	    }
	    
	}

}
