package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P394 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.decodeString("3[a]2[bc]"), equalTo("aaabcbc"));
		assertThat(solution.decodeString("3[a2[c]]"), equalTo("accaccacc"));
		assertThat(solution.decodeString("2[abc]3[cd]ef"), equalTo("abcabccdcdcdef"));
	}
	
	class Solution {
	    public String decodeString(String s) {
	    	StringBuilder sb = new StringBuilder();
	        char[] a = s.toCharArray();
	        int p = 0, q, n = a.length;
	        for (; p < n && Character.isAlphabetic(a[p]); p++) {
	        	sb.append(a[p]);
	        }
	        while (p < n) {
	        	for (q = p+1; q < n && a[q] != '['; ++q)
	        		;
	        	int t = Integer.parseInt(s.substring(p, q));
	        	
	        	int k = 1;
	        	for (p = q+1, q = p+1; ; ++q) {
	        		if (a[q] == '[')
	        			++k;
	        		if (a[q] == ']')
	        			--k;
	        		if (k == 0) {
	        			break;
	        		}
	        	}
	        	String r = decodeString(s.substring(p, q));
	        	while (t-- > 0) {
	        		sb.append(r);
	        	}
	        	for (p = q+1; p < n && Character.isAlphabetic(a[p]); ++p)
	        		sb.append(a[p]);
	        }
	        return sb.toString();
	    }
	}

}
