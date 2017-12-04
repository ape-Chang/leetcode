package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Test;

public class P682 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.calPoints(new String[] {"5","2","C","D","+"}), equalTo(30));
		assertThat(solution.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}), equalTo(27));
	}
	
	class Solution {
	    public int calPoints(String[] ops) {
	        Stack<Integer> stack = new Stack<Integer>();
	        for (String op : ops) {
	        	switch (op) {
				case "+":
					int a = stack.pop();
					int b = stack.pop();
					int s = a + b;
					stack.push(b);
					stack.push(a);
					stack.push(s);
					break;
				case "C":
					stack.pop();
					break;
				case "D":
					stack.push(2*stack.peek());
					break;
				default:
					stack.push(Integer.parseInt(op));
					break;
				}
	        }
	        int s = 0;
	        for (Integer e : stack) {
	        	s += e;
	        }
	        return s;
	    }
	}

}
