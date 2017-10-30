package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ape.chang.primitives.IntDAG;

public class P207 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.canFinish(2, new int[][] {{1, 0}}), equalTo(true));
		assertThat(solution.canFinish(2, new int[][] {{1, 0}, {0, 1}}), equalTo(false));
	}
	
	class Solution {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        IntDAG dag = new IntDAG(numCourses);
	        for (int[] prerequisite : prerequisites) {
	        	dag.addEdge(prerequisite[1], prerequisite[0]);
	        }
	        try {
	        	dag.sort();
	        	return true;
	        } catch (IllegalStateException e) {
	        	return false;
	        }
	    }
	}

}
