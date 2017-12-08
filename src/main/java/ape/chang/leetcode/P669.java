package ape.chang.leetcode;

public class P669 {
	
	class Solution {
	    public TreeNode trimBST(TreeNode root, int L, int R) {
	    	if (root == null) {
	    		return null;
	    	}
	    	
	    	root.left = trimBST(root.left, L, R);
	    	root.right = trimBST(root.right, L, R);
	        
	        if (root.val < L || root.val > R) {
	        	if (root.left == null) {
	        		return root.right;
	        	}
	        	if (root.right == null) {
	        		return root.left;
	        	}
	        	TreeNode p = root.right;
	        	while (p.left != null) {
	        		p = p.left;
	        	}
	        	p.left = root.left;
	        	return root.right;
	        } else {
	        	return root;
	        }
	    }
	}

}
