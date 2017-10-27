package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ape.chang.primitives.IntDisjointSet;
import ape.chang.primitives.IntSet;

@RunWith(Parameterized.class)
public class P547 {
	
	@Parameter(0)
	public int[][] M;
	@Parameter(1)
	public int expected;
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findCircleNum(M), equalTo(expected));
	}
	
	
	@Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][] {
			{new int[][] {
				{1,1,0},
				{1,1,0},
				{0,0,1}
			}, 2},
			{new int[][] {
				{1,1,0},
				{1,1,1},
				{0,1,1}
			}, 1},
			{new int[][] {
				{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
				{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
				{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
				{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
				{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
			}, 8}
		});
	}
	
	/*
	 * disjoint set
	 */
	class Solution {
	    public int findCircleNum(int[][] M) {
	    	int n = M.length;
	    	IntDisjointSet ds = new IntDisjointSet(n);
	    	for (int i = 0; i < n; ++i) {
	    		for (int j = i+1; j < n; ++j) {
	    			if (M[i][j] == 1) {
	    				ds.union(i, j);
	    			}
	    		}
	    	}
	    	
	    	IntSet s = new IntSet();
	    	for (int i = 0; i < n; ++i) {
	    		s.add(ds.find(i));
	    	}
	        return s.size();
	    }
	}

}
