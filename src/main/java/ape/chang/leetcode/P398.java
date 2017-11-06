package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P398 {

	class Solution {
		
		Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();
		Random random = new Random(System.currentTimeMillis());

	    public Solution(int[] a) {
	        for (int i = 0; i < a.length; ++i) {
	        	int k  = a[i];
	        	List<Integer> index = indexMap.get(k);
	        	if (index == null) {
	        		indexMap.put(k, index = new ArrayList<Integer>());
	        	}
	        	index.add(i);
	        }
	    }
	    
	    public int pick(int t) {
	    	List<Integer> index = indexMap.get(t);
	    	int n = index.size();
	        return index.get(random.nextInt(n));
	    }
	    
	}
	
}
