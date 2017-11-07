package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P481 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.magicalString(6), equalTo(3));
	}
	
	class Solution {
	    public int magicalString(int n) {
	    	if (n == 0) {
	    		return 0;
	    	} else if (n <= 3) {
	        	return 1;
	        } else {
	        	int[] a = new int[n];
	        	// generate
	        	a[0] = 1;
	        	a[1] = a[2] = 2;
	        	int p = 2, e = 1, i = 3, c;
	        	while (i < n) {
	        		c = a[p];
	        		while (i < n && c-- > 0) {
	        			a[i++] = e;
	        		}
	        		if (i == n) {
	        			break;
	        		}
	        		e = e == 1 ? 2 : 1;
	        		++p;
	        	}
	        	// count 
	        	for (i = c = 0; i < n; ++i) {
	        		if (a[i] == 1) {
	        			++c;
	        		}
	        	}
	        	return c;
	        }
	    }
	}

}
