package ape.chang.leetcode;

public class P208 {
	
	class Trie {
		
		Node root = new Node();

	    /** Initialize your data structure here. */
	    public Trie() {
	        
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	Node p = root;
	        for (char c : word.toCharArray()) {
	        	int k = c - 'a';
	        	if (p.children[k] == null) {
	        		p = p.children[k] = new Node();
	        	} else {
	        		p = p.children[k];
	        	}
	        }
	        p.eos = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        Node p = root;
	        for (int i = 0; i < word.length() && p != null; ++i) {
	        	p = p.children[word.charAt(i) - 'a'];
	        }
	        return p != null && p.eos;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	Node p = root;
	        for (int i = 0; i < prefix.length() && p != null; ++i) {
	        	p = p.children[prefix.charAt(i) - 'a'];
	        }
	        return p != null;
	    }
	    
	    class Node {
	    	boolean eos; // end of sequence flag
	    	Node[] children = new Node[26];
	    }
	}

}
