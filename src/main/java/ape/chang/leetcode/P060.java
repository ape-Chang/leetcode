package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P060 {
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertThat(solution.getPermutation(3,  3), equalTo("213"));
	}
	
	class Solution {
	    public String getPermutation(int n, int k) {
	    	if (n == 1) {
	    		return "1";
	    	}
	    	if (n == 2) {
	    		return k == 1 ? "12" : "21";
	    	}
	    	
	    	// n >= 3
	    	int[] r = repr(--k, base(n));
	    	int[] a = seq(n);
	    	for (int i = 0; i < n; ++i) {
	    		if (r[i] != 0) {
	    			int t = i + r[i], p = a[t];
	    			for (int j = t; j > i; j --) {
	    				a[j] = a[j-1];
	    			}
	    			a[i] = p;
	    		}
	    	}
	    	return as(a);
	    }
	    
	    String as(int[] a) {
	    	StringBuilder sb = new StringBuilder();
	    	for (int i : a) sb.append(i);
	    	return sb.toString();
	    }
	    
	    int[] seq(int n) {
	    	int[] s = new int[n];
	    	for (int i = 0; i < n; ++i) {
	    		s[i] = i+1;
	    	}
	    	return s;
	    }
	    
	    int[] repr(int k, int[] b) {
	    	int n = b.length;
	    	int[] r = new int[n];
	    	for (int i = 0; i < n; ++i) {
	    		if (k == 0) {
	    			r[i] = 0;
	    		} else {
	    			r[i] = k / b[i];
	    			k = k % b[i];
	    		}
	    	}
	    	return r;
	    }
	    
	    int[] base(int n) {
	    	int[] b = new int[n];
	    	b[0] = 0;
	    	b[1] = 1;
	    	for (int i = 2; i < n; ++i) {
	    		b[i] = i * b[i-1];
	    	}
	    	return reverse(b);
	    }
	    
	    int[] reverse(int[] a) {
	    	int n = a.length;
	    	int[] b = new int[n];
	    	for (int i = 1; i <= n; ++i) {
	    		b[i-1] = a[n-i];
	    	}
	    	return b;
	    }
	    
	}

}
