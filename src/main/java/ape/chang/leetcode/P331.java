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
		assertThat(solution.isValidSerialization("1,#"), equalTo(false));
		assertThat(solution.isValidSerialization("9,#,#,1"), equalTo(false));
		assertThat(solution.isValidSerialization("#,#"), equalTo(false));
		assertThat(solution.isValidSerialization("9,#,93,#,9,9,#,#,#"), equalTo(true));
		assertThat(solution.isValidSerialization("9,9,91,#,#,9,#,49,#,#,#"), equalTo(true));
	}
	
	class Solution {
	    public boolean isValidSerialization(String preorder) {
	    	if ("#".equals(preorder)) {
	    		return true;
	    	}
	    	
	    	Stack<String> deque = new Stack<>();
	    	for (String s : preorder.split(",")) {
	    		deque.push(s);
	    		
	    		if ("#".equals(s)) {
	    			while (deque.size() >= 3) {
	    	    		String r = deque.pop();
	    	    		String t = deque.pop();
	    	    		String p = deque.pop();
	    	    		if (("#".equals(r) || "$".equals(r)) &&
	    	    				("#".equals(t) || "$".equals(t))) {
	    	    			if ((Character.isDigit(p.charAt(0)))) {	    				
	    	    				deque.push("$");
	    	    			} else {
	    	    				return false;
	    	    			}
	    	    		} else {
	    	    			deque.push(p);
	    	    			deque.push(t);
	    	    			deque.push(s);
	    	    			break;
	    	    		}
	    	    	}
	    		}
	    	}
	    	return deque.size() == 1 && deque.pop().equals("$");
	    }
	    
	}

}
