package ape.chang.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class P388 {
	
	/*
	 * Broken case
	 */
	
	Solution solution = new Solution();
	
	@Test
	public void test() {
		assertThat(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"), equalTo(32));
		assertThat(solution.lengthLongestPath("dir\n        file.txt"), equalTo(16));
		assertThat(solution.lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt"), equalTo(10));
	}
	
	class Solution {
	    public int lengthLongestPath(String input) {
	    	Node prev = new Node(0), curr;
	    	int longest = 0;
	    	// 
	    	String[] lines = input.split("\n");
	    	for (String line : lines) {
	    		int type = line.indexOf('.') == -1 ? 0 : 1;
	    		curr = new Node(type);
	    		if (curr.isFile()) {
	    			// determine parent first, then leading tabs
	    			curr.leadingTabs = countLeadingTabs(line);
	    			curr.parent = prev;
	    			while ( curr.leadingTabs <= curr.parent.leadingTabs) {
	    				curr.parent = curr.parent.parent;
	    			}
	    			curr.leadingTabs = curr.parent.leadingTabs + 1;
	    			// wtf: filename can contain whitespace?!!!!
	    			curr.content = chopNLeadingTabs(line, curr.leadingTabs);
	    			curr.length = curr.content.length() + 1 + curr.parent.length;
	    			// 
	    			longest = Math.max(longest, curr.length);
	    		} else {
	    			// determine leading tabs first, then parent
	    			curr.leadingTabs = countLeadingTabs(line);
	    			curr.parent = prev;
	    			while ( curr.leadingTabs <= curr.parent.leadingTabs) {
	    				curr.parent = curr.parent.parent;
	    			}
	    			// dirname can contain whitespace????
	    			curr.content = chopNLeadingTabs(line, curr.leadingTabs);
	    			curr.length = curr.content.length() + 1 + curr.parent.length;
	    		}
	    		prev = curr;
	    	}
	    	return longest;
	    }
	    
	    int countLeadingTabs(String s) {
	    	int k = 0, p = 0;
	    	while (true) {
	    		if (s.charAt(p) == '\t') {
	    			++k;
	    			++p;
	    			continue;
	    		}
	    		if (s.charAt(p) == ' ' && s.charAt(p+1) == ' ' &&
	    				s.charAt(p+2) == ' ' && s.charAt(p+3) == ' ') {
	    			++k;
	    			p += 4;
	    			continue;
	    		}
	    		return k;
	    	}
	    }
	    
	    String chopNLeadingTabs(String s, int n) {
	    	int p = 0;
	    	while (n-- > 0) {
	    		// a tab
	    		if (s.charAt(p) == '\t') {
	    			++p;
	    			continue;
	    		}
	    		// four space
	    		if (s.charAt(p) == ' ' && s.charAt(p+1) == ' ' &&
	    				s.charAt(p+2) == ' ' && s.charAt(p+3) == ' ') {
	    			p += 4;
	    			continue;
	    		}
	    		throw new RuntimeException("wtf!!!");
	    	}
	    	return s.substring(p);
	    }
	    
	    class Node {
	    	// make it hierarchical
	    	Node parent;
	    	// type enumeration: -1 -> unknown, 0 -> dir, 1 -> file
	    	int type = -1;
	    	// anything related to the content
	    	int leadingTabs = -1;
	    	int length = -1;
	    	String content = "";
	    	// dummy constructors
	    	Node() {}
	    	Node(int type) {
	    		this.type = type;
			}
	    	//
	    	boolean isDir() {
	    		return type == 0;
	    	}
	    	boolean isFile() {
	    		return type == 1;
	    	}
	    }
	    
	}

}
