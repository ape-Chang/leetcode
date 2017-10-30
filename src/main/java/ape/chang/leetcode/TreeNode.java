package ape.chang.leetcode;

public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return Parsers.print(this);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (o instanceof TreeNode) {
			TreeNode n = (TreeNode) o;
			return val == n.val && 
					(left == null ? n.left == null : left.equals(n.left)) &&
					(right == null ? n.right == null : right.equals(n.right));
		}
		
		return false;
	}

}
