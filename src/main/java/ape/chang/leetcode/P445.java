package ape.chang.leetcode;

public class P445 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode t1 = l1, t2 = l2;
	    	while (t1.next != null) {
	    		t1 = t1.next;
	    	}
	    	while (t2.next != null) {
	    		t2 = t2.next;
	    	}
	    	
	    	int s = 0, c = 0;
	        return null;
	    }
	}

}
