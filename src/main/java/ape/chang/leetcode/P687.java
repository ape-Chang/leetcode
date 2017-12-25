package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class P687 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.longestUnivaluePath(Parsers.parseTree("(5, (), (5, (5, (), ()), ()))")), equalTo(2));
	}
	
	/*
	 * TODO remove duplicates
	 */
	
	class Solution {
	    public int longestUnivaluePath(TreeNode root) {
	    	if (root == null) {
	    		return 0;
	    	}
	    	
	    	int max = 0, k = 0;
	    	Wrapper wrapper;
	    	Queue<Wrapper> queue = new LinkedList<>();
	    	queue.offer(wrap(root));
	    	while (!queue.isEmpty()) {
	    		wrapper = queue.poll();
	    		root = wrapper.node;
	    		k = 1;
	    		
	    		if (wrapper.left != null) {
	    			queue.offer(wrapper.left);
	    			if (root.val == root.left.val) {
	    				k += wrapper.left.count;
	    			}
	    		}
	    		if (wrapper.right != null) {
	    			queue.offer(wrapper.right);
	    			if (root.val == root.right.val) {
	    				k += wrapper.right.count;
	    			}
	    		}
	    		max = Math.max(max, k);
	    	}
	    	return max-1;
	    }
	    
	    Wrapper wrap(TreeNode node) {
	    	Wrapper wrapper = new Wrapper();
	    	wrapper.node = node;
	    	if (node.left != null) {
	    		wrapper.left = wrap(node.left);
	    		if (node.val == node.left.val) {
	    			wrapper.count = Math.max(
	    					wrapper.count, wrapper.left.count+1);
	    		}
	    	}
	    	if (node.right != null) {
	    		wrapper.right = wrap(node.right);
	    		if (node.val == node.right.val) {
	    			wrapper.count = Math.max(
	    					wrapper.count, wrapper.right.count+1);
	    		}
	    	}
	    	return wrapper;
	    }
	    
	    class Wrapper {
	    	TreeNode node;
	    	Wrapper left;
	    	Wrapper right;
	    	// count of consecutive nodes with the same value, 
	    	// from this node to its descendant.
	    	// so default to 1.
	    	int count = 1;
	    }
	}

}
