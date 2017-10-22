package ape.chang.leetcode;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class P648 {
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.replaceWords(asList("cat", "bat", "rat"), "the cattle was rattled by the battery"), equalTo("the cat was rat by the bat"));
		assertThat(solution.replaceWords(asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"), equalTo("a a a a a a a a bbb baba a"));
	}
	
	class Solution {
		
	    public String replaceWords(List<String> dict, String sentence) {
	    	Trie trie = new Trie();
	    	for (String word : dict) {
	    		trie.insert(word);
	    	}
	    	String[] words = sentence.split("\\s+");
	    	for (int i = 0, n = words.length; i < n; ++i) {
	    		words[i] = trie.prefixOf(words[i]);
	    	}
	        return join(words);
	    }
	    
	    String join(String[] words) {
	    	StringBuilder sb = new StringBuilder(words[0]);
	    	for (int i = 1, n = words.length; i < n; ++i) {
	    		sb.append(" ").append(words[i]);
	    	}
	    	return sb.toString();
	    }
	    
	    class Trie {
	    	Node root = new Node();
	    	
	    	class Node {
	    		boolean isLeaf = false;
	    		String value;
	    		Node[] children = new Node[26];
	    		
	    		Node getChildAt(int idx) {
	    			return children[idx];
	    		}
	    		
	    		void setChildAt(int idx, Node child) {
	    			children[idx] = child;
	    		}
	    	}
	    	
	    	public void insert(String s) {
	    		Node p = root, q = p;
	    		for (int i = 0, n = s.length(), k = 0; i < n; ++i, p = q) {
	    			k = s.charAt(i) - 'a';
	    			q = p.getChildAt(k);
	    			if (q == null) {
	    				q = new Node();
	    				p.setChildAt(k, q);
	    			}
	    		}
	    		q.isLeaf = true;
	    		q.value = s;
	    	}
	    	
	    	public String prefixOf(String s) {
	    		Node p = root, q = p;
	    		for (int i = 0, n = s.length(), k = 0; i < n; ++i, p = q) {
	    			k = s.charAt(i) - 'a';
	    			q = p.getChildAt(k);
	    			if (q == null) {
	    				return s;
	    			}
	    			if (q.isLeaf) {
	    				return q.value;
	    			}
	    		}
	    		return s;
	    	}
	    	
	    }
	    
	}
	

}
