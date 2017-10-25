package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P652 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findDuplicateSubtrees(Parsers.parseTree("(1, (2, (4, (), ()), ()), (3, (2, (4, (), ()), ()), (4, (), ())))")), 
				equalTo(asList(Parsers.parseTree("(4, (), ())"), Parsers.parseTree("(2, (4, (), ()), ())"))));
	}
	
	class Solution {
		
		Map<String, TreeNode> cache = new HashMap<String, TreeNode>();
		Set<String> duplicates = new LinkedHashSet<String>();
		
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    	cache.clear();
	    	duplicates.clear();
	    	serializeAndFindDuplicate(root);
	    	List<TreeNode> dups = new ArrayList<TreeNode>();
	    	for (String key : duplicates) {
	    		dups.add(cache.get(key));
	    	}
	        return dups;
	    }
	    
	    String serializeAndFindDuplicate(TreeNode root) {
	    	if (root == null) {
	    		return "()";
	    	}
	    	
	    	String serialize = String.format("(%d, %s, %s)", root.val, serializeAndFindDuplicate(root.left), serializeAndFindDuplicate(root.right));
	    	if (cache.containsKey(serialize)) {
	    		duplicates.add(serialize);
	    	} else {
	    		cache.put(serialize, root);
	    	}
	    	return serialize;
	    }
	    
	}

}
