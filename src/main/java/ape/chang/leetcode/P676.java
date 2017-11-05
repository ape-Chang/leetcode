package ape.chang.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class P676 {
	
	@Test
	public void test() {
		MagicDictionary dictionary = new MagicDictionary();
		dictionary.buildDict(new String[] {"hello", "leetcode"});
		assertTrue(!dictionary.search("hello"));
		assertTrue(dictionary.search("hhllo"));
		assertTrue(!dictionary.search("hell"));
		assertTrue(!dictionary.search("leetcoded"));
	}
	
	class MagicDictionary {
		
		Trie prefix = new Trie();
		Trie suffix = new Trie();

	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	        
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for (String word : dict) {
	        	prefix.insert(word);
	        	suffix.insert(reverse(word));
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	    	int n = word.length();
	    	int p = prefix.lengthOfPrefix(word);
	    	int s = suffix.lengthOfPrefix(reverse(word));
	        return p+s == n-1;
	    }
	    
	    String reverse(String word) {
	    	char[] a = word.toCharArray();
	    	for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
	    		char c = a[i];
	    		a[i] = a[j];
	    		a[j] = c;
	    	}
	    	return new String(a);
	    }
	    
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
		    
		    int lengthOfPrefix(String word) {
		    	int k = 0;
		    	Node p = root;
		    	for (int i = 0; i < word.length() && p != null; ++i, ++k) {
		    		p = p.children[word.charAt(i) - 'a'];
		    	}
		    	return k-1;
		    }
		    
		    class Node {
		    	boolean eos; // end of sequence flag
		    	Node[] children = new Node[26];
		    }
		}
	}

}
