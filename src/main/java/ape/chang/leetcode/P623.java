package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P623 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.addOneRow(Parsers.parseTree("(4, (2, (3, (), ()), (1, (), ())), (6, (5, (), ()), ()))"), 1, 2),
				equalTo(Parsers.parseTree(("(4, (1, (2, (3, (), ()), (1, (), ())), ()), (1, (), (6, (5, (), ()), ())))"))));
		
		assertThat(solution.addOneRow(Parsers.parseTree("(4, (2, (3, (), ()), (1, (), ())), ())"), 1, 3),
				equalTo(Parsers.parseTree("(4, (2, (1, (3, (), ()), ()), (1, (), (1, (), ()))), ())")));
	}
	
	class Solution {
	    public TreeNode addOneRow(TreeNode root, int v, int d) {
	    	if (d == 1) {
	    		TreeNode node = new TreeNode(v);
	    		node.left = root;
	    		return node;
	    	} else {
	    		List<TreeNode> nodesOfThisLevel = new ArrayList<TreeNode>();
	    		nodesOfThisLevel.add(root);
	    		for (--d; d > 1; --d) {
	    			List<TreeNode> nodesOfNextLevel = new ArrayList<TreeNode>();
	    			for (TreeNode node : nodesOfThisLevel) {
	    				if (node.left != null) {
	    					nodesOfNextLevel.add(node.left);
	    				}
	    				if (node.right != null) {
	    					nodesOfNextLevel.add(node.right);
	    				}
	    			}
	    			nodesOfThisLevel = nodesOfNextLevel;
	    		}
	    		
	    		for (TreeNode node : nodesOfThisLevel) {
	    			TreeNode p = new TreeNode(v);
	    			p.left = node.left;
	    			node.left = p;
	    			TreeNode q = new TreeNode(v);
	    			q.right = node.right;
	    			node.right = q;
	    		}
	    		
	    		return root;
	    	}
	    }
	}

}
