package ape.chang.leetcode;

public class P450 {
	
	class Solution {
	    public TreeNode deleteNode(TreeNode root, int key) {
	    	// the corner case
	    	if (root == null) {
	    		return null;
	    	}
	    	
	        if (root.val == key) {
	        	if (root.right == null) {
	        		return root.left;
	        	}
	        	if (root.left == null) {
	        		return root.right;
	        	}
	        	
	        	TreeNode p = root.right;
	        	while (p.left != null) {
	        		p = p.left;
	        	}
	        	
	        	p.left = root.left;
	        	return root.right;
	        }
	        
	        if (root.val > key) {
	        	root.left = deleteNode(root.left, key);
	        } else {
	        	root.right = deleteNode(root.right, key);
	        }
	        return root;
	    }
	}

}
