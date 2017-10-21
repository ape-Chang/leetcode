package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P658 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findClosestElements(new int[] {1,2,3,4,5}, 4, 3), equalTo(asList(1, 2, 3, 4)));
		assertThat(solution.findClosestElements(new int[] {1,2,3,4,5}, 4, -1), equalTo(asList(1, 2, 3, 4)));
	}
	
	class Solution {
		
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	    	List<Integer> closest = new ArrayList<Integer>();
	    	int idx = indexOfInsertionPosition(arr, x), n = arr.length;
	    	if (idx == 0) {
	    		for (int i = 0; i < k; ++i) {
	    			closest.add(arr[i]);
	    		}
	    		return closest;
	    	}
	    	
	    	if (idx == n) {
	    		for (int i = k; i > 0; --k) {
	    			closest.add(arr[n-i]);
	    		}
	    		return closest;
	    	}
	    	
	    	int q = idx, p = idx-1;
	    	while (q - p <= k) {
	    		if (p < 0) {
	    			++q;
	    		} else if (q >= n) {
	    			--p;
	    		} else {	    			
	    			if (x - arr[p] <= arr[q] - x) {
	    				--p;
	    			} else {
	    				++q;
	    			}
	    		}
	    	}
	    	
	    	for (++p; p < q; ++p) {
	    		closest.add(arr[p]);
	    	}
	    	
	        return closest;
	    }
	    
	    int indexOfInsertionPosition(int[] a, int x) {
	    	int n = a.length;
	    	if (x <= a[0]) {
	    		return 0;
	    	}
	    	
	    	if (x > a[n-1]) {
	    		return n;
	    	}
	    	
	    	int l = 0, h = n-1, m;
	    	while (l < h) {
	    		m = (l + h) / 2;
	    		if (a[m] == x) {
	    			return m;
	    		}
	    		
	    		if (a[m] < x) {
	    			l = m+1;
	    		} else {
	    			h = m;
	    		}
	    	}
	    	
	    	return l;
	    }
	    
	    
	}

}
