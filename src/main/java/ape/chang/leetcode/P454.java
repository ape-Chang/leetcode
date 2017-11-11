package ape.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P454 {
	
	class Solution {
	    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	    	Map<Integer, Integer> map = new HashMap<>();
	        for (int c : C) {
	        	for (int d : D) {
	        		int sum = c + d;
	        		int count = map.getOrDefault(sum, 0);
	        		map.put(sum, count+1);
	        	}
	        }
	        
	        int count = 0;
	        for (int a : A) {
	        	for (int b : B) {
	        		count += map.getOrDefault(-(a + b), 0);
	        	}
	        }
	        
	        return count;
	    }
	}

}
