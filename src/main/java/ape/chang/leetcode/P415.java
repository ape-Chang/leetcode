package ape.chang.leetcode;

public class P415 {
	
	class Solution {
	    public String addStrings(String a, String b) {
	        int c = 0, n = Math.max(a.length(), b.length());
	        int[] p = cvt(a), q = cvt(b), s = new int[n];
	        for (int i = 0; i < n; ++i) {
	        	s[i] += c;
	        	if (i < p.length) {
	        		s[i] += p[i];
	        	}
	        	if (i < q.length) {
	        		s[i] += q[i];
	        	}
	        	if (s[i] >= 10) {
	        		s[i] -= 10;
	        		c = 1;
	        	} else {
	        		c = 0;
	        	}
	        }
	        StringBuilder sb = new StringBuilder();
	        if (c > 0) {
	        	sb.append(c);
	        }
	        while (n-- > 0) {
	        	sb.append(s[n]);
	        }
	        return sb.toString();
	    }
	    
	    int[] cvt(String s) {
	    	int n = s.length();
	    	int[] k = new int[n];
	    	for (int i = 0; i < n; ++i) {
	    		k[i] = s.charAt(n-1-i) - '0';
	    	}
	    	return k;
	    }
	}

}
