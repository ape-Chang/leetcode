package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P728 {
	
	Solution solution = new Solution();

	@Test
	public void test() {
		assertThat(solution.selfDividingNumbers(1, 22), equalTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)));
	}
	
	class Solution {
	    public List<Integer> selfDividingNumbers(int left, int right) {
	    	List<Integer> dividingNumbers = new ArrayList<Integer>();
	    	for (int i = left; i <= right; ++i) {
	    		if (isDividingNumber(i)) {
	    			dividingNumbers.add(i);
	    		}
	    	}
	    	return dividingNumbers;
	    }
	    
	    boolean isDividingNumber(int n) {
	    	int k = n, d;
	    	while (k > 0) {
	    		d = k % 10;
	    		if (d == 0 || n % d != 0) {
	    			return false;
	    		}
	    		k /= 10;
	    	}
	    	return true;
	    }
	}

}
