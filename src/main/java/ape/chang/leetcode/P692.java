package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test; 

public class P692 {
	
	@Test
	public void test() {
		Solution solution;
		solution = new Solution();
		assertThat(Arrays.asList("i", "love"), equalTo(solution.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2)));
		solution = new Solution();
		assertThat(Arrays.asList("the", "is", "sunny", "day"), equalTo(solution.topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)));
	}
	
	// sounds like lfu
	class Solution {
		
		class Node implements Comparable<Node> {
			// -----------------
			Node prev;
			Node next;
			// -----------------
			int freq;
			String key;
			
			public int compareTo(Node o) {
				return (this.freq == o.freq) ? this.key.compareTo(o.key) : this.freq - o.freq;
			}
			
			@Override
			public String toString() {
				if (next == null) {
					return String.format("[%s: %d]", key, freq);
				} else {
					return String.format("[%s: %d] -> %s", key, freq, next);
				}
			}
		}
		
		Map<String, Node> map = new HashMap<String, Node>();
		Node head, tail;
		
		public Solution() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}
		
	    public List<String> topKFrequent(String[] words, int k) {
	    	for (String word : words) {
	    		Node p, q;
	    		if (map.containsKey(word)) {
	    			p = map.get(word);
	    			p.freq++;
	    			
	    			q = p.prev;
	    			
	    			// remove p from the list
	    			p.prev.next = p.next;
	    			p.next.prev = p.prev;
	    			p.next = p.prev = null;
	    		} else {
	    			p = new Node();
	    			p.freq = 1;
	    			p.key = word;
	    			map.put(word, p);
	    			
	    			q = tail.prev;
	    		}
	    		
	    		while (q != head && p.freq > q.freq) {
	    			q = q.prev;
	    		}
	    		
	    		while (q != head && p.freq == q.freq && q.key.compareTo(p.key) > 0) {
	    			q = q.prev;
	    		}
	    		
	    		q.next.prev = p;
	    		p.next = q.next;
	    		p.prev = q;
	    		q.next = p;
	    	}
	    	
	    	List<String> topK = new ArrayList<String>(k);
	    	Node p = head.next;
	    	while (k-- > 0) {
	    		topK.add(p.key);
	    		p = p.next;
	    	}
	        return topK;
	    }
	}

}
