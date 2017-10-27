package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class P491 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findSubsequences(new int[] {4, 6, 7, 7}), equalTo(asList(
				asList(4, 6),
				asList(4, 7),
				asList(4, 6, 7),
				asList(4, 6, 7, 7),
				asList(6, 7),
				asList(6, 7, 7),
				asList(7,7),
				asList(4,7,7))));
	}
	
	class Solution {
	    public List<List<Integer>> findSubsequences(int[] nums) {
	        return null;
	    }
	}

}
