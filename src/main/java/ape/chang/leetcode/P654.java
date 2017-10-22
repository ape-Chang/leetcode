package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class P654 extends TestParameterParseSupport {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5}), equalTo(parse("(6, (3, (), (2, (), (1, (), ()))), (5, (0, (), ()), ()))")));
	}
	
	@Test
	public void testIndexOfMax() {
		assertThat(solution.indexOfMax(new int[] {1, 2, 3}), equalTo(2));
		assertThat(solution.indexOfMax(new int[] {1, 3, 2}), equalTo(1));
		assertThat(solution.indexOfMax(new int[] {4, 3, 2}), equalTo(0));
	}
	
	class Solution {
	    public TreeNode constructMaximumBinaryTree(int[] nums) {
	    	int n = nums.length;
	    	int idx = indexOfMax(nums);
	    	TreeNode root = new TreeNode(nums[idx]);
	    	if (idx != 0) {
	    		root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
	    	}
	    	if (idx != n - 1) {
	    		root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx+1, n));
	    	}
	        return root;
	    }
	    
	    int indexOfMax(int[] a) {
	    	int k = 0;
	    	int max = Integer.MIN_VALUE;
	    	for (int i = 0; i < a.length; ++i) {
	    		if (max < a[i]) {
	    			k = i;
	    			max = a[i];
	    		}
	    	}
	    	return k;
	    }
	}

}
