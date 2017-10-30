package ape.chang.leetcode;

import ape.chang.primitives.IntDAG;

public class P210 {
	
	class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	    	IntDAG dag = new IntDAG(numCourses);
	        for (int[] prerequisite : prerequisites) {
	        	dag.addEdge(prerequisite[1], prerequisite[0]);
	        }
	        try {	        	
	        	return dag.sort();
	        } catch (IllegalStateException e) {
	        	return new int[0];
	        }
	    }
	}

}
