package ape.chang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P347 {
	
	class Solution {
	    public List<Integer> topKFrequent(int[] a, int k) {
	    	Map<Integer, Entry> itemFreq = new HashMap<>();
	    	for (int i : a) {
	    		Entry entry = itemFreq.get(i);
	    		if (entry == null) {
	    			entry = new Entry(i);
	    			itemFreq.put(i, entry);
	    		}
	    		entry.freq++;
	    	}
	    	List<Entry> freqs = new ArrayList<>(itemFreq.values());
	    	Collections.sort(freqs); // or use bucket sort
	    	List<Integer> topk = new ArrayList<>(k);
	    	for (int i = 0; i < k; ++i) {
	    		topk.add(freqs.get(i).val);
	    	}
	    	return topk;
	    }
	    
	    class Entry implements Comparable<Entry> {
	    	int val;
	    	int freq;
	    	public Entry(int val) {
	    		this.val = val;
			}
			@Override
			public int compareTo(Entry o) {
				return this.freq == o.freq ? o.val - this.val : o.freq - this.freq;
			}
	    	
	    	
	    }
	}

}
