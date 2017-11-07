package ape.chang.leetcode;

import java.util.Random;

public class P382 {
	
	// Reservoir Sampling
	
	class Solution {
		
		ListNode head;
		Random random = new Random(System.currentTimeMillis());

	    /** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	    public Solution(ListNode head) {
	        this.head = head;
	    }
	    
	    /** Returns a random node's value. */
	    public int getRandom() {
	        int k = 1;
	        ListNode p = null, q = head;
	        for (; q != null; q = q.next, ++k) {
	        	if (random.nextInt(k) == 0) {
	        		p = q;
	        	}
	        }
	        return p.val;
	    }
	}


}
