package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P482 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.licenseKeyFormatting("2-4A0r7-4k", 4), equalTo("24A0-R74K"));
		assertThat(solution.licenseKeyFormatting("2-4A0r7-4k", 3), equalTo("24-A0R-74K"));
	}
	
	class Solution {
	    public String licenseKeyFormatting(String s, int k) {
	    	String t = deDashAndUppercase(s);
	    	if (t.length() == 0) {
	    		return "";
	    	}
	    	
	    	int n = t.length(), r = n % k, p = 0;
	    	StringBuilder sb = new StringBuilder();
	    	if (r == 0) {
	    		sb.append(t.substring(0, k));
	    		p = k;
	    	} else {
	    		sb.append(t.substring(0, r));
	    		p = r;
	    	}
	    	for (; p < n; p += k) {
	    		sb.append('-');
	    		sb.append(t.substring(p, p+k));
	    	}
	    	return sb.toString();
	    }
	    
	    String deDashAndUppercase(String s) {
	    	char[] a = s.toCharArray();
	    	int k = 0;
	    	for (int i = 0; i < a.length; ++i) {
	    		if (a[i] == '-') {
	    			
	    		} else {
	    			a[k++] = Character.toUpperCase(a[i]);
	    		}
	    	}
	    	return new String(a, 0, k);
	    }
	}

}
