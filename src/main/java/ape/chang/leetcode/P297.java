package ape.chang.leetcode;

public class P297 {
	
	public class Codec {

	    public String serialize(TreeNode root) {
	    	if (root == null) {
	    		return "()";
	    	}
	        return String.format("(%d, %s, %s)", root.val, serialize(root.left), serialize(root.right));
	    }

	    public TreeNode deserialize(String data) {
	    	int p, k, q, n; 
	    	p = data.indexOf('(');
	    	k = data.indexOf(',', p);
	    	if (k == -1) {
	    		return null;
	    	} else {
	    		int val = Integer.parseInt(data.substring(p+1, k));
	    		TreeNode root = new TreeNode(val);
	    		p = data.indexOf('(', k);
	    		q = p+1;
	    		n = 1;
	    		for (; n != 0; ++q) {
	    			char c = data.charAt(q);
	    			if (c == '(') {
	    				++n;
	    			} else if (c == ')') {
	    				--n;
	    			}
	    		}
	    		root.left = deserialize(data.substring(p, q));
	    		
	    		k = data.indexOf(',', q);
	    		p = data.indexOf('(', k);
	    		q = p+1;
	    		n = 1;
	    		for (; n != 0; ++q) {
	    			char c = data.charAt(q);
	    			if (c == '(') {
	    				++n;
	    			} else if (c == ')') {
	    				--n;
	    			}
	    		}
	    		root.right = deserialize(data.substring(p, q));
	    		return root;
	    	}
	    }
	}

}
