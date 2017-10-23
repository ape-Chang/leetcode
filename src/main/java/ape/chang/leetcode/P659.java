package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class P659 {
	
	Solution solution = new Solution();
	
	@Parameter(0)
	public int[] nums;
	@Parameter(1)
	public boolean expected;
	
	@Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][] {
			{ new int[] {1,2,3,3,4,5}, true }, 
			{ new int[] {1,2,3,3,4,4,5,5}, true },
			{ new int[] {1,2,3,4,4,5}, false }
		});
	}
	
	@Test
	public void test() {
		assertThat(solution.isPossible(nums), equalTo(expected));
	}
	
	class Solution {
		
	    public boolean isPossible(int[] a) {
	    	int[] b = f(a);
	        return false;
	    }
	    
	    
	    public int[] f(int[] a) {
	    	int n = a.length, min = a[0], max = a[n-1];
	    	int[] b = new int[max-min+1];
	    	for (int i : a) {
	    		b[i-min]++;
	    	}
	    	return b;
	    }
	}

}
