package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P393 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.validUtf8(new int[] {197, 130, 1}), equalTo(true));
		assertThat(solution.validUtf8(new int[] {235, 140, 4}), equalTo(false));
	}
	
	class Solution {
	    public boolean validUtf8(int[] data) {
	        int n = data.length, p = 0;
	        while (p < n) {
	        	if ((data[p] & 0x80) == 0) {
	        		++p;
	        	} else if (p+1 < n && (data[p] & 0xE0) == 0xC0 && (data[p+1] & 0xC0) == 0x80) {
	        		p += 2;
	        	} else if (p+2 < n && (data[p] & 0xF0) == 0xE0 && (data[p+1] & 0xC0) == 0x80 && (data[p+2] & 0xC0) == 0x80) {
	        		p += 3;
	        	} else if (p+3 < n && (data[p] & 0xF8) == 0xF0 && (data[p+1] & 0xC0) == 0x80 && (data[p+2] & 0xC0) == 0x80 && (data[p+3] & 0xC0) == 0x80) {
	        		p += 4;
	        	} else {
	        		return false;
	        	}
	        }
	        return true;
	    }
	}

}
