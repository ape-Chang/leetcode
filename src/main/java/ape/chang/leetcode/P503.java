package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ape.chang.primitives.IntStack;

public class P503 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.nextGreaterElements(new int[] {1,2,1}), equalTo(new int[] {2,-1,2}));
		assertThat(solution.nextGreaterElements(new int[] {1,1,1}), equalTo(new int[] {-1,-1,-1}));
		assertThat(solution.nextGreaterElements(new int[] {}), equalTo(new int[] {}));
	}

	class Solution {
	    public int[] nextGreaterElements(int[] nums) {
	    	int n = nums.length;
	    	if (n == 0) {
	    		return new int[0];
	    	}
	    	
	    	IntStack stack = new IntStack();
	    	int k = indexOfMax(nums);
	    	stack.push(k);

	    	int[] nge = new int[n];
	    	nge[k] = -1;
	    	while (--n > 0) {
	    		if (--k < 0) {
	    			k = nge.length - 1;
	    		}
	    		if (nums[k] < nums[stack.top()]) {
	    			nge[k] = nums[stack.top()];
	    			stack.push(k);
	    		} else {
	    			do {
	    				stack.pop();
	    			} while (!stack.isEmpty() && nums[k] >= nums[stack.top()]);
	    			if (stack.isEmpty()) {
	    				nge[k] = -1;
	    			} else {
	    				nge[k] = nums[stack.top()];
	    			}
	    			stack.push(k);
	    		}
	    	}
	        return nge;
	    }
	    
	    int indexOfMax(int[] a) {
	    	int idx = 0;
	    	for (int i = 0; i < a.length; ++i) {
	    		if (a[i] >= a[idx]) {
	    			idx = i;
	    		}
	    	}
	    	return idx;
	    }
	}
	
}
