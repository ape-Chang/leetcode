package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class P486 {
	
	@Parameter(0)
	public int[] nums;
	@Parameter(1)
	public boolean expected;
	
	@Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][] {
			{new int[] {1, 5, 2}, false},
			{new int[] {1, 5, 233, 7}, true},
		});
	}
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertTrue(solution.PredictTheWinner(nums) == expected);
	}
	
	class Solution {
	    public boolean PredictTheWinner(int[] nums) {
	    	return false;
	    }
	}

}
