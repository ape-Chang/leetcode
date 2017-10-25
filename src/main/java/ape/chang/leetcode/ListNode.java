package ape.chang.leetcode;

public class ListNode {
	
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return (next == null) ? String.valueOf(val) : String.format("%d -> %s", val, next);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (o instanceof ListNode) {
			ListNode p = (ListNode) o;
			return val == p.val && ((next == null) ? p.next == null : next.equals(p.next)); 
		}
		return false;
	}

}
