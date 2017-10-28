package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P513 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findBottomLeftValue(Parsers.parseTree("(2, (1, (), ()), (3, (), ()))")), equalTo(1));
		assertThat(solution.findBottomLeftValue(Parsers.parseTree("(1, (2, (4, (), ()), ()), (3, (5, (7, (), ()), ()), (6, (), ())))")), equalTo(7));
	}
	
	class Solution {
	    public int findBottomLeftValue(TreeNode root) {
	    	List<TreeNode> nodesOfThisLevel = new ArrayList<TreeNode>();
	    	nodesOfThisLevel.add(root);
	    	while (true) {
	    		List<TreeNode> nodesOfNextLevel = new ArrayList<TreeNode>();
	    		for (TreeNode node : nodesOfThisLevel) {
	    			if (node.left != null) {
	    				nodesOfNextLevel.add(node.left);
	    			}
	    			if (node.right != null) {
	    				nodesOfNextLevel.add(node.right);
	    			}
	    		}
	    		if (nodesOfNextLevel.size() == 0) {
	    			break;
	    		} else {
	    			nodesOfThisLevel = nodesOfNextLevel;
	    		}
	    	}
	    	return nodesOfThisLevel.get(0).val;
	    }
	}

}
