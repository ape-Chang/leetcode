package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Test;

public class P331 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"), equalTo(true));
	}
	
	class Solution {
	    public boolean isValidSerialization(String preorder) {
	    	String[] nodes = preorder.split(",");
	    	Stack<String> stack = new Stack<>();
	    	for (String node : nodes) {
	    		stack.push(node);
	    	}
	    	
	    	while (!stack.isEmpty()) {
	    		String right = stack.pop();
	    		if (stack.isEmpty()) {
	    			return false;
	    		}
	    		String left = stack.pop();
	    		if (stack.isEmpty()) {
	    			return false;
	    		}
	    		String value = stack.pop();
	    		if ("#".equals(right) && "#".equals(left)) {
	    			try {
	    				Integer.parseInt(value);
	    				stack.push("#");
	    			} catch (Exception e) {
	    				return false;
	    			}
	    		} else {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}

}
