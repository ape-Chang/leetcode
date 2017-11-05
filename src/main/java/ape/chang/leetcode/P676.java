package ape.chang.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		
		Map<Integer, Set<String>> bins = new HashMap<Integer, Set<String>>();

	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	        
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for (String word : dict) {
	        	int length = word.length();
	        	if (!bins.containsKey(length)) {
	        		bins.put(length, new HashSet<String>());
	        	}
	        	bins.get(length).add(word);
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	    	int length = word.length();
	    	if (bins.containsKey(length)) {
	    		Set<String> set = bins.get(length);
	    		for (String item : set) {
	    			int i = 0, j = length - 1;
	    			for (; i < length && word.charAt(i) == item.charAt(i); ++i)
	    				;
	    			for (; j >= 0     && word.charAt(j) == item.charAt(j); --j)
	    				;
	    			if (i == j) {
	    				return true;
	    			}
	    		}
	    		return false;
	    	} else {
	    		return false;
	    	}
	    }
	    
	}
}
