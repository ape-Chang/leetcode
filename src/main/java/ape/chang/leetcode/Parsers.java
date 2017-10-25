package ape.chang.leetcode;

public class Parsers {
	
	public static ListNode parseLinkList(String expr) {
		expr = expr.trim();
		ListNode p = new ListNode(0), q = p;
		for (int i = 0, j = 0, v = 0; j < expr.length(); i = j+2, q = q.next) {
			j = expr.indexOf("->", i);
			if (j == -1) {
				j = expr.length();
			}
			v = Integer.parseInt(expr.substring(i, j).trim());
			q.next = new ListNode(v);
		}
		return p.next;
	}

}
