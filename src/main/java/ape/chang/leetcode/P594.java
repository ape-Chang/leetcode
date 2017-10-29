package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P594 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findLHS(new int[] {1,3,2,2,5,2,3,7}), equalTo(5));
	}
	
	class Solution {
	    public int findLHS(int[] a) {
	    	int n = a.length;
	    	if (n == 0) {
	    		return 0;
	    	}
	    	
	        Arrays.sort(a);
	        Link head = new Link(0, 0), p = head, q = null;
	        for (int i = 0; i < n;) {
	        	int val = a[i];
	        	int count = 1;
	        	for (++i; i < n && a[i] == val; ++i, ++count)
	        		;
	        	p.next = new Link(val, count);
	        	p = p.next;
	        }
	        
	        int m = 0;
	        for (p = head.next, q = p.next; q != null; p = q, q = q.next) {
	        	if (q.val == p.val + 1) {
	        		m = Math.max(m, p.count + q.count);
	        	}
	        }
	        return m;
	    }
	    
	    class Link {
	    	int val;
	    	int count;
	    	Link next;
	    	public Link(int val, int count) {
	    		this.val = val;
	    		this.count = count;
			}
	    }
	}

}
