package ape.chang.leetcode;

import java.util.Stack;

public class P230 {
	
	/*
	 * Traverse BST in-order.
	 * TODO And how to do it pre-order and post-order?
	 */
	
	class Solution {
	    public int kthSmallest(TreeNode root, int k) {
	        Stack<TreeNode> stack = new Stack<>();
	        while (root != null) {
	        	stack.push(root);
	        	root = root.left;
	        }
	        
	        while (true) {
	        	if (--k == 0) {
	        		return stack.peek().val;
	        	}
	        	
	        	root = stack.pop().right;
	        	while (root != null) {
		        	stack.push(root);
		        	root = root.left;
		        }
	        }
	    }
	}

}
