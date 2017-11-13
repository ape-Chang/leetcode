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
//		assertThat(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"), equalTo(32));
		assertThat(solution.lengthLongestPath("dir\n\tfile.txt"), equalTo(12));
	}
	
	class Solution {
	    public int lengthLongestPath(String input) {
	    	Node root = new Node(), p = root;
	        String[] entries = input.split("\n");
	        int longest = 0;
	        for (String entry : entries) {
	        	int countOfIndent = countOfLeadingTab(entry);
	        	
	        	while (p.countOfIndent >= countOfIndent) {
	        		p = p.parent;
	        	}
	        	
	        	Node q = new Node();
	        	q.parent = p;
        		q.filename = entry.trim();
        		q.countOfIndent = countOfIndent;
        		q.lengthOfPath = p.lengthOfPath + q.filename.length();

        		if (q.filename.indexOf('.') > 0) {
        			longest = Math.max(longest, q.lengthOfPath);
        		} else {
        			q.filename = q.filename + "/";
        			q.lengthOfPath++;
        		}
        		
        		p = q;
	        }
	        
	        return longest;
	    }
	    
	    int countOfLeadingTab(String s) {
	    	int count = 0, i = 0;
	    	while (true) {
	    		if (s.charAt(i) == '\t') {
	    			++i;
	    			++count;
	    		} else if (s.charAt(i) == ' ') {
	    			i += 4;
	    			++count;
	    		} else {
	    			break;
	    		}
	    	}
	    	return count;
	    }
	    
	    class Node {
	    	Node parent;
	    	String filename;
	    	
	    	// 
	    	int countOfIndent = -1;
	    	int lengthOfPath;
	    }
	}

}
