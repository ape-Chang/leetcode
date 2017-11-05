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
		assertEquals(solution.solveEquation("-x=-1"), "x=1");
	}
	
	class Solution {
	    public String solveEquation(String equation) {
	    	int indexOfEqualSign = equation.indexOf('=');
	    	String leftExpression = equation.substring(0, indexOfEqualSign);
	    	String rightExpression = equation.substring(indexOfEqualSign+1);
	    	int[] coe = minus(eval(leftExpression), eval(rightExpression));
	    	if (coe[0] == 0 && coe[1] == 0) {
	    		return "Infinite solutions";
	    	}
	    	if (coe[0] != 0 && coe[1] == 0) {
	    		return "No solution";
	    	}
	    	return String.format("x=%d", -coe[0] / coe[1]);
	    }
	    
	    int[] minus(int[] a, int[] b) {
	    	int[] coe = new int[2];
	    	coe[0] = a[0] - b[0];
	    	coe[1] = a[1] - b[1];
	    	return coe;
	    }
	    
	    int[] eval(String expr) {
	    	expr = expr.trim();
	    	
	    	int[] coe = new int[2];
	    	int p = 0, q = p, n = expr.length();
	    	
	    	while (p < n) {
	    		q = p+1;
	    		while (q < n) {
	    			char c = expr.charAt(q);
	    			if (c == '+' || c == '-') {
	    				break;
	    			}
	    			++q;
	    		}
	    		int[] item = parse(expr.substring(p, q));
	    		coe[0] += item[0];
	    		coe[1] += item[1];
	    		
	    		p = q;
	    	}
	    	return coe;
	    }
	    
	    int[] parse(String expr) {
	    	expr = expr.trim();
	    	
	    	int[] coe = new int[2];
	    	int n = expr.length();
	    	if (expr.charAt(n-1) == 'x') {
	    		if (expr.charAt(0) == '+' && n == 2) {
	    			coe[1] = 1;
	    		} else if (expr.charAt(0) == '-' && n == 2) {
	    			coe[1] = -1;
	    		} else if (n == 1){
	    			coe[1] = 1;
	    		} else {
	    			coe[1] = Integer.parseInt(expr.substring(0, n-1));
	    		}
	    	} else {
	    		coe[0] = Integer.parseInt(expr);
	    	}
	    	
	    	return coe;
	    }
	}

}
