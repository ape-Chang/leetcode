package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class P406 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.reconstructQueue(new int[][] {
			{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
		}), equalTo(new int[][] {
			{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}
		}));
	}
	
	class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people, new Comparator<int[]>() {

				@Override
				public int compare(int[] lhs, int[] rhs) {
					return lhs[0] != rhs[0] ? lhs[0] - rhs[0] : lhs[1] - rhs[1];
				}
				
			});
	        
	        
	        for (int i = 0, n = people.length; i < n; ) {
	        	int c = 0;
	        	for (int j = 0; j < i; ++j) {
	        		if (people[j][0] >= people[i][0]) {
	        			++c;
	        		}
	        	}
	        	if (c == people[i][1]) {
	        		++i;
	        	} else {
	        		int[] t = people[i];
	        		int p = i, q = p;
	        		for (; c < t[1]; ++c, p = q) {
	        			for (++q; people[q][0] < t[0]; ++q) 
	        				;
	        			people[p] = people[q];
	        		}
	        		people[p] = t;
	        	}
	        }
	        return people;
	    }
	}

}
