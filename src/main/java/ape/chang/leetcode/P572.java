package ape.chang.leetcode;

public class P572 {
	
	class Solution {
	    public boolean isSubtree(TreeNode s, TreeNode t) {
	        return isSameTree(s, t) || ((s != null && isSubtree(s.left, t) || isSubtree(s.right, t)));
	    }
	    
	    boolean isSameTree(TreeNode s, TreeNode t) {
	    	if (s == null && t == null) {
	    		return true;
	    	}
	    	if (s == null || t == null) {
	    		return false;
	    	}
	    	return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	    }
	}

}
