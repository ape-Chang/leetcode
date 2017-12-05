package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class P508 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.findFrequentTreeSum(Parsers.parseTree("(5, (2, (), ()), (-3, (), ()))")), equalTo(new int[] {2, -3, 4}));
	}
	
	class Solution {
	    public int[] findFrequentTreeSum(TreeNode root) {
	    	if (root == null) {
	    		return new int[0];
	    	}
	    	
	    	TreeMap<Integer, List<Integer>> freqSums = countFreq(collect(wrap(root)));
	    	Map.Entry<Integer, List<Integer>> maxEntry = freqSums.lastEntry();
	    	List<Integer> value = maxEntry.getValue();
	    	int[] sums = new int[value.size()];
	    	for (int i = 0; i < value.size(); ++i) {
	    		sums[i] = value.get(i);
	    	}
	    	return sums;
	    }
	    
	    TreeMap<Integer, List<Integer>> countFreq(Map<Integer, Integer> sumFreq) {
	    	TreeMap<Integer, List<Integer>> freqSums = new TreeMap<>();
	    	for (Map.Entry<Integer, Integer> entry : sumFreq.entrySet()) {
	    		Integer sum = entry.getKey();
	    		Integer freq = entry.getValue();
	    		List<Integer> sums = freqSums.get(freq);
	    		if (sums == null) {
	    			sums = new ArrayList<>();
	    			freqSums.put(freq, sums);
	    		}
	    		sums.add(sum);
	    	}
	    	return freqSums;
	    }
	    
	    Map<Integer, Integer> collect(Wrapper root) {
	    	Map<Integer, Integer> sumFreq = new HashMap<>();
	    	visit(root, sumFreq);
	    	return sumFreq;
	    }
	    
	    void visit(Wrapper root, Map<Integer, Integer> sumFreq) {
	    	if (root.left != null && root.right != null) {	    		
	    		visit(root.left, sumFreq);
	    		visit(root.right, sumFreq);
	    		Integer freq = sumFreq.getOrDefault(root.sum, 0);
	    		sumFreq.put(root.sum, freq+1);
	    	}
	    }
	    
	    Wrapper wrap(TreeNode root) {
	    	return new Wrapper(root);
	    }
	    
	    class Wrapper {
	    	
	    	public Wrapper(TreeNode node) {
	    		if (node != null) {
	    			left = new Wrapper(node.left); 
	    			right = new Wrapper(node.right);
	    			sum = left.sum + right.sum + node.val;
	    		}
			}
	    	
	    	Wrapper left;
	    	Wrapper right;

			int sum;
	    }
	}

}
