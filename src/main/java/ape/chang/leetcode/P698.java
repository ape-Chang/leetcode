package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P698 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
//		assertThat(solution.canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4), equalTo(true));
//		assertThat(solution.canPartitionKSubsets(new int[] {2,2,2,2,3,4,5}, 4), equalTo(false));
//		assertThat(solution.canPartitionKSubsets(new int[] {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5), equalTo(true));
		assertThat(solution.canPartitionKSubsets(new int[] {730,580,401,659,5524,405,1601,3,383,4391,4485,1024,1175,1100,2299,3908}, 4), equalTo(true));
	}
	
	class Solution {
	    public boolean canPartitionKSubsets(int[] a, int k) {
	    	Arrays.sort(a);
	    	
	    	int s = 0, n = a.length;
	    	for (int i = 0; i < n; ++i) {
	    		s += a[i];
	    	}
	    	
	    	if (s % k != 0) {
	    		return false;
	    	}
	    	
	    	int[] b = new int[k];
	    	Arrays.fill(b, s/k);
	    	
	    	for (int i = a.length-1; i >= 0; --i, Arrays.sort(b)) {
	    		int j;
	    		for (j = 0; j < k; ++j) {
	    			if (b[j] == a[i]) {
	    				break;
	    			}
	    		}
	    		if (j != k) {
	    			b[j] -= a[i];
	    			continue;
	    		} else {
	    			for (j = k-1; j >= 0; --j) {
	    				if (b[j] > a[i]) {
	    					break;
	    				}
	    			}
	    			if (j < 0) {
	    				return false;
	    			} else {
	    				b[j] -= a[i];
	    			}
	    		}
	    		
	    	}
	        return true;
	    }
	}
}
