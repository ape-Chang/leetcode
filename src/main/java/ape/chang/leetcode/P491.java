package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ape.chang.primitives.IntList;

public class P491 {
	
	Solution solution = new Solution();
	
	@SuppressWarnings("unchecked")
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
		// 
		assertThat(solution.findSubsequences(new int[] {-1, 0, 0, 0}), equalTo(asList(
				asList(-1, 0),
				asList(0, 0),
				asList(0, 0, 0),
				asList(-1, 0, 0),
				asList(-1, 0, 0, 0))));
	}
	
	class Solution {
	    public List<List<Integer>> findSubsequences(int[] nums) {
	    	int n = nums.length;
	    	List<List<IntList>> listOfSequences =new ArrayList<List<IntList>>(n);
	    	for (int i = 0; i < n; ++i) {
	    		List<IntList> sequences = new ArrayList<IntList>();
	    		IntList sequence = new IntList();
	    		sequence.add(nums[i]);
	    		sequences.add(sequence);
	    		listOfSequences.add(sequences);
	    	}
	    	
	    	for (int i = 0; i < n; ++i) {
	    		for (int j = i+1; j < n; ++j) {
	    			if (nums[j] >= nums[i]) {
	    				for (IntList sequence : listOfSequences.get(i)) {
	    					IntList clone = sequence.clone();
	    					clone.add(nums[j]);
	    					listOfSequences.get(j).add(clone);
	    				}
	    			}
	    		}
	    	}
	    	
	    	Set<IntList> result = new HashSet<IntList>();
	    	for (int i = 0; i < n; ++i) {
	    		for (IntList sequence : listOfSequences.get(i)) {
	    			if (sequence.size() > 1) {
	    				result.add(sequence);
	    			}
	    		}
	    	}
	    	
	    	List<List<Integer>> copy = new ArrayList<List<Integer>>();
	    	for (IntList list : result) {
	    		copy.add(list.asList());
	    	}
	        return copy;
	    }
	}

}
