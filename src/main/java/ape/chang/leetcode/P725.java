package ape.chang.leetcode;

public class P725 {
	
	class Solution {
	    public ListNode[] splitListToParts(ListNode root, int k) {
	        int n = length(root);
	        int d = n / k;
	        int r = n % k;
	        ListNode[] heads = new ListNode[k];
	        for (int i = 0; i < k; ++i) {
	        	if (d == 0 && r == 0) {
	        		heads[i] = null;
	        	} else {
	        		ListNode h = new ListNode(0), p = h;
	        		for (int j = 0; j < d; ++j) {
	        			p.next = root;
	        			root = root.next;
	        			p = p.next;
	        		}
	        		if (r-- > 0) {
	        			p.next = root;
	        			root = root.next;
	        			p = p.next;
	        		}
	        		p.next = null;
	        		heads[i] = h.next;
	        	}
	        }
	        return heads;
	    }
	    
	    int length(ListNode head) {
	    	int n = 0;
	    	for (; head != null; ++n, head = head.next) 
	    		;
	    	return n;
	    }
	}

}
