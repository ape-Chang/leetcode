package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P442 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findDuplicates(new int[] {4,3,2,7,8,2,3,1}), equalTo(Arrays.asList(2,3)));
	}
	
	class Solution {
	    public List<Integer> findDuplicates(int[] a) {
	        List<Integer> duplicates = new ArrayList<>();
	        int n = a.length;
	        int p = 0;
	        while (true) {
	        	for (; p < n && (a[p] == p+1 || a[p] == 0); ++p)
	        		;
	        	
	        	if (p == n) {
	        		break;
	        	}
	        	
	        	// got one 
	        	while (true) {
	        		// swap a[p] and p
	        		int t = a[p]-1;
	        		a[p]  = a[t];
	        		a[t]  = t+1;
	        		
	        		if (a[p] == 0 || a[p] == p+1) {
	        			break;
	        		}
	        		if (a[p] == a[t]) {
	        			duplicates.add(a[p]);
	        			a[p] = 0;
	        			break;
	        		}
	        	}
	        }
	        return duplicates;
	    }
	}

}
