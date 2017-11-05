package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P515 {
	
	class Solution {
	    public List<Integer> largestValues(TreeNode root) {
	    	if (root == null) {
	    		return Collections.emptyList();
	    	}

	    	List<Integer> largest = new ArrayList<Integer>();
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	        	int n = queue.size();
	        	int m = Integer.MIN_VALUE;
	        	while (n-- > 0) {
	        		TreeNode q = queue.poll();
	        		m = Math.max(m, q.val);
	        		if (q.left != null) {
	        			queue.offer(q.left);
	        		}
	        		if (q.right != null) {
	        			queue.offer(q.right);
	        		}
	        	}
	        	largest.add(m);
	        }
	        return largest;
	    }
	}

}
