package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class P677 {
	
	@Test
	public void test() {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		assertThat(ms.sum("ap"), equalTo(3));
		ms.insert("app", 2);
		assertTrue(ms.sum("ap") == 5);
	}
	
	class MapSum {
		
		Node root;


		class Node {
			int val;
			Node[] children = new Node[26];

			@Override
			public String toString() {
				return String.valueOf(val);
			}
		}
			
		
	    /** Initialize your data structure here. */
	    public MapSum() {
	    	root = new Node();
	    }
	    
	    void insert(String key, int val) {
	    	Node p = root;
	    	for (char c : key.toCharArray()) {
	    		int idx = c - 'a';
	    		if (p.children[idx] == null) {
	    			p.children[idx] = new Node();
	    		}
	    		p = p.children[idx];
	    	}
	    	
	    	p.val = val;
	    }

	    public int sum(String prefix) {
	    	Node p = root, q;
	    	for (char c : prefix.toCharArray()) {
	    		p = p.children[c-'a'];
	    		// wtf is this corner case?!!!!!!
	    		if (p == null) {
	    			return 0;
	    		}
	    	}
	    	
	    	if (p == null) {
    			return 0;
    		}
	    	
	    	Queue<Node> queue = new LinkedList<Node>();
	    	queue.add(p);
	    	
	    	int s = 0;
	    	while (!queue.isEmpty()) {
	    		int n = queue.size();
	    		while (n-- > 0) {
	    			q = queue.poll();
	    			for (Node child : q.children) {
	    				if (child != null) {
	    					queue.offer(child);
	    				}
	    			}
	    			
	    			s += q.val;
	    		}
	    	}
	    	return s;
	    }
	}

}
