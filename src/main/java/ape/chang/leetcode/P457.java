package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P457 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.circularArrayLoop(new int[] {2, -1, 1, 2, 2}), equalTo(true));
		assertThat(solution.circularArrayLoop(new int[] {-1, 2}), equalTo(false));
//		assertThat(solution.circularArrayLoop(new int[] {-2, 1, -1, -2, -2}), equalTo(false));
	}
	
	class Solution {
	    public boolean circularArrayLoop(int[] a) {
	    	int n = a.length;
	        for (int i = 0; i < n; ++i) {
	        	a[i] += i;
	        	// normalize it
	        	while (a[i] < 0 || a[i] > n-1) {
	        		if (a[i] < 0) {
	        			a[i] += n;
	        		} else {
	        			a[i] -= n;
	        		}
	        	}
	        }
	        for (int i = 0; i < a.length; ++i) {
	        	if (a[i] >= 0) {
	        		int k = i, p = a[k];
	        		while (true) {
	        			if (p == k) {
	        				a[k] = -1;
	        				break;
	        			} else {
	        				if (p == -1) {
	        					return true;
	        				} else {
	        					a[k] = -1;
	        					k = p;
	        					p = a[k];
	        				}
	        			}
	        		}
	        	}
	        }
	        return false;
	    }
	}

}
