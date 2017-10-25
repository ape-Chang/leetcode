package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P662 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.widthOfBinaryTree(Parsers.parseTree("(1, (3, (5, (), ()), (3, (), ())), (2, (), (9, (), ())))")), equalTo(4));
		assertThat(solution.widthOfBinaryTree(Parsers.parseTree("(1, (3, (5, (), ()), (3, (), ())), ())")), equalTo(2));
		assertThat(solution.widthOfBinaryTree(Parsers.parseTree("(1, (3, (5, (), ()), ()), (2, (), ()))")), equalTo(2));
		assertThat(solution.widthOfBinaryTree(Parsers.parseTree("(1, (3, (5, (6, (), ()), ()), ()), (2, (), (9, (), (7, (), ()))))")), equalTo(8));
	}

	
	class Solution {
	    public int widthOfBinaryTree(TreeNode root) {
	    	int maxWidth = 0;
	    	List<TreeNode> nodesOfThisLevel = new ArrayList<TreeNode>();
	    	nodesOfThisLevel.add(root);
	    	while (!nodesOfThisLevel.isEmpty()) {
	    		int p = 0, q = nodesOfThisLevel.size() - 1;
	    		while(p < q && nodesOfThisLevel.get(p) == null) {
	    			++p;
	    		}
	    		while (p < q && nodesOfThisLevel.get(q) == null) {
	    			--q;
	    		}
	    		
	    		if (nodesOfThisLevel.get(p) == null && nodesOfThisLevel.get(q) == null) {
	    			break;
	    		}
	    		
	    		maxWidth = Math.max(maxWidth, q-p+1);
	    		List<TreeNode> nodesOfNextLevel = new ArrayList<TreeNode>();
	    		for (; p <= q; ++p) {
	    			TreeNode node = nodesOfThisLevel.get(p);
	    			if (node == null) {
	    				nodesOfNextLevel.add(null);
	    				nodesOfNextLevel.add(null);
	    			} else {
	    				nodesOfNextLevel.add(node.left);
	    				nodesOfNextLevel.add(node.right);
	    			}
	    		}
	    		nodesOfThisLevel = nodesOfNextLevel;
	    	}
	        return maxWidth;
	    }
	}
	
}
