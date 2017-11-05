package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P567 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.checkInclusion("ab", "eidbaooo"), equalTo(true));
		assertThat(solution.checkInclusion("ab", "eidboaoo"), equalTo(false));
		assertThat(solution.checkInclusion("adc", "dcda"), equalTo(true));
	}
	
	class Solution {
	    public boolean checkInclusion(String s1, String s2) {
	        if (s1.length() > s2.length()) {
	        	return false;
	        }
	        
	        int n = s1.length(), m = s2.length();

	        int[] p = count(s1);
	        int[] s = count(s2.substring(0, n));
	        if (eq(p, s)) {
	        	return true;
	        }
	        for(int i = 0; i < m-n; ++i) {
	        	s[s2.charAt(i) - 'a']--;
	        	s[s2.charAt(i+n) - 'a']++;
	        	if (eq(p, s)) {
	        		return true;
	        	}
	        }
	        return false;
	    }
	    
	    int[] count(String s) {
	    	int[] count = new int[26];
	    	for (char c : s.toCharArray()) {
	    		count[c - 'a']++;
	    	}
	    	return count;
	    }
	    
	    boolean eq(int[] a, int[] b) {
	    	for (int i = 0; i < 26; ++i) {
	    		if (a[i] != b[i]) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
	

}
