package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P386 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.lexicalOrder(13), equalTo(Arrays.asList(1,10,11,12,13,2,3,4,5,6,7,8,9)));
	}

	class Solution {
	    public List<Integer> lexicalOrder(int n) {
	        List<Integer> ret = new ArrayList<>();
	        for (int i = 1; i < 10; ++i) {	        	
	        	f(i, n, ret);
	        }
	        return ret;
	    }
	    
	    void f(int prefix, int limit, List<Integer> ret) {
	    	if (prefix <= limit) {
	    		ret.add(prefix);
	    		prefix *= 10;
	    		for (int i = 0; i < 10; ++i) {
	    			f(prefix + i, limit, ret);
	    		}
	    	}
	    }
	}
	
}
