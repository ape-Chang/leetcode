package ape.chang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P640 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertEquals(solution.solveEquation("x+5-3+x=6+x-2"), "x=2");
		assertEquals(solution.solveEquation("x=x"), "Infinite solutions");
		assertEquals(solution.solveEquation("2x=x"), "x=0");
		assertEquals(solution.solveEquation("2x+3x-6x=x+2"), "x=-1");
		assertEquals(solution.solveEquation("x=x+2"), "No solution");
	}
	
	class Solution {
	    public String solveEquation(String equation) {
	    	return "";
	    }
	}

}
