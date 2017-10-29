package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P290 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.wordPattern("abba", "dog cat cat dog"), equalTo(true));
		assertThat(solution.wordPattern("abba", "dog cat cat fish"), equalTo(false));
		assertThat(solution.wordPattern("aaaa", "dog cat cat dog"), equalTo(false));
		assertThat(solution.wordPattern("abba", "dog dog dog dog"), equalTo(false));
	}
	
	class Solution {
	    public boolean wordPattern(String pattern, String str) {
	    	String[] words = str.split("\\s+");
	    	if (pattern.length() != words.length) {
	    		return false;
	    	}
	    	Map<Character, Integer> map = new HashMap<Character, Integer>();
	    	Map<String, Integer> rmap = new HashMap<String, Integer>();
	    	for (int i = 0, n = words.length, idx = 0; i < n; ++i) {
	    		char c = pattern.charAt(i);
	    		String word = words[i];
	    		if (!map.containsKey(c) && !rmap.containsKey(word)) {
	    			map.put(c, idx);
	    			rmap.put(word, idx);
	    			++idx;
	    		} else if (map.containsKey(c) && rmap.containsKey(word) && map.get(c).equals(rmap.get(word))) {
	    			
	    		} else {
	    			return false;
	    		}
	    	}
	    	return true;
	        
	    }
	}

}
