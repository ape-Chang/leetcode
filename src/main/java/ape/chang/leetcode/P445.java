package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P445 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.addTwoNumbers(Parsers.parseLinkList("7 -> 2 -> 4 -> 3"), Parsers.parseLinkList("5 -> 6 -> 4")), equalTo(Parsers.parseLinkList("7 -> 8 -> 0 -> 7")));
	}

	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	if (l1 == null) {
	    		return l2;
	    	}
	    	if (l2 == null) {
	    		return l1;
	    	}
	    	// l1 != null && l2 != null
	    	ListNode t1 = reverse(l1), t2 = reverse(l2);
	    	int s = 0, c = 0;
	    	ListNode p = null, q = null;
	    	for (;t1 != null && t2 != null; t1 = t1.next, t2 = t2.next, p = q) {
	    		s = t1.val + t2.val + c;
	    		if (s > 9) {
	    			s -= 10;
	    			c =  1;
	    		} else {
	    			c = 0;
	    		}
	    		q = new ListNode(s);
	    		q.next = p;
	    	}
	    	
	    	for (; t1 != null; t1 = t1.next, p = q) {
	    		s = t1.val + c;
	    		if (s > 9) {
	    			s -= 10;
	    			c  = 1;
	    		} else {
	    			c = 0;
	    		}
	    		q = new ListNode(s);
	    		q.next = p;
	    		p = q;
	    	}
	    	
	    	for (; t2 != null; t2 = t2.next, p = q) {
	    		s = t2.val + c;
	    		if (s > 9) {
	    			s -= 10;
	    			c  = 1;
	    		} else {
	    			c = 0;
	    		}
	    		q = new ListNode(s);
	    		q.next = p;
	    		p = q;
	    	}
	    	
	    	if (c > 0) {
	    		q = new ListNode(c);
	    		q.next = p;
	    		p = q;
	    	}
	    	
	        return p;
	    }
	    
	    ListNode reverse(ListNode head) {
	    	return doReverse(null, head);
	    }
	    
	    ListNode doReverse(ListNode reversed, ListNode remaining) {
	    	if (remaining == null) {
	    		return reversed;
	    	}
	    	
	    	ListNode head = new ListNode(remaining.val);
	    	head.next = reversed;
	    	return doReverse(head, remaining.next);
	    }
	}

}
